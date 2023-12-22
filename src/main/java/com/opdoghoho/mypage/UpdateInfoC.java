package com.opdoghoho.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghoho.doginfo.DoginfoDAO;
@WebServlet("/UpdateInfoC")
public class UpdateInfoC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoginfoDAO.sido(request); // 시/도 어트리뷰 세팅 메서드
		request.getRequestDispatcher("0_main/myPage/changeInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블렛 까진 왔음.");
		MyPageDAO.updateInfo(request);

	}

}
