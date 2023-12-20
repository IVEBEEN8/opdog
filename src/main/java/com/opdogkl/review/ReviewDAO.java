package com.opdogkl.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opdogkl.shop.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewDAO {

	public static void getAllReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from review_kl";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Review r = null;
			ArrayList<Review> reviews = new ArrayList<Review>();
			
			while(rs.next()) {
				r = new Review();
				r.setR_img(rs.getString("r_img"));
				r.setR_title(rs.getString("r_title"));
				r.setR_txt(rs.getString("r_txt"));
				r.setR_created(rs.getDate("r_created"));
				r.setR_updated(rs.getDate("r_updated"));
				r.setOp_email(rs.getString("op_email"));
				reviews.add(r);
				System.out.println(rs.getString("r_img"));
			}
			request.setAttribute("reviews", reviews);
			System.out.println("전체 리뷰 어트리뷰트 생성");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("전체 리뷰 조회 실패");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void regReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
									// img/title/txt/created/updated/op_email(foreign key)
		String sql = "insert into review_kl values (?,?,?,sysdate,sysdate,review_kl_seq.nextval)";
		String path = request.getServletContext().getRealPath("1_adopt/1_4_review/imgFolder");
		System.out.println(path);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager.connect();
			request.setCharacterEncoding("utf-8");	
			
			// 세션에서 op_email 값을 가져오기
//	        HttpSession session = request.getSession();
//	        String op_email = (String) session.getAttribute("op_email");
			
	        // 임시 email 
//	        String op_email = "review_kl_seq.nextval";
	        
	        MultipartRequest mr  = new MultipartRequest(request, path, 30*1024*1024,"utf-8", new DefaultFileRenamePolicy());
			String img = mr.getFilesystemName("fileInput");
			String title = mr.getParameter("title");
			String txt = mr.getParameter("txt");
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, img);
			System.out.println(img);
			pstmt.setString(2, title);
			pstmt.setString(3, txt);
//			pstmt.setString(4, op_email);	// 세션에서 가져온 op_email 값 사용
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("등록 실패");
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}


	public static void getReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from review_kl where op_email=?";
		Review r = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("id"));
			rs = pstmt.executeQuery();	
			
			if (rs.next()) {
				r = new Review();
				r.setR_img(rs.getString("r_img"));
				r.setR_title(rs.getString("r_title"));
				r.setR_txt(rs.getString("r_txt"));
				r.setR_created(rs.getDate("r_created"));
				r.setR_updated(rs.getDate("r_updated"));
				r.setOp_email(rs.getString("op_email"));
				
				request.setAttribute("review", r);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void upReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update review_kl"
					+" set r_img=?, r_title=?, r_txt=?, r_updated=SYSDATE"
					+" where op_email=?";
		String path = request.getServletContext().getRealPath("1_adopt/1_4_review/imgFolder");
		System.out.println(path);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager.connect();
			request.setCharacterEncoding("utf-8");	
	        
	        MultipartRequest mr  = new MultipartRequest(request, path, 30*1024*1024,"utf-8", new DefaultFileRenamePolicy());
			String oldImg = mr.getParameter("oldImg");
			String newImg = mr.getFilesystemName("newImg");
			String title = mr.getParameter("title");
			String txt = mr.getParameter("txt");
			System.out.println(oldImg);
			System.out.println(newImg);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newImg);
			pstmt.setString(2, title);
			pstmt.setString(3, txt);
			pstmt.setString(4, mr.getParameter("id"));
			System.out.println(mr.getParameter("id"));
//			pstmt.setDate(4, op_email);	// 세션에서 가져온 op_email 값 사용
			
			if (newImg != null) {
				pstmt.setString(1, newImg);
			}else {
				pstmt.setString(1, oldImg);
			}
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("수정 성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 실패");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
	}

	public static void delReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete review_kl where op_email=?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("id"));
			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제 성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제 실패");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}	
}
