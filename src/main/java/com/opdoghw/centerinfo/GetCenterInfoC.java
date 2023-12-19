package com.opdoghw.centerinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCenterInfoC")
public class GetCenterInfoC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CenterInfoDAO.getCenterInfo(request);
		request.setAttribute("contentPage", "1_adopt/1_2_shelter/centerinfodetail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
