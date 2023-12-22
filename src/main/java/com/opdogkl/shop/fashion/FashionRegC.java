package com.opdogkl.shop.fashion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FashionRegC")
public class FashionRegC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FashionDAO.regFashion(request);
		FashionDAO.getAllFashion(request);
		FashionDAO.paging(1, request);
		
		request.setAttribute("contentPage", "../2_shop/2_1_fashion/fashion.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
