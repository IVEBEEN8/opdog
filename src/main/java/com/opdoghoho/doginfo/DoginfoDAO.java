package com.opdoghoho.doginfo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.opdoghw.centerinfo.DBManager_khw;
import com.opdoghw.login.LoginDTO;

public class DoginfoDAO {
	public static void main(String[] args) {

	}

	public static void sido(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from sido";
		LoginDTO account = (LoginDTO) request.getSession().getAttribute("account");

		try {
			con = DBManager_khw.connect();
			System.out.println("connect success ---");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<sidoB> sido = new ArrayList<sidoB>();
			sidoB s = null;
			while (rs.next()) {
				s = new sidoB();
				s.setOrgCd(rs.getString("s_orgCd"));
				s.setOrgdownNm(rs.getString("s_orgdownNm"));
				sido.add(s);

			}
			if (account != null) {
				request.setAttribute("defaultsido", account.getUprCd());
				request.setAttribute("defaultsigun", account.getOrgCd());
			}
			request.setAttribute("sido", sido);
			System.out.println(sido.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

	public static void sigungu(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from gungu where g_uprCd=?";
		try {
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("value"));
			rs = pstmt.executeQuery();

			JSONArray sigungu = new JSONArray();
			while (rs.next()) {
				JSONObject gungu = new JSONObject();
				gungu.put("uprCd", rs.getString("g_uprCd"));
				gungu.put("orgCd", rs.getString("g_orgCd"));
				gungu.put("orgdownNm", rs.getString("g_orgdownNm"));
				sigungu.add(gungu);
			}

			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(sigungu);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

	public static void center(HttpServletRequest request, HttpServletResponse response) {
		String a = request.getParameter("value");
		String Cd[] = a.split("!");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from shelter where s_uprCd=? and s_orgCd=?";
		try {
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Cd[0]);
			pstmt.setString(2, Cd[1]);
			rs = pstmt.executeQuery();

			JSONArray center = new JSONArray();
			while (rs.next()) {
				JSONObject shelter = new JSONObject();
				shelter.put("careRegNo", rs.getString("s_careRegNo"));
				shelter.put("careNm", rs.getString("s_careNm"));
				center.add(shelter);
			}

			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(center);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

	public static void search(HttpServletRequest request, HttpServletResponse response) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		Date currenDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");


		String sido = request.getParameter("value1");
		System.out.println(sido);
		String sigun = request.getParameter("value2");
		System.out.println(sigun);
		String center = request.getParameter("value3");
		System.out.println(center);
		// 시,도만 있을 때
		try {
			con = DBManager_khw.connect();
			if (sigun == "" || sigun == null || sigun.equals("city") ) {
				sql = "select * from dogInfo where d_careaddr like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+sido+"%");
				System.out.println("11");
			} else if (center == "" || center == null || center.equals("shelter")) {
				// 군,구까지 있을 때
				sql = "select * from dogInfo where d_careaddr like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+sigun+"%");
				System.out.println("22");
			} else {
				// 센터까지 있을 때
				sql = "select * from dogInfo where d_carenm like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+center+"%");
				System.out.println("33");
			}
			response.setContentType("application/json; charset=utf-8");

			rs = pstmt.executeQuery();
			ArrayList<dogInfo> doginfos = new ArrayList<dogInfo>();
			dogInfo d = null;
			while (rs.next()) {
				int noticeEdt = rs.getInt("d_noticeEdt");
				String noticeEdtStr = String.valueOf(noticeEdt);
				Date noticeEdtDate = dateFormat.parse(noticeEdtStr);
				long diffMS = currenDate.getTime() - noticeEdtDate.getTime();
				long diffdays = 10 - (diffMS / (24 * 60 * 60 * 1000L)) % 365;
				String Dday = "";
				if (diffdays>=0) {
					Dday = "-" + diffdays;
				} else {
					Dday = "+" + Math.abs(diffdays);
				}
				d = new dogInfo();
				d.setAge(rs.getString("d_age"));
				d.setCareAddr(rs.getString("d_careaddr"));
				d.setCareNm(rs.getString("d_careNm"));
				d.setCareTel(rs.getString("d_careNm"));
				d.setChargeNm(rs.getString("d_chargeNm"));
				d.setDesertionNo(rs.getString("d_desertionNo"));
				d.setFilename(rs.getString("d_filename"));
				d.setHappenDt(rs.getString("d_happenDt"));
				d.setKindCd(rs.getString("d_kindcd"));
				d.setNeuterYn(rs.getString("d_neuterYn"));
				d.setNoticeEdt(rs.getInt("d_noticeEdt"));
				d.setNoticeNo(rs.getString("d_noticeNo"));
				d.setOfficeTel(rs.getString("d_officetel"));
				d.setOrgNm(rs.getString("d_orgNm"));
				d.setPopfile(rs.getString("d_popFile"));
				d.setProcessState(rs.getString("d_Processstate"));
				d.setSexCd(rs.getString("d_SexCd"));
				d.setWeight(rs.getString("d_weight"));
				d.setdDay(Dday);
				doginfos.add(d);
			}
			
			Comparator<dogInfo> comparedDate = Comparator.comparing(dogInfo::getNoticeEdt, Comparator.naturalOrder());
			ArrayList<dogInfo> comparedDogInfoList = (ArrayList<dogInfo>) doginfos.stream().sorted(comparedDate)
					.collect(Collectors.toList());
			
			Gson gson = new Gson();
			String jsonDoginfo = gson.toJson(comparedDogInfoList);
			if (jsonDoginfo != null) {
				System.out.println("여기서 터진거면 어레이 담을 때 ");
				System.out.println(jsonDoginfo);
				response.getWriter().print(jsonDoginfo);
			} else {
				response.getWriter().print(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

}
