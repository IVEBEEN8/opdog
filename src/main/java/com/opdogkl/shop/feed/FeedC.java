package com.opdogkl.shop.feed;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghw.login.LoginDAO;
import com.opdogkl.shop.fashion.FashionDAO;

import javax.servlet.annotation.WebServlet;

@WebServlet("/FeedC")
public class FeedC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 강아지 사료 전체 조회하는일
		FeedDAO.getAllFeed(request);
		FeedDAO.paging(1, request);
		
		request.setAttribute("contentPage", "../2_shop/2_2_feed/feed.jsp");
		LoginDAO.loginCheck(request);
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
