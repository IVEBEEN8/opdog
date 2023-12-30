package com.opdogkl.shop.toy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.opdoghw.centerinfo.DBManager_khw;

public class ToyDAO {
	
	private static ArrayList<Toy> toys;

	public static void getAllToy(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from toy_kl";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager_khw.connect();
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
			DBManager_khw.close(con, pstmt, rs);
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

	
public static void getToy(HttpServletRequest request) {
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from toy_kl where t_no=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();
			Toy t = null;
			
			if (rs.next()) {
				t = new Toy();
				t.setT_no(rs.getInt("t_no"));
				t.setT_img(rs.getString("t_img"));
				t.setT_title(rs.getString("t_title"));
				t.setT_price(rs.getInt("t_price"));
				t.setT_brand(rs.getString("t_brand"));
				
				System.out.println(rs.getString("t_title"));
				System.out.println(rs.getString("t_brand"));
				
				
			}
			request.setAttribute("toy", t);
			System.out.println("장난감 어트리뷰트 생성!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
	}

public static void searchToy(HttpServletRequest request) {
	
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String search = request.getParameter("search");
//	String sql = "select * from fashion_kl where fs_title like '%" + search +"%'";
	String sql = "select * from toy_kl where lower(t_title) like lower('%"+search+"%') or lower(t_brand) like lower('%"+search+"%')";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DBManager_khw.connect();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		Toy t = null;
		toys = new ArrayList<Toy>();
		
		if (rs.next()) {
				do {
					t = new Toy();
					t.setT_no(rs.getInt("t_no"));
					t.setT_img(rs.getString("t_img"));
					t.setT_title(rs.getString("t_title"));
					t.setT_price(rs.getInt("t_price"));
					t.setT_brand(rs.getString("t_brand"));
					
					System.out.println(rs.getString("t_title"));
					System.out.println(rs.getString("t_brand"));
					toys.add(t);
					
					}
			
				while(rs.next());
			request.setAttribute("toys", toys);
			System.out.println("검색된 사료 어트리뷰트 생성!");
			
		} else {
			getAllToy(request); // 검색 결과가 없으면 getAllFashion() 호출
            request.setAttribute("message","No results were found for your search : " + search); // 메시지 설정
            System.out.println("검색결과없음");
		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBManager_khw.close(con, pstmt, rs);
	}
	
}

public static void sortToy(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "";
			String asc = "select * from toy_kl order by t_price asc";		// 높은가격순
			String desc = "select * from toy_kl order by t_price desc";	// 낮은가격순
			
			// 요청에서 정렬 값 가져오기
		    String sort = request.getParameter("sort");
			
			if ("high".equals(sort)) {
		        sql = "select * from toy_kl order by t_price desc"; // 낮은가격순
		    } else if ("low".equals(sort)) {
		        sql = "select * from toy_kl order by t_price asc";  // 높은가격순
		    } else {
		        // 유효한 값이 제공되지 않은 경우 기본 정렬 처리
		        sql = "select * from toy_kl"; // 기본 정렬
		    }
			
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DBManager_khw.connect();
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
					System.out.println(rs.getString("t_brand"));
					toys.add(t);
					
					
				}
				request.setAttribute("toys", toys);
				System.out.println("어트리뷰트 생성!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager_khw.close(con, pstmt, rs);
			}
			
		}

}
