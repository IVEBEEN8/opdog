package com.opdoghj.volunteer;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.opdoghw.centerinfo.DBManager_khw;
import com.opdoghw.login.LoginDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class VolunteerDAO {
	private static ArrayList<volunteerDTO> volunteer;

	public static void getAllpost(HttpServletRequest request, HttpServletResponse res) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT v.*, a.A_EMAIL " + "FROM VOLUNTEER v "
				+ "JOIN OPDOGACCOUNT a ON v.A_NO = a.A_NO and v.v_title like '%'||?||'%' and v.v_status like '%'||?||'%' and v.v_locate = ? order by v_no";
		try {
			String search = request.getParameter("search");
			String status = request.getParameter("status");
			String locate = request.getParameter("locate");
			

			con = DBManager_khw.connect();
			System.out.println("연결 성공~!");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, status);
			pstmt.setString(3, locate);
			rs = pstmt.executeQuery();

			volunteerDTO v = null;
			volunteer = new ArrayList<>();
			while (rs.next()) {
				v = new volunteerDTO();
				v.setV_no(rs.getInt("V_NO"));
				v.setV_title(rs.getString("V_TITLE"));
				v.setV_img(rs.getString("V_IMG"));
				v.setV_txt(rs.getString("V_TXT"));
				v.setV_created(rs.getDate("V_CREATED"));
				v.setV_status(rs.getString("V_STATUS"));
				v.setA_no(rs.getInt("A_NO"));
				v.setA_email(rs.getString("A_EMAIL"));
				volunteer.add(v);

			}

			String jsonVolunteer = new Gson().toJson(volunteer);
//			request.setAttribute("jsonVolunteer", jsonVolunteer);
//			System.out.println(jsonVolunteer);
			System.out.println(jsonVolunteer);
			res.setContentType("application/json");
			res.getWriter().write(jsonVolunteer);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 필요에 따라 close 작업 수행
			DBManager_khw.close(con, pstmt, rs);
		}
	}

	public static void WritePost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession hs = request.getSession();
		LoginDTO account = (LoginDTO) request.getSession().getAttribute("account");
		System.out.println("어카운트넘버" + account.getNo());
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into volunteer values(volunteer_seq.nextval,?,?,?,sysdate,?,?,?)";

		try {
			request.setCharacterEncoding("utf-8");
			con = DBManager_khw.connect();

			String path = request.getServletContext().getRealPath("3_volunteer/newImg");
			System.out.println(path);
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "UTF-8",
					new DefaultFileRenamePolicy());

			String title = mr.getParameter("title");
			String file = mr.getFilesystemName("file");
			String content = mr.getParameter("content");
			String status = mr.getParameter("chooseStatus");
			String locate = mr.getParameter("locate");
			System.out.println("이건내가 사랑하는 위치!:" + locate);

			content = content.replaceAll("<br>","\r\n");

			System.out.println(file);
			System.out.println(title);
			System.out.println(content);
			System.out.println(status);
			System.out.println(locate);

			request.setAttribute("locate", locate);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, file);
			pstmt.setString(3, content);
			pstmt.setString(4, status);
			pstmt.setInt(5, account.getNo());
			pstmt.setString(6, locate);

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
		String sql = "SELECT v.*, a.A_NO, a.A_EMAIL\n" + "FROM VOLUNTEER v\n"
				+ "JOIN OPDOGACCOUNT a ON v.A_NO = a.A_NO\n" + "WHERE v.V_NO = ?";

		try {
			con = DBManager_khw.connect();
			System.out.println("연결성공~!");
			String paramNo = request.getParameter("no");
			String attrNo = (String) request.getAttribute("no");
			String no = paramNo != null ? paramNo : attrNo;
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
				v.setV_status(rs.getString("v_status"));
				v.setA_no(rs.getInt("a_no"));
				v.setV_locate(rs.getString("v_locate"));
				String aEmail = rs.getString("A_EMAIL");
				v.setA_email(aEmail);

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

	public static void updatePost(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String path = request.getServletContext().getRealPath("3_volunteer/newImg");
		String sql = "update volunteer" + " set v_title=?, v_img=?, v_txt=?, v_status=? where v_no=?";
		try {

			request.setCharacterEncoding("utf-8");
			con = DBManager_khw.connect();
			System.out.println("연결성공~!");
			System.out.println(path);
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "UTF-8",
					new DefaultFileRenamePolicy());

			String title = mr.getParameter("title");
			String content = mr.getParameter("content");
			String status = mr.getParameter("chooseStatus");
			String no = mr.getParameter("no");
			String oldFile = mr.getParameter("oldFile");
			String newFile= oldFile;
			String originalFileName = mr.getFilesystemName("newFile");
			if (originalFileName != null) {
				// UUID를 사용하여 고유한 파일 이름 생성
				String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				String uniqueFileName = UUID.randomUUID().toString().replaceAll("-", "") + fileExtension;

				// 파일 이름 변경
				File f = new File(path, uniqueFileName);
				mr.getFile("newFile").renameTo(f);
				newFile = uniqueFileName;
			}

			content = content.replaceAll( "<br>","\r\n");

			System.out.println(title);
			System.out.println(newFile);
			System.out.println(oldFile);
			System.out.println(content);
			System.out.println(status);
			System.out.println(newFile);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, newFile);
			pstmt.setString(3, content);
			pstmt.setString(4, status);
			pstmt.setString(5, no);

			pstmt.executeUpdate();
			if (pstmt.executeUpdate() == 1) {
				System.out.println("업로드성공입니동₍ᐢ. ̫.ᐢ₎♡");
				request.setAttribute("r", "업로드성공입니동₍ᐢ. ̫.ᐢ₎♡");
//				if (newFile != null) {
//					File f = new File(path + "/" + oldFile);
//					f.delete();
//				}
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

	public static void deletePost(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String no = request.getParameter("no");
		String locate = request.getParameter("locate");
		System.out.println(no);
		String sql = "delete volunteer where v_no=?";

		try {
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제성공!");
			}
			request.setAttribute("locate", locate);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제실패했습니다..");
		} finally {
			DBManager_khw.close(con, pstmt, null);
		}
	}

	public static void applyVol(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into appliedvol values(appliedvol_seq.nextval, ?,?,?,?,?,sysdate,?,?,?)";
		try {
			request.setCharacterEncoding("utf-8");
			con = DBManager_khw.connect();
			String path = request.getServletContext().getRealPath("3_volunteer/newImg");
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "UTF-8",
					new DefaultFileRenamePolicy());
			String accountNo1 = mr.getParameter("accountNo1");
			String vNo = mr.getParameter("vNo");
			String vStatus = mr.getParameter("vStatus");
			String vTitle = mr.getParameter("vTitle");
			String vCreated = mr.getParameter("vCreated");
			String vImg = mr.getParameter("vImg");
			String vTxt = mr.getParameter("vTxt");
			String aEmail = mr.getParameter("aEmail");

			vTxt = vTxt.replaceAll("\r\n", "<br>");

			System.out.println(accountNo1);
			System.out.println(vNo);
			System.out.println(vStatus);
			System.out.println(vTitle);
			System.out.println(vCreated);
			System.out.println(vImg);
			System.out.println(vTxt);
			System.out.println(aEmail);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountNo1);
			pstmt.setString(2, vNo);
			pstmt.setString(3, vStatus);
			pstmt.setString(4, vTitle);
			pstmt.setString(5, vCreated);
			pstmt.setString(6, vImg);
			pstmt.setString(7, vTxt);
			pstmt.setString(8, aEmail);

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

	public static void appliedLoad(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LoginDTO account = (LoginDTO) request.getSession().getAttribute("account");
		String sql = "select * from appliedvol where a_no=?";

		try {
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, account.getNo());
			rs = pstmt.executeQuery();
			ArrayList<appliedVol> reglist = new ArrayList<appliedVol>();
			appliedVol like = null;
			while (rs.next()) {
				like = new appliedVol();
				like.setAccountNo(rs.getInt("a_no"));
				like.setPostNo(rs.getInt("v_no"));
				like.setPreivateNo(rs.getInt("ap_no"));
				like.setTitle(rs.getString("ap_title"));
				like.setEmail(rs.getString("a_email"));
				like.setImgf(rs.getString("ap_img"));
				like.setTxt(rs.getString("ap_txt"));
				like.setCreated(rs.getString("ap_postdate"));
				like.setApplied(rs.getString("ap_applieddate"));
				like.setStatus(rs.getString("ap_status"));
				reglist.add(like);
			}
			request.setAttribute("reglist", reglist);
			System.out.println("this is the reglist:" + reglist);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
	}

	public static void deleteFromMyList(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String no = request.getParameter("no");
		System.out.println(no);
		String sql = "delete appliedvol where ap_no=?";

		try {
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제실패했습니다..");
		} finally {
			DBManager_khw.close(con, pstmt, null);
		}
	}
}
