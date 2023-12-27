package com.opdoghj.volunteer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opdoghw.centerinfo.DBManager_khw;
import com.opdoghw.login.LoginDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class VolunteerDAO {
	private static ArrayList<volunteerDTO> volunteer;

	public static void getAllpost(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from volunteer";

		try {
			con = DBManager_khw.connect();
			System.out.println("연결성공~!");

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			volunteerDTO v = null;
			volunteer = new ArrayList<volunteerDTO>();
			while (rs.next()) {
				v = new volunteerDTO();
				v.setV_no(rs.getInt("v_no"));
				v.setV_title(rs.getString("v_title"));
				v.setV_img(rs.getString("v_img"));
				v.setV_txt(rs.getString("v_txt"));
				v.setV_created(rs.getDate("v_created"));
				v.setV_updated(rs.getDate("v_updated"));
				v.setV_status(rs.getString("v_status"));
				v.setA_no(rs.getInt("a_no"));
				volunteer.add(v);
				System.out.println(v);
			}

			request.setAttribute("volunteer", volunteer);
			System.out.println("성공");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("조회 실패");
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

	public static void WritePost(HttpServletRequest request) {
		HttpSession hs = request.getSession();

		LoginDTO account = (LoginDTO) request.getSession().getAttribute("account");
		System.out.println(account.getNo());
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into volunteer values(volunteer_seq.nextval,?,?,?,sysdate,sysdate,?,?)";
		try {
			request.setCharacterEncoding("utf-8");
			con = DBManager_khw.connect();
			System.out.println("연결성공~!");

			String path = request.getServletContext().getRealPath("3_volunteer/newImg");

			System.out.println(path);

			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "UTF-8",
					new DefaultFileRenamePolicy());

			String title = mr.getParameter("title");
			String file = mr.getFilesystemName("file");
			String content = mr.getParameter("content");
			String status = mr.getParameter("chooseStatus");

			content = content.replaceAll("\r\n", "<br>");

			System.out.println(file);
			System.out.println(title);
			System.out.println(content);
			System.out.println(status);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, file);
			pstmt.setString(3, content);
			pstmt.setString(4, status);
			pstmt.setInt(5, account.getNo());

			if (pstmt.executeUpdate() == 1) {
				System.out.println("업로드성공입니동₍ᐢ. ̫.ᐢ₎♡");
				request.setAttribute("r", "업로드성공입니동₍ᐢ. ̫.ᐢ₎♡");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("업로드 실패..₍ᐢㅠ༝ㅠᐢ₎");
			request.setAttribute("r", "업로드 실패..₍ᐢㅠ༝ㅠᐢ₎");
		} finally {
			DBManager_khw.close(con, pstmt, null);
		}

	}

}
