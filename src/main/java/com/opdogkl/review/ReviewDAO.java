package com.opdogkl.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.opdogkl.shop.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewDAO {

	public static void getAllReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from review_table";
		
	}

	public static void regReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
									// img/title/txt/created/updated/op_email(foreign key)
		String sql = "insert into review_table values (?,?,?,sysdate,sysdate,?)";
		String path = request.getServletContext().getRealPath("1_adopt/1_4_review/imgFolder");
		System.out.println(path);
		try {
			con = DBManager.connect();
			request.setCharacterEncoding("utf-8");	
			MultipartRequest mr  = new MultipartRequest(request, path, 30*1024*1024,"utf-8", new DefaultFileRenamePolicy());
			String img = mr.getParameter("img");
			String title = mr.getParameter("title");
			String txt = mr.getParameter("txt");
			String id = request.getParameter()
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, img);
			pstmt.setString(2, title);
			pstmt.setString(3, txt);
			pstmt.setString(4,	 );
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}


	public static void getReview(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	public static void upReview(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	public static void delReview(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}
}
