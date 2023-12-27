package com.opdoghj.volunteer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VolSearchSC")
public class VolSearchSC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VolunteerDAO.searchCenter(request, response);
		request.setAttribute("contentPage", "../3_volunteer/volunteerSeoul.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	}

}
