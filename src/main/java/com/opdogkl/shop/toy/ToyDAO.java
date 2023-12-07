package com.opdogkl.shop.toy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.opdogkl.shop.DBManager;

public class ToyDAO {

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
			ArrayList<Toy> toys = new ArrayList<Toy>();
			
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

}
