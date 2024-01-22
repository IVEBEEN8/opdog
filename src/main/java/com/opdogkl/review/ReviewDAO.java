package com.opdogkl.review;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opdoghw.centerinfo.DBManager_khw;
import com.opdoghw.login.LoginDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewDAO {
	private static ArrayList<Review> reviews;

	public static void getAllReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from review_kl order by r_no";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Review r = null;
			reviews = new ArrayList<Review>();

			while (rs.next()) {
				r = new Review();
				r.setR_no(rs.getInt("r_no"));
				r.setR_img(rs.getString("r_img"));
				r.setR_title(rs.getString("r_title"));
				r.setR_txt(rs.getString("r_txt"));
				r.setR_created(rs.getDate("r_created"));
				r.setR_updated(rs.getDate("r_updated"));
				r.setA_no(rs.getInt("a_no"));
				reviews.add(r);
				System.out.println(rs.getString("r_img"));
			}
			request.setAttribute("reviews", reviews);
			System.out.println("전체 리뷰 어트리뷰트 생성");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("전체 리뷰 조회 실패");
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

	public static void regReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// img/title/txt/created/updated/op_email(foreign key)
		String sql = "insert into review_kl values (review_kl_seq.nextval,?,?,?,sysdate,sysdate,?)";

//		String path = "/Users/6oohye/Desktop/obdog/src/main/webapp/1_adopt/1_4_review/imgFolder";

		String path = request.getServletContext().getRealPath("1_adopt/1_4_review/imgFolder");
		System.out.println(path);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager_khw.connect();
			request.setCharacterEncoding("utf-8");

			// 세션에서 a_no 값을 가져오기
			LoginDTO account = (LoginDTO) request.getSession().getAttribute("account");

			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			// UUID를 사용하여 고유한 파일 이름 생성
			String originalFileName = mr.getFilesystemName("fileInput");
			String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			String uniqueFileName = UUID.randomUUID().toString().replaceAll("-", "") + fileExtension;

			// 파일 이름 변경
			File f = new File(path, uniqueFileName);
			mr.getFile("fileInput").renameTo(f);

			String img = uniqueFileName;
			String title = mr.getParameter("title");
			String txt = mr.getParameter("txt");

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, img);
			System.out.println(img);
			pstmt.setString(2, title);
			pstmt.setString(3, txt);
			pstmt.setInt(4, account.getNo()); // 세션에서 가져온 op_email 값 사용

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("등록 실패");
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

	public static void getReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT r.r_no, r.r_img, r.r_title, r.r_txt, r.r_created, r.r_updated, r.a_no, a.a_email "
				+ "FROM review_kl r " + "JOIN opdogaccount a ON r.a_no = a.a_no " + "WHERE r.r_no = ?";

		Review r = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager_khw.connect();
			String paramNo = request.getParameter("no");
			String attrNo = (String) request.getAttribute("no");
			String no = paramNo != null ? paramNo : attrNo;
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				r = new Review();
				r.setR_no(rs.getInt("r_no"));
				r.setR_img(rs.getString("r_img"));
				r.setR_title(rs.getString("r_title"));
				r.setR_txt(rs.getString("r_txt"));
				r.setR_created(rs.getDate("r_created"));
				r.setR_updated(rs.getDate("r_updated"));
				r.setA_no(rs.getInt("a_no"));
				r.setA_email(rs.getString("a_email"));

				request.setAttribute("review", r);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

	public static void upReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update review_kl" + " set r_img=?, r_title=?, r_txt=?, r_updated=SYSDATE" + " where r_no=?";
		String path = request.getServletContext().getRealPath("1_adopt/1_4_review/imgFolder");
		System.out.println(path);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager_khw.connect();
			request.setCharacterEncoding("utf-8");

			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			

//			String newImg = mr.getFilesystemName("newImg");
			String title = mr.getParameter("title");
			String txt = mr.getParameter("txt");
			String no = mr.getParameter("no");
			String oldImg = mr.getParameter("oldImg");
			String newImg = oldImg;
			String originalFileName = mr.getFilesystemName("newImg");
			if (originalFileName != null) {
			// UUID를 사용하여 고유한 파일 이름 생성
			String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			String uniqueFileName = UUID.randomUUID().toString().replaceAll("-", "") + fileExtension;

			// 파일 이름 변경
			File f = new File(path, uniqueFileName);
			mr.getFile("newImg").renameTo(f);
			newImg = uniqueFileName;
			}
			
			
			
			System.out.println(oldImg);
			System.out.println(newImg);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newImg);
			pstmt.setString(2, title);
			pstmt.setString(3, txt);
			pstmt.setString(4, no);

			

			if (pstmt.executeUpdate() == 1) {
				System.out.println("수정 성공");
				// 사진 교체시 기존파일 삭제
				if (newImg != null && !newImg.equals(oldImg)) {
					File d = new File(path + "/" + oldImg);
					d.delete();
				}
			}

			request.setAttribute("no", no);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 실패");
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

	public static void delReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager_khw.connect();
			String sql = "select r_img from review_kl where r_no=?"; // 필요한 열만 조회
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();

			String fileName = null;
			if (rs.next()) {
				fileName = rs.getString("r_img");
			}

			rs.close(); // ResultSet 객체 닫기
			pstmt.close(); // PreparedStatement 객체 닫기

			sql = "delete review_kl where r_no=?";
			pstmt = con.prepareStatement(sql); // PreparedStatement 객체 재사용
			pstmt.setString(1, request.getParameter("no"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제 성공");

				// 파일 삭제
				String path = request.getServletContext().getRealPath("1_adopt/1_4_review/imgFolder");
				File file = new File(path + "/" + fileName);
				file.delete();

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제 실패");
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
	}

	public static void paging(int page, HttpServletRequest request) {
		try {
			request.setAttribute("curPageNo", page);
			int cnt = 8; // 한페이지당 보여줄 개수
			int total = reviews.size(); // 총 데이터 개수
			System.out.println("생성된 배열길이 : " + reviews.size());
			// 총페이지수
			int pageCount = (int) Math.ceil((double) total / cnt);
			System.out.println("생성된 총페이지수 : " + pageCount);
			request.setAttribute("pageCount", pageCount);

			int start = total - (cnt * (page - 1));
			System.out.println("시작 : " + start);
			// 현재페이지가 총페이지수와 같아?
			int end = (page == pageCount) ? -1 : start - (cnt + 1);
			System.out.println("끝 : " + end);
			System.out.println();
			ArrayList<Review> items = new ArrayList<Review>();
			for (int i = start - 1; i > end; i--) {
				items.add(reviews.get(i));

			}
			request.setAttribute("reviews", items);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("표시할 페이지가 없어요");
		}

	}
}
