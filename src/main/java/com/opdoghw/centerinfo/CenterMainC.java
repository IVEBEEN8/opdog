package com.opdoghw.centerinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CenterMainC")
public class CenterMainC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CenterInfoDAO.getCenterInfo(request);
		request.getRequestDispatcher("1_adopt/1_2_shelter/centerinfodetail.jsp").forward(request, response);
		// request.setAttribute("contentPage",
		// "../1_adopt/1_2_shelter/centerinfodetail.jsp");
		// request.setAttribute("loginLogoutBtn", "login/header-loginSignup.jsp");
		// request.getRequestDispatcher("0_main/contentPage.jsp").forward(request,
		// response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
