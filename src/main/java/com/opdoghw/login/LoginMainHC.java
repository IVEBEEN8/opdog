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
//			String previousPage = (String) request.getSession().getAttribute("previousPage");
//			if (previousPage != null && !previousPage.isEmpty()) {
//				response.sendRedirect(previousPage);
//			} else {
//				// 이동할 이전 페이지가 없을 경우 기본 페이지로 리다이렉트
//				response.sendRedirect(request.getContextPath() + "home.jsp");
//			}

		}
	}
}
