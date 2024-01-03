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
		String sql = "SELECT v.*, a.A_EMAIL " + "FROM VOLUNTEER v "
				+ "JOIN OPDOGACCOUNT a ON v.A_NO = a.A_NO order by v_no";
		try {
			con = DBManager_khw.connect();
			System.out.println("연결 성공~!");

			pstmt = con.prepareStatement(sql);
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
				v.setV_updated(rs.getDate("V_UPDATED"));
				v.setV_status(rs.getString("V_STATUS"));
				v.setA_no(rs.getInt("A_NO"));
				String aEmail = rs.getString("A_EMAIL");
				v.setA_email(aEmail);
				volunteer.add(v);
				request.setAttribute("volunteer", volunteer);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 필요에 따라 close 작업 수행
			DBManager_khw.close(con, pstmt, rs);
		}
	}

	public static void WritePost(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		LoginDTO account = (LoginDTO) request.getSession().getAttribute("account");
		System.out.println("어카운트넘버" + account.getNo());
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into volunteer values(volunteer_seq.nextval,?,?,?,sysdate,sysdate,?,?)";
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

	public static void getPost(HttpServletRequest request) {
		System.out.println("modify중 들어왔음!");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT v.*, a.A_NO\n" + "FROM VOLUNTEER v\n" + "JOIN OPDOGACCOUNT a ON v.A_NO = a.A_NO\n"
				+ "WHERE v.V_NO = ?";

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
				v.setV_updated(rs.getDate("v_updated"));
				v.setV_status(rs.getString("v_status"));
				v.setA_no(rs.getInt("a_no"));

				request.setAttribute("vol", v);
				System.out.println(v);
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
		String sql = "select * from volunteer where v_title like ? order by v_no";

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
		String sql = "select * from volunteer where v_status like ? order by v_no";

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
		int cnt = 5; // 한 페이지당 보여줄 개수
		int total = volunteer.size(); // 총 데이터 개수

		// 총 페이지
		int pageCount = (int) Math.ceil((double) total / cnt);
		request.setAttribute("pageCount", pageCount); // jsp에서 써야해서 실어줌..!

		// 페이지 계산
		int start = (page - 1) * cnt;
		int end = Math.min(start + cnt, total);

		ArrayList<volunteerDTO> items = new ArrayList<volunteerDTO>();
		for (int i = start; i < end; i++) {
			items.add(volunteer.get(i));
		}
		request.setAttribute("volunteer", items);
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
			String newFile = mr.getFilesystemName("newFile");
			String oldFile = mr.getParameter("oldFile");
			String content = mr.getParameter("content");
			String status = mr.getParameter("chooseStatus");
			String no = mr.getParameter("no");
			String File1 = oldFile;
			if (newFile != null) {
				File1 = newFile;
			}

			content = content.replaceAll("\r\n", "<br>");

			System.out.println(title);
			System.out.println(newFile);
			System.out.println(oldFile);
			System.out.println(content);
			System.out.println(status);
			System.out.println(File1);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, File1);
			pstmt.setString(3, content);
			pstmt.setString(4, status);
			pstmt.setString(5, no);

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

	public static void deletePost(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String no = request.getParameter("no");
		System.out.println(no);
		String sql = "delete volunteer where v_no=?";

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
