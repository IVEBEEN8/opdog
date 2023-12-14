package com.opdoghw.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUpC")
public class SignUpC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("contentPage", "login/accountMain.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginDAO.regAccount(request);

		request.setAttribute("contentPage", "0_main/login/accountOK.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);

	}

}
