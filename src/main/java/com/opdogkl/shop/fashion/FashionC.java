package com.opdogkl.shop.fashion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/FashionC")
public class FashionC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 강아지 패션 전체 조회하는일
		FashionDAO.getAllFashion(request);
		
		request.setAttribute("contentPage", "fashion.jsp");
		request.getRequestDispatcher("lkl/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
