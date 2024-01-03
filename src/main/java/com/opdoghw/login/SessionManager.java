package com.opdoghw.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager {
	// 세션에 이전 페이지 URL 저장
	public static void setPreviousPage(HttpServletRequest request, String previousPage) {
		HttpSession session = request.getSession();
		session.setAttribute("previousPage", previousPage);
	}

	// 세션에서 이전 페이지 URL 가져오기
	public static String getPreviousPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("previousPage");
	}

	// 세션에 전전 페이지 URL 저장
	public static void setBeforePreviousPage(HttpServletRequest request, String beforePreviousPage) {
		HttpSession session = request.getSession();
		session.setAttribute("beforePreviousPage", beforePreviousPage);
	}

	// 세션에서 전전 페이지 URL 가져오기
	public static String getBeforePreviousPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("beforePreviousPage");
	}
}