package com.opdoghw.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.opdoghw.centerinfo.DBManager_khw;


public class LoginDAO {

	public static void LoginAccount(HttpServletRequest request) {
			
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		String sql  = "select * from opdogaccount where a_email=?";
			
		try {
			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			
	
			String result = "";
			String dbPW="";
			
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			System.out.println("연결성공!!");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPW = rs.getString("a_pw");
				if (pw.equals(dbPW)) {
					result = "로그인 성공!";
					
					LoginDTO account = new LoginDTO();
					
					account.setEmail(email);
					account.setPw(pw);
					account.setFirstname(rs.getString("a_firstname"));
					account.setLastname(rs.getString("a_lastname"));
					account.setNo(rs.getInt("a_no"));
					
					HttpSession hs = request.getSession();
					
					//세션에 account information 담아서 보내기.
					hs.setAttribute("account", account);
					hs.setMaxInactiveInterval(60*60*12);
				
				
				}else {
					result = "비번 오류!";
				}
			}else {
				result = "존재하지 않는 회원입니다.";
			}
			//로그인 성공 실패 화면출력을 위함.
			request.setAttribute("result", result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
}

	public static void regAccount(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql ="insert into opdogaccount values(opdogaccount.nextval,?, ?, ?, ?)";
		LoginDTO accountInfo = null;
		
		try {
			request.setCharacterEncoding("utf-8");	
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			String email = request.getParameter("email");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String pw = request.getParameter("pw");
			String pwck = request.getParameter("pwCheck");
			System.out.println(email);
			System.out.println(firstname);
			System.out.println(lastname);
			System.out.println(pw);
			System.out.println(pwck);
			if (pw.equals(pwck)) {
				
				pstmt.setString(1, email);
				pstmt.setString(2, firstname);
				pstmt.setString(3, lastname);
				pstmt.setString(4, pw);
				
				
				
				request.setAttribute("accountInfo", accountInfo);
				
				if (pstmt.executeUpdate() ==1) {
					System.out.println("회원가입성공!");
					request.setAttribute("result", "회원가입이 완료되었습니다.");
				}
			} else {
				System.out.println("패스워드 체크 확인!");
				request.setAttribute("result", "비밀번호 확인을 해주십시오.");
			}	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("회원가입실패!");
			request.setAttribute("result", "회원가입에 실패하셨습니다..");
		} finally {
			DBManager_khw.close(con, pstmt, null);
		}
	
	}
	
	public static void loginCheck(HttpServletRequest request) {
		LoginDTO account = (LoginDTO)request.getSession().getAttribute("account");
		if (account ==  null) {
			request.setAttribute("loginLogoutBtn", "login/header-loginSignup.jsp");
		}else {
 			request.setAttribute("loginLogoutBtn", "login/header-logoutMypage.jsp");
 			
		}
		
	}
		
}

