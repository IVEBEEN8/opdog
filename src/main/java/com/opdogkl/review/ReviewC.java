package com.opdogkl.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghw.login.LoginDAO;


@WebServlet("/ReviewC")
public class ReviewC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리뷰 전체 조회하는 일
		
		ReviewDAO.getAllReview(request);
		ReviewDAO.paging(1, request);
		request.setAttribute("contentPage", "../1_adopt/1_4_review/review.jsp");
		LoginDAO.loginCheck(request);
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
