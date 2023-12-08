package com.opdoghw.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opdoghw.centerinfo.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class LoginDAO {

	public static void LoginAccount(HttpServletRequest request) {
			
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		String sql  = "select * from opdogaccount_test where op_email=?";
			
		try {
			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			
	
			String result = "";
			String dbPW="";
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			System.out.println("연결성공!!");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPW = rs.getString("op_pw");
				if (pw.equals(dbPW)) {
					result = "로그인 성공!";
					
					LoginDTO account = new LoginDTO();
					
					account.setEmail(email);
					account.setPw(pw);
					
					HttpSession hs = request.getSession();
					
					//세션에 account information 담아서 보내기.
					hs.setAttribute("account", account);
					hs.setMaxInactiveInterval(30);
				
				
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
			DBManager.close(con, pstmt, rs);
		}
}

	public static void regAccount(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql ="insert into opdogaccount_test values(?, ?, ?, ?)";
		LoginDTO accountInfo = null;
		
		try {
			request.setCharacterEncoding("utf-8");	
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			String email = request.getParameter("email");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String pw = request.getParameter("pw");
			
			System.out.println(email);
			System.out.println(firstname);
			System.out.println(lastname);
			System.out.println(pw);
					
			pstmt.setString(1, email);
			pstmt.setString(2, firstname);
			pstmt.setString(3, lastname);
			pstmt.setString(4, pw);

			accountInfo= new LoginDTO();
			accountInfo.setEmail(email);
			accountInfo.setFirstname(firstname);
			accountInfo.setLastname(lastname);
			accountInfo.setPw(pw);
			
			request.setAttribute("accountInfo", accountInfo);
					
			
			if (pstmt.executeUpdate() ==1) {
				System.out.println("회원가입성공!");
				request.getSession().setAttribute("result", "회원가입이 완료되었습니다.");
				request.getSession().setMaxInactiveInterval(180);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("회원가입실패!");
			request.getSession().setAttribute("result", "회원가입에 실패하셨습니다..");
			request.getSession().setMaxInactiveInterval(180);
		}finally {
			DBManager.close(con, pstmt, null);
		}
	
	}
		
}

