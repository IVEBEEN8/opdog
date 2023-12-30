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

	
public static void getFeed(HttpServletRequest request) {
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from feed_kl where f_no=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();
			Feed f = null;
			
			if (rs.next()) {
				f = new Feed();
				f.setF_no(rs.getInt("f_no"));
				f.setF_img(rs.getString("f_img"));
				f.setF_title(rs.getString("f_title"));
				f.setF_price(rs.getInt("f_price"));
				f.setF_brand(rs.getString("f_brand"));
				
				System.out.println(rs.getString("f_title"));
				System.out.println(rs.getString("f_brand"));
				
				
			}
			request.setAttribute("feed", f);
			System.out.println("사료 어트리뷰트 생성!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
	}



public static void searchFeed(HttpServletRequest request) {
	
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String search = request.getParameter("search");
//	String sql = "select * from fashion_kl where fs_title like '%" + search +"%'";
	String sql = "select * from feed_kl where lower(f_title) like lower('%"+search+"%') or lower(f_brand) like lower('%"+search+"%')";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DBManager_khw.connect();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		Feed f = null;
		feeds = new ArrayList<Feed>();
		
		if (rs.next()) {
				do {
					f = new Feed();
					f.setF_no(rs.getInt("f_no"));
					f.setF_img(rs.getString("f_img"));
					f.setF_title(rs.getString("f_title"));
					f.setF_price(rs.getInt("f_price"));
					f.setF_brand(rs.getString("f_brand"));
					
					System.out.println(rs.getString("f_title"));
					System.out.println(rs.getString("f_brand"));
					feeds.add(f);
					
					}
			
				while(rs.next());
			request.setAttribute("feeds", feeds);
			System.out.println("검색된 사료 어트리뷰트 생성!");
			
		} else {
			getAllFeed(request); // 검색 결과가 없으면 getAllFashion() 호출
            request.setAttribute("message","No results were found for your search : " + search); // 메시지 설정
            System.out.println("검색결과없음");
		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBManager_khw.close(con, pstmt, rs);
	}
	
}

public static void sortFeed(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "";
			String asc = "select * from feed_kl order by f_price asc";		// 높은가격순
			String desc = "select * from feed_kl order by f_price desc";	// 낮은가격순
			
			// 요청에서 정렬 값 가져오기
		    String sort = request.getParameter("sort");
			
			if ("high".equals(sort)) {
		        sql = "select * from feed_kl order by f_price desc"; // 낮은가격순
		    } else if ("low".equals(sort)) {
		        sql = "select * from feed_kl order by f_price asc";  // 높은가격순
		    } else {
		        // 유효한 값이 제공되지 않은 경우 기본 정렬 처리
		        sql = "select * from feed_kl"; // 기본 정렬
		    }
			
			
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
					System.out.println(rs.getString("f_brand"));
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
	
	

}
