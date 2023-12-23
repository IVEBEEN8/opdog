package com.opdoghw.login;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

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
			HttpSession hs = request.getSession();
			LoginDTO account = new LoginDTO();
			
			if(rs.next()) {
				dbPW = rs.getString("a_password");
				if (pw.equals(dbPW)) {
					result = "로그인 성공!";
					
					String upr[] = rs.getString("a_uprCd").split(",");
					String org[] = rs.getString("a_orgCd").split(",");
					
					account.setEmail(email);
					account.setPw(pw);
					account.setFirstname(rs.getString("a_firstname"));
					account.setLastname(rs.getString("a_lastname"));
					account.setNo(rs.getInt("a_no"));
					account.setUprCd(upr[0]);
					account.setUprText(upr[1]);
					account.setOrgCd(org[0]);
					account.setOrgText(org[1]);
					account.setResult("ok");
					
					
					//세션에 account information 담아서 보내기.
					hs.setAttribute("account", account);
					hs.setMaxInactiveInterval(60*60*12);
				
				
				}else {
					account.setResult("password");
					hs.setAttribute("account", account);
					System.out.println("비번 오류");
					
				}
			}else {
				account.setResult("id");
				hs.setAttribute("account", account);
				System.out.println("아이디 확인");
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
		String sql ="insert into opdogaccount values(opdogaccount_seq.nextval,?, ?, ?, ?, ?, ?)";
		LoginDTO accountInfo = null;
		
		try {
			request.setCharacterEncoding("utf-8");	
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			String email = request.getParameter("id");
			String firstname = request.getParameter("firstName");
			String lastname = request.getParameter("lastName");
			String pw = request.getParameter("pw");
			String pwck = request.getParameter("pwCheck");
			String uprCd = request.getParameter("sido");
			String uprText = request.getParameter("sidotext");
			String orgCd = request.getParameter("sigun");
			String orgText = request.getParameter("siguntext");
			System.out.println(email);
			System.out.println(firstname);
			System.out.println(lastname);
			System.out.println(pw);
			System.out.println(pwck);
			System.out.println(uprCd);
			System.out.println(orgCd);
			if (pw.equals(pwck)) {
				
				pstmt.setString(1, email);
				pstmt.setString(2, firstname);
				pstmt.setString(3, lastname);
				pstmt.setString(4, pw);
				pstmt.setString(5, uprCd+","+uprText);
				pstmt.setString(6, orgCd+","+orgText);
				
				
				
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
	
	
	
	public static int idPwCheck(HttpServletRequest request) {
		String alert = null;
		HttpSession hs = request.getSession();
		LoginDTO account = (LoginDTO)request.getSession().getAttribute("account");
		if (account.getResult().equals("id")) {
			alert = "Check your ID!";
			request.setAttribute("alert", alert);
			hs.setAttribute("account", null);
			return 0;
		}else if(account.getResult().equals("password")){
			alert = "Check your PW!";
			request.setAttribute("alert", alert);
			hs.setAttribute("account", null);
			return 1;
		}else{
			return 2;
		}
		
	}
	public static void loginCheck(HttpServletRequest request) {
		LoginDTO account = (LoginDTO)request.getSession().getAttribute("account");
		if (account ==  null) {
			request.setAttribute("loginLogoutBtn", "login/header-loginSignup.jsp");
			request.setAttribute("uprCd","");
			request.setAttribute("uprText","state");
			request.setAttribute("orgCd","");
			request.setAttribute("orgText","city");
			
		}else {
 			request.setAttribute("loginLogoutBtn", "login/header-logoutMypage.jsp");
 			request.setAttribute("uprCd",account.getUprCd());
 			request.setAttribute("uprText",account.getUprText());
 			request.setAttribute("orgCd",account.getOrgCd());
 			request.setAttribute("orgText",account.getOrgText());
 			
		}
		
	}

	public static void loginCheckMain(HttpServletRequest request) {
		LoginDTO account = (LoginDTO)request.getSession().getAttribute("account");
		if (account ==  null) {
			request.setAttribute("mainLoginLogoutBtn", "main-header-loginSignup.jsp");
			
		}else {
 			request.setAttribute("mainLoginLogoutBtn", "main-header-logoutMypage.jsp");
 			
		}
		
	}
	public static void logout(HttpServletRequest request) {
	
		
		HttpSession hs = request.getSession();
		hs.setAttribute("account", null);
//		hs.removeAttribute("account");
//		hs.invalidate(); : 초기화 
		
	}
}

