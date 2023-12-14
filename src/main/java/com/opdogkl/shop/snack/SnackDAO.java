package com.opdogkl.shop.snack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.opdogkl.shop.DBManager;

public class SnackDAO {
	
	private static ArrayList<Snack> snacks;

	public static void getAllSnack(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from snack_kl";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Snack s = null;
			snacks = new ArrayList<Snack>();
			
			while(rs.next()) {
				s = new Snack();
				s.setS_no(rs.getInt("s_no"));
				s.setS_img(rs.getString("s_img"));
				s.setS_title(rs.getString("s_title"));
				s.setS_price(rs.getInt("s_price"));
				s.setS_brand(rs.getString("s_brand"));
				
				
				System.out.println(rs.getString("s_title"));
				System.out.println(rs.getInt("s_price"));
				snacks.add(s);
				
				
			}
			request.setAttribute("snacks", snacks);
			System.out.println("어트리뷰트 생성!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void paging(int page, HttpServletRequest request) {
		request.setAttribute("curPageNo", page);
		int cnt = 15; 		// 한페이지당 보여줄 개수
		int total = snacks.size();		// 총 데이터 개수 
		// 총페이지수 
		int pageCount = (int) Math.ceil((double)total/cnt);
		request.setAttribute("pageCount", pageCount);
		
		
		int start = total - (cnt * (page - 1));
		
		int end = (page == pageCount) ? -1 : start - (cnt + 1);
		
		ArrayList<Snack> items = new ArrayList<Snack>();
		for (int i = start-1; i > end; i--) {
			items.add(snacks.get(i));
		}
		request.setAttribute("snacks", items);
	}

}
