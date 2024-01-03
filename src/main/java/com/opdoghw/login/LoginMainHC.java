package com.opdoghw.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginMainHC")
public class LoginMainHC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("contentPage", "login/loginMain.jsp");
		request.setAttribute("loginLogoutBtn", "login/header-loginSignup.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDAO.LoginAccount(request);
		int result = LoginDAO.idPwCheck(request);
		if (result == 0) {
			request.setAttribute("contentPage", "login/loginMain.jsp");
			LoginDAO.loginCheck(request);
			request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
		} else if (result == 1) {
			request.setAttribute("contentPage", "login/loginMain.jsp");
			LoginDAO.loginCheck(request);
			request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
		} else if (result == 2) {
			response.sendRedirect("HC");
//			String currentPage = request.getRequestURI();
//			String previousPage = SessionManager.getPreviousPage(request);
//			String beforePreviousPage = SessionManager.getBeforePreviousPage(request);
//			SessionManager.setBeforePreviousPage(request, previousPage);
//			SessionManager.setPreviousPage(request, currentPage);
//			System.out.println(currentPage);
//			System.out.println(previousPage);
//			System.out.println(beforePreviousPage);
//			response.sendRedirect(previousPage != null ? previousPage : request.getContextPath() + "HC");

		}
	}
}
