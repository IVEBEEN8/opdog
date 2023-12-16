package com.opdoghoho.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.opdoghw.login.LoginDAO;
import com.opdoghw.login.LoginDTO;

public class MyPageDAO {

	public static void dogLike(HttpServletRequest request, HttpServletResponse response) {
		HttpSession hs = request.getSession();
		LoginDTO account = (LoginDTO) request.getSession().getAttribute("account");
		JSONParser jp = new JSONParser();
		String aa = request.getParameter("value");
		try {
			JSONObject bb = (JSONObject) jp.parse(aa);
			System.out.println(bb);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(aa);
		System.out.println("-----------");
		System.out.println(account.getNo());
	}

}
