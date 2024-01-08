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
		String referer = request.getHeader("Referer");
		System.out.println(referer);
		if (referer != null) {
			int last = referer.lastIndexOf("/");
			System.out.println(last);
			if (last != -1) {
				String ev = referer.substring(last + 1);
				System.out.println(ev);
				request.setAttribute("lastS", ev);

			}
		}

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
			String url = request.getParameter("url");
			if (url.equals("") || url.equals("SignUpC")) {
				response.sendRedirect("HC");
			} else {
				System.out.println("URL입니다:" + url);
				response.sendRedirect(url);
			}

		}
	}
}
