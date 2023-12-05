package com.opdogkl.shop.feed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.opdogkl.shop.DBManager;

public class FeedDAO {

	public static void getAllFeed(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from feed_test";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Feed f = null;
			ArrayList<Feed> feeds = new ArrayList<Feed>();
			
			while(rs.next()) {
				f = new Feed();
				f.setF_no(rs.getInt("f_no"));
				f.setF_img(rs.getString("f_img"));
				f.setF_title(rs.getString("f_title"));
				f.setF_price(rs.getInt("f_price"));
				f.setF_brand(rs.getString("f_brand"));
				
				
				System.out.println(rs.getString("f_title"));
				System.out.println(rs.getInt("f_price"));
				feeds.add(f);
				
				
			}
			request.setAttribute("feeds", feeds);
			System.out.println("어트리뷰트 생성!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

}
