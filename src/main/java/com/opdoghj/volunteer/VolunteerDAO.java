package com.opdoghj.volunteer;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
			pstmt.executeUpdate();
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

	public static void getPost(HttpServletRequest request) {
		System.out.println("modify중 들어왔음!");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from volunteer where v_no=?";

		try {
			con = DBManager_khw.connect();
			System.out.println("연결성공~!");
			String no = request.getParameter("no");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();

			volunteerDTO v = null;
			if (rs.next()) {
				v = new volunteerDTO();
				v.setV_no(rs.getInt("v_no"));
				v.setV_title(rs.getString("v_title"));
				v.setV_img(rs.getString("v_img"));
				v.setV_txt(rs.getString("v_txt"));
				v.setV_created(rs.getDate("v_created"));
				v.setV_updated(rs.getDate("v_updated"));
				v.setV_status(rs.getString("v_status"));
				v.setA_no(rs.getInt("a_no"));

				request.setAttribute("vol", v);
				System.out.println("성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

	public static void searchCenter(HttpServletRequest request, HttpServletResponse response) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String searchTitle = request.getParameter("searchTitle");
		String sql = "select * from volunteer where v_title like ?";

		try {
			System.out.println(searchTitle);
			con = DBManager_khw.connect();
			System.out.println("checked");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + searchTitle + "%");
			rs = pstmt.executeQuery();

			volunteerDTO searchedItems = null;
			volunteer = new ArrayList<volunteerDTO>();
			while (rs.next()) {
				searchedItems = new volunteerDTO();
				searchedItems.setV_no(rs.getInt("v_no"));
				searchedItems.setV_title(rs.getString("v_title"));
				searchedItems.setV_img(rs.getString("v_img"));
				searchedItems.setV_txt(rs.getString("v_txt"));
				searchedItems.setV_created(rs.getDate("v_created"));
				searchedItems.setV_updated(rs.getDate("v_updated"));
				searchedItems.setV_status(rs.getString("v_status"));
				searchedItems.setA_no(rs.getInt("a_no"));
				volunteer.add(searchedItems);

			}

			System.out.println(volunteer);
			request.setAttribute("volunteer", volunteer);
			System.out.println("성공");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
	}

	public static void statusClick(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String clickedBtn = request.getParameter("searchBtn");
		String sql = "select * from volunteer where v_status like ?";

		try {
			System.out.println(clickedBtn);
			con = DBManager_khw.connect();
			System.out.println("checked");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clickedBtn);
			rs = pstmt.executeQuery();

			volunteerDTO searchedItems = null;
			volunteer = new ArrayList<volunteerDTO>();
			while (rs.next()) {
				searchedItems = new volunteerDTO();
				searchedItems.setV_no(rs.getInt("v_no"));
				searchedItems.setV_title(rs.getString("v_title"));
				searchedItems.setV_img(rs.getString("v_img"));
				searchedItems.setV_txt(rs.getString("v_txt"));
				searchedItems.setV_created(rs.getDate("v_created"));
				searchedItems.setV_updated(rs.getDate("v_updated"));
				searchedItems.setV_status(rs.getString("v_status"));
				searchedItems.setA_no(rs.getInt("a_no"));
				volunteer.add(searchedItems);

			}

			System.out.println(volunteer);
			request.setAttribute("volunteer", volunteer);
			System.out.println("성공");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
	}

	public static void Paging(int page, HttpServletRequest request) {
		request.setAttribute("curPageNo", page);
		int cnt = 5; // 한페이지당 보여줄 개수
		int total = volunteer.size(); // 총 데이터 개수
		// 총 페이지
		int pageCount = (int) Math.ceil((double) total / cnt);
		request.setAttribute("pageCount", pageCount); // jsp에서 써야해서 실어줌..!

		int start = total - (cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<volunteerDTO> items = new ArrayList<volunteerDTO>();
		for (int i = start - 1; i > end; i--) {
			// 역순으로 계산하는걸로 가져왔기때문에 꺽새 뒤집어주고 --로 수정
			items.add(volunteer.get(i));
		}
		request.setAttribute("volunteer", items);

	}

	public static void updatePost(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String path = request.getServletContext().getRealPath("3_volunteer/newImg");
		String sql = "update volunteer" + " set v_img=?, v_title=?,v_txt=?, v_status=? where v_no=?";
		try {

			request.setCharacterEncoding("utf-8");
			con = DBManager_khw.connect();
			System.out.println("연결성공~!");
			System.out.println(path);
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "UTF-8",
					new DefaultFileRenamePolicy());

			String title = mr.getParameter("title");
			String newFile = mr.getFilesystemName("newFile");
			String oldFile = mr.getFilesystemName("oldFile");
			String content = mr.getParameter("content");
			String status = mr.getParameter("chooseStatus");
			String no = mr.getParameter("no");

			content = content.replaceAll("\r\n", "<br>");

			System.out.println(title);
			System.out.println(newFile);
			System.out.println(oldFile);
			System.out.println(content);
			System.out.println(status);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, status);
			pstmt.setString(5, no);

			if (newFile != null) {
				pstmt.setString(1, newFile);
			} else {
				pstmt.setString(1, oldFile);
			}

			pstmt.executeUpdate();
			if (pstmt.executeUpdate() == 1) {
				System.out.println("업로드성공입니동₍ᐢ. ̫.ᐢ₎♡");
				request.setAttribute("r", "업로드성공입니동₍ᐢ. ̫.ᐢ₎♡");
				if (newFile != null) {
					File f = new File(path + "/" + oldFile);
					f.delete();
				}
			}
			request.setAttribute("no", no);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("업로드 실패..₍ᐢㅠ༝ㅠᐢ₎");
			request.setAttribute("r", "업로드 실패..₍ᐢㅠ༝ㅠᐢ₎");
		} finally {
			DBManager_khw.close(con, pstmt, null);
		}
	}
}
