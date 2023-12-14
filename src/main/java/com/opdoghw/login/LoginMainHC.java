package com.opdoghw.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginMainHC")
public class LoginMainHC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setAttribute("contentPage", "login/loginMain.jsp");
	request.setAttribute("loginLogoutBtn", "login/header-loginSignup.jsp");
	request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	LoginDAO.LoginAccount(request);
	LoginDAO.loginCheckMain(request);
	request.getRequestDispatcher("0_main/main.jsp").forward(request, response);
	
	
	
	}


}
