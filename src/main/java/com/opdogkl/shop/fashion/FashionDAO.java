package com.opdogkl.shop.fashion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.opdogkl.shop.DBManager;

public class FashionDAO {
	// 강아지 패션 전체 조회하는 일
	


	
	public static void getAllFashion(HttpServletRequest request) {
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from fashion_test";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Fashion fs = null;
			ArrayList<Fashion> fashions = new ArrayList<Fashion>();
			
			while(rs.next()) {
				fs = new Fashion();
				fs.setFs_no(rs.getInt("fs_no"));
				fs.setFs_img(rs.getString("fs_img"));
				fs.setFs_title(rs.getString("fs_title"));
				fs.setFs_price(rs.getInt("fs_price"));
				fs.setFs_brand(rs.getString("fs_brand"));
				
				System.out.println(rs.getString("fs_title"));
				System.out.println(rs.getInt("fs_price"));
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
	
}
