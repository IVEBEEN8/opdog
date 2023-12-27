package com.opdoghw.askaboutdog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghw.login.LoginDAO;

@WebServlet("/AskAboutDogMainC")
public class AskAboutDogMainC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("contentPage", "../4_service/4_3_askAnything/askAboutDog.jsp");
		// request.setAttribute("loginLogoutBtn", "login/header-loginSignup.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDAO.loginCheck(request);
		System.out.println(request.getParameter("askanything"));
		response.setCharacterEncoding("utf-8");
		askAnythingDAO.askAnything(request);
		request.setAttribute("contentPage", "../4_service/4_3_askAnything/askAboutDog.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);

	}

}
