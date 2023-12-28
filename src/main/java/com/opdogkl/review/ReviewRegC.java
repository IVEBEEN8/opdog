package com.opdogkl.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReviewRegC")
public class ReviewRegC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//리뷰 등록페이지(reviewReg.jsp) 보여주기
		request.setAttribute("contentPage", "../1_adopt/1_4_review/reviewReg.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//리뷰 등록하는일 
		ReviewDAO.regReview(request);
//		ReviewDAO.getAllReview(request);
//		request.setAttribute("contentPage", "../1_adopt/1_4_review/review.jsp");
//		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
		response.sendRedirect("ReviewC");
		
	
	}

}
