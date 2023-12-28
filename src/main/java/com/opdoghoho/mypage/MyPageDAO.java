package com.opdoghoho.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.opdoghw.centerinfo.DBManager_khw;
import com.opdoghw.login.LoginDTO;

public class MyPageDAO {

	public static void dogLike(HttpServletRequest request, HttpServletResponse response) {
		HttpSession hs = request.getSession();
		LoginDTO account = (LoginDTO) request.getSession().getAttribute("account");
		JSONParser jp = new JSONParser();
		String aa = request.getParameter("value");
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into opdoglike values(?,?,?,?,?,?,?,?,?,?)";
		try {
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			JSONObject bb = (JSONObject) jp.parse(aa);
			pstmt.setString(1, (String) bb.get("age"));
			pstmt.setString(2, (String) bb.get("desertionNo"));
			pstmt.setString(3, (String) bb.get("kindCd"));
			pstmt.setString(4, (String) bb.get("colorCd"));
			pstmt.setString(5, (String) bb.get("sexCd"));
			pstmt.setString(6, (String) bb.get("neuterYn"));
			pstmt.setString(7, (String) bb.get("specialMark"));
			pstmt.setString(8, (String) bb.get("careNm") + "!" + bb.get("careTel") + "!" + bb.get("careAddr"));
			pstmt.setString(9, (String) bb.get("orgNm") + "!" + bb.get("chargeNm") + "!" + bb.get("officetel"));
			pstmt.setInt(10, account.getNo());
			System.out.println(account.getNo());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("test");
		System.out.println("-----------");
	}

	public static void likeLoad(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LoginDTO account = (LoginDTO) request.getSession().getAttribute("account");
		String sql = "select * from opdoglike where a_no=?";

		try {
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, account.getNo());
			rs = pstmt.executeQuery();
			ArrayList<dogLikeList> list = new ArrayList<dogLikeList>();
			dogLikeList like = null;
			while (rs.next()) {
				like = new dogLikeList();

				like.setAge(rs.getString("d_age"));
				like.setNo(rs.getString("d_no"));
				like.setKind(rs.getString("d_kind"));
				like.setColor(rs.getString("d_color"));
				like.setSex(rs.getString("d_sex"));
				like.setNeuter(rs.getString("d_neuter"));
				like.setMark(rs.getString("d_mark"));
				like.setCenter(rs.getString("d_center"));
				like.setOrg(rs.getString("d_org"));
				list.add(like);
			}
			request.setAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

	public static void updateInfo(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update opdogaccount set a_email=?, a_firstname=?, a_lastname=? where a_no=?";
		if (request.getParameter("newpw") != null) {
			sql = "update opdogaccount set a_email=?, a_firstname=?, a_lastname=?, a_password=?  where a_no=?";
		}
		LoginDTO account = (LoginDTO) request.getSession().getAttribute("account");
		try {
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("id"));
			account.setEmail(request.getParameter("id"));
			pstmt.setString(2, request.getParameter("fn"));
			account.setFirstname(request.getParameter("fn"));
			pstmt.setString(3, request.getParameter("ln"));
			account.setLastname(request.getParameter("ln"));
			if (request.getParameter("newpw") == null) {
				pstmt.setInt(4, account.getNo());
				pstmt.executeUpdate();
			} else {
				pstmt.setString(4, request.getParameter("newpw"));
				pstmt.setInt(5, account.getNo());
				pstmt.executeUpdate();
				HttpSession hs = request.getSession();
				hs.setAttribute("account", null);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
