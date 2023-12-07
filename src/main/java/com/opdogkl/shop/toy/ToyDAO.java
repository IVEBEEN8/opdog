package com.opdogkl.shop.toy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.opdogkl.shop.DBManager;

public class ToyDAO {
	
	private static ArrayList<Toy> toys;

	public static void getAllToy(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from toy_test";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Toy t = null;
			toys = new ArrayList<Toy>();
			
			while(rs.next()) {
				t = new Toy();
				t.setT_no(rs.getInt("t_no"));
				t.setT_img(rs.getString("t_img"));
				t.setT_title(rs.getString("t_title"));
				t.setT_price(rs.getInt("t_price"));
				t.setT_brand(rs.getString("t_brand"));
				
				System.out.println(rs.getString("t_title"));
				System.out.println(rs.getInt("t_price"));
				toys.add(t);
				
				
			}
			request.setAttribute("toys", toys);
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
		int total = toys.size();		// 총 데이터 개수 
		// 총페이지수 
		int pageCount = (int) Math.ceil((double)total/cnt);
		request.setAttribute("pageCount", pageCount);
		
		
		int start = total - (cnt * (page - 1));
		
		int end = (page == pageCount) ? -1 : start - (cnt + 1);
		
		ArrayList<Toy> items = new ArrayList<Toy>();
		for (int i = start-1; i > end; i--) {
			items.add(toys.get(i));
		}
		request.setAttribute("toys", items);
	}

}
