package com.opdoghj.volunteer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VtPageC")
public class VtPageC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전체 포스트 조회
		VolunteerDAO.getAllpost(request);
		
		//페이징 하는 일
		int p = Integer.parseInt(request.getParameter("p")); 
		VolunteerDAO.Paging(p, request);
		
		request.setAttribute("contentPage", "../3_volunteer/volunteerSeoul.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
