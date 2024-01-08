package com.opdoghoho.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghj.volunteer.VolunteerDAO;
import com.opdoghw.login.LoginDAO;

@WebServlet("/MyPageHC")
public class MyPageHC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("contentPage", "../0_main/myPage/myPageMain.jsp");
		LoginDAO.loginCheck(request);
		MyPageDAO.likeLoad(request,response);
//		MyPageDAO.pointLoad(request,response);
		VolunteerDAO.appliedLoad(request);
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
