package com.opdoghw.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SignUpC")
public class SignUpC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("5_mypage/1_1_login/createYourAccount.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LoginDAO.regAccount(request);
		request.getRequestDispatcher("5_mypage/1_1_login/loginOK.jsp").forward(request, response);
	
	
	}

}
