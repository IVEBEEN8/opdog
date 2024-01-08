package com.opdoghj.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghw.login.LoginDAO;

@WebServlet("/HC")
public class HC extends HttpServlet {
	public static boolean firstLoading = true;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (firstLoading) {
//			DogDbUpdater.updateDb(request);
			firstLoading = false;
		}
		LoginDAO.loginCheckMain(request);
		MainDAO.totalCountLoading(request);
		MainDAO.listLoading(request, response);
		request.getRequestDispatcher("0_main/main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
