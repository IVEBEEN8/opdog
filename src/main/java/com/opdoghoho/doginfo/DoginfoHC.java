package com.opdoghoho.doginfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DoginfoHC")
public class DoginfoHC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoginfoDAO.sido(request); // 시/도 어트리뷰 세팅 메서드
		
		request.setAttribute("contentPage", "../1_adopt/1_1_info/select.jsp");
		request.setAttribute("loginLogoutBtn", "login/header-loginSignup.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
