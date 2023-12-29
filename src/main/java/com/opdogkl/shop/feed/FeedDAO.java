package com.opdogkl.shop.feed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.opdoghw.centerinfo.DBManager_khw;

public class FeedDAO {
	private static ArrayList<Feed> feeds;
	
	public static void getAllFeed(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from feed_kl";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Feed f = null;
			feeds = new ArrayList<Feed>();
			
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
			DBManager_khw.close(con, pstmt, rs);
		}
		
	}

	public static void paging(int page, HttpServletRequest request) {
		request.setAttribute("curPageNo", page);
		int cnt = 15; 		// 한페이지당 보여줄 개수
		int total = feeds.size();		// 총 데이터 개수 
		// 총페이지수 
		int pageCount = (int) Math.ceil((double)total/cnt);
		request.setAttribute("pageCount", pageCount);
		
		
		int start = total - (cnt * (page - 1));
		
		int end = (page == pageCount) ? -1 : start - (cnt + 1);
		
		ArrayList<Feed> items = new ArrayList<Feed>();
		for (int i = start-1; i > end; i--) {
			items.add(feeds.get(i));
		}
		request.setAttribute("feeds", items);
	}
	
	

}
