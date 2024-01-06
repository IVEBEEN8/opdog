package com.opdogkl.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghw.login.LoginDAO;

@WebServlet("/ReviewUpC")
public class ReviewUpC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 디테일 페이지에 있던 그 리뷰 
		ReviewDAO.getReview(request);
		// 수정을 위해 기존 내용 reviewUpdate.jsp 보여주기
		request.setAttribute("contentPage", "../1_adopt/1_4_review/reviewUpdate.jsp");
		LoginDAO.loginCheck(request);
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 리뷰 수정하기 
		ReviewDAO.upReview(request);
		// 수정한 그 리뷰 보여주기
		ReviewDAO.getReview(request);
		request.setAttribute("contentPage", "../1_adopt/1_4_review/reviewDetail.jsp");
		LoginDAO.loginCheck(request);
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
		
		
	}

}
