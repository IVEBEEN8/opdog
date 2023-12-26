package com.opdogkl.shop.toy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghw.login.LoginDAO;
import com.opdogkl.shop.snack.SnackDAO;

import javax.servlet.annotation.WebServlet;

@WebServlet("/ToyC")
public class ToyC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 강아지 장난감 전체 조회하는일
		ToyDAO.getAllToy(request);
		ToyDAO.paging(1, request);
		
		request.setAttribute("contentPage", "../2_shop/2_4_toy/toy.jsp");
		LoginDAO.loginCheck(request);
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
