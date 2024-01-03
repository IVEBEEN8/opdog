package com.opdoghoho.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghj.volunteer.VolunteerDAO;
import com.opdoghw.login.LoginDAO;

@WebServlet("/DeleteFromMyListC")
public class DeleteFromMyListC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDAO.loginCheck(request);
		VolunteerDAO.deleteFromMyList(request);
		VolunteerDAO.appliedLoad(request);
		request.setAttribute("contentPage", "../0_main/myPage/myPageMain.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
		;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
