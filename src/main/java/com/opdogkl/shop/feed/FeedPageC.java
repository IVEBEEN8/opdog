package com.opdogkl.shop.feed;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdogkl.shop.fashion.FashionDAO;

import javax.servlet.annotation.WebServlet;

@WebServlet("/FeedPageC")
public class FeedPageC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 강아지 사료 전체 조회하는일
		FeedDAO.getAllFeed(request);
		int p = Integer.parseInt(request.getParameter("p"));
		FeedDAO.paging(p, request);
		
		request.setAttribute("contentPage", "feed.jsp");
		request.getRequestDispatcher("lkl/index.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
