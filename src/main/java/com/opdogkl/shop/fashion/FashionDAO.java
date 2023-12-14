package com.opdogkl.shop.fashion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.opdogkl.shop.DBManager;

public class FashionDAO {
	// 강아지 패션 전체 조회하는 일
	private static ArrayList<Fashion> fashions;
	


	
	public static void getAllFashion(HttpServletRequest request) {
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from fashion_kl";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Fashion fs = null;
			fashions = new ArrayList<Fashion>();
			
			while(rs.next()) {
				fs = new Fashion();
				fs.setFs_no(rs.getInt("fs_no"));
				fs.setFs_img(rs.getString("fs_img"));
				fs.setFs_title(rs.getString("fs_title"));
				fs.setFs_price(rs.getInt("fs_price"));
				fs.setFs_brand(rs.getString("fs_brand"));
				
				System.out.println(rs.getString("fs_title"));
				System.out.println(rs.getString("fs_brand"));
				fashions.add(fs);
				
				
			}
			request.setAttribute("fashions", fashions);
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
		int total = fashions.size();		// 총 데이터 개수 
		// 총페이지수 
		int pageCount = (int) Math.ceil((double)total/cnt);
		request.setAttribute("pageCount", pageCount);
		
		
		int start = total - (cnt * (page - 1));
		
		int end = (page == pageCount) ? -1 : start - (cnt + 1);
		
		ArrayList<Fashion> items = new ArrayList<Fashion>();
		for (int i = start-1; i > end; i--) {
			items.add(fashions.get(i));
		}
		request.setAttribute("fashions", items);
	}
	
}
