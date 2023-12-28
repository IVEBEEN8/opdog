package com.opdoghw.askaboutdog;

import javax.servlet.http.HttpServletRequest;

public class askAnythingDAO {

	public static void askAnything(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			String askanything = request.getParameter("askanything");
			System.out.println(askanything);
			request.setAttribute("askanything", askanything);

//			HttpSession askss = request.getSession();
//			askAnythingDTO askInput = new askAnythingDTO();
//			askInput.setAskanything(askanything);
//			askss.setAttribute("askInput", askInput);
//			askss.setMaxInactiveInterval(60 * 60 * 12);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
