package com.opdogkl.shop.snack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.opdoghw.centerinfo.DBManager_khw;

public class SnackDAO {
	
	private static ArrayList<Snack> snacks;

	public static void getAllSnack(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from snack_kl";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager_khw.connect();
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
			
			// fashions 리스트를 JSON 형식으로 변환
		    String jsonSnacks = new Gson().toJson(snacks);
		    // JSON 데이터를 request에 추가
		    request.setAttribute("jsonSnacks", jsonSnacks);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
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

	
public static void getSnack(HttpServletRequest request) {
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from snack_kl where s_no=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();
			Snack s = null;
			
			if (rs.next()) {
				s = new Snack();
				s.setS_no(rs.getInt("s_no"));
				s.setS_img(rs.getString("s_img"));
				s.setS_title(rs.getString("s_title"));
				s.setS_price(rs.getInt("s_price"));
				s.setS_brand(rs.getString("s_brand"));
				
				System.out.println(rs.getString("s_title"));
				System.out.println(rs.getString("s_brand"));
				
				
			}
			request.setAttribute("snack", s);
			System.out.println("간식 어트리뷰트 생성!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
	}


public static void searchSnack(HttpServletRequest request) {
	
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String search = request.getParameter("search");
//	String sql = "select * from fashion_kl where fs_title like '%" + search +"%'";
	String sql = "select * from snack_kl where lower(s_title) like lower('%"+search+"%') or lower(s_brand) like lower('%"+search+"%')";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DBManager_khw.connect();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		Snack s = null;
		snacks = new ArrayList<Snack>();
		
		if (rs.next()) {
				do {
					s = new Snack();
					s.setS_no(rs.getInt("s_no"));
					s.setS_img(rs.getString("s_img"));
					s.setS_title(rs.getString("s_title"));
					s.setS_price(rs.getInt("s_price"));
					s.setS_brand(rs.getString("s_brand"));
					
					System.out.println(rs.getString("s_title"));
					System.out.println(rs.getString("s_brand"));
					snacks.add(s);
					
					}
			
				while(rs.next());
			request.setAttribute("snacks", snacks);
			System.out.println("검색된 사료 어트리뷰트 생성!");
			
			// fashions 리스트를 JSON 형식으로 변환
		    String jsonSnacks = new Gson().toJson(snacks);
		    // JSON 데이터를 request에 추가
		    request.setAttribute("jsonSnacks", jsonSnacks);
			
		} else {
			getAllSnack(request); // 검색 결과가 없으면 getAllFashion() 호출
            request.setAttribute("message","No results were found for your search : " + search); // 메시지 설정
            System.out.println("검색결과없음");
		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBManager_khw.close(con, pstmt, rs);
	}
	
}

public static void sortSnack(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "";
			String asc = "select * from snack_kl order by s_price asc";		// 높은가격순
			String desc = "select * from snack_kl order by s_price desc";	// 낮은가격순
			
			// 요청에서 정렬 값 가져오기
		    String sort = request.getParameter("sort");
		    // 체크된 radio button 정보 전달
		    request.setAttribute("checkedRadio", sort);
			
			if ("high".equals(sort)) {
		        sql = "select * from snack_kl order by s_price desc"; // 낮은가격순
		    } else if ("low".equals(sort)) {
		        sql = "select * from snack_kl order by s_price asc";  // 높은가격순
		    } else {
		        // 유효한 값이 제공되지 않은 경우 기본 정렬 처리
		        sql = "select * from snack_kl"; // 기본 정렬
		    }
			
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DBManager_khw.connect();
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
					System.out.println(rs.getString("s_brand"));
					snacks.add(s);
					
					
				}
				request.setAttribute("snacks", snacks);
				System.out.println("어트리뷰트 생성!");
				
				
				// fashions 리스트를 JSON 형식으로 변환
			    String jsonSnacks = new Gson().toJson(snacks);
			    // JSON 데이터를 request에 추가
			    request.setAttribute("jsonSnacks", jsonSnacks);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager_khw.close(con, pstmt, rs);
			}
			
		}


}
