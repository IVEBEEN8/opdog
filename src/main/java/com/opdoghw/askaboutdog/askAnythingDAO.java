package com.opdoghw.askaboutdog;

import javax.servlet.http.HttpServletRequest;

public class askAnythingDAO {

	public static void askAnything(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			String askanything = request.getParameter("askanything");
			System.out.println(askanything);
			request.setAttribute("askanything", askanything);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
