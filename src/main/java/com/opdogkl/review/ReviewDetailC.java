package com.opdogkl.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghw.login.LoginDAO;

@WebServlet("/ReviewDetailC")
public class ReviewDetailC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  그 리뷰를 조희해서
		ReviewDAO.getReview(request);
		LoginDAO.loginCheck(request);
		
		// 리뷰 디테일 페이지 보여주기 
		request.setAttribute("contentPage", "../1_adopt/1_4_review/reviewDetail.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
