package com.opdogkl.shop.snack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.opdogkl.shop.DBManager;

public class SnackDAO {

	public static void getAllSnack(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from snack_test";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Snack s = null;
			ArrayList<Snack> snacks = new ArrayList<Snack>();
			
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

}
