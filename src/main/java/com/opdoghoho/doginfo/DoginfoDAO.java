package com.opdoghoho.doginfo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.opdoghw.centerinfo.DBManager_khw;

public class DoginfoDAO {
	public static void main(String[] args) {

	}

	public static void sido(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from sido";

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
		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
		String url = null;
		String a = request.getParameter("value2");
		String Cd[] = a.split("!");
		if (request.getParameter("value2") == "" || request.getParameter("value2") == null) {
			System.out.println(request.getParameter("value1"));
			url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic?_type=json&upkind=417000&state=protect&upr_cd="
					+ request.getParameter("value1") + "&pageNo=1&numOfRows=1000&serviceKey=" + encodeKey;
			System.out.println("11");
		} else if (request.getParameter("value3") == "" || request.getParameter("value3") == null) {
			System.out.println(Cd[1]);
			url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic?_type=json&upkind=417000&state=protect&upr_cd="
					+ request.getParameter("value1") + "&org_cd=" + Cd[1] + "&pageNo=1&numOfRows=1000&serviceKey="
					+ encodeKey;
			System.out.println("22");
		} else {
			System.out.println(request.getParameter("value3"));
			url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic?_type=json&upkind=417000&state=protect&upr_cd="
					+ request.getParameter("value1") + "&org_cd=" + Cd[1] + "&care_reg_no="
					+ request.getParameter("value3") + "&pageNo=1&numOfRows=1000&serviceKey=" + encodeKey;
			System.out.println("33");
		}
		response.setContentType("application/json; charset=utf-8");
		
		
		
		try {
			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			if(huc.getResponseCode() == 200) {
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
//				System.out.println(isr);
			
				JSONParser jp = new JSONParser();
				JSONObject dogs = (JSONObject) jp.parse(isr);
			
				System.out.println(dogs);
				System.out.println("여기서 터진거면 오브젝트 나눌 때");
				dogs = (JSONObject) dogs.get("response");
				dogs = (JSONObject) dogs.get("body");
				dogs = (JSONObject) dogs.get("items");
				System.out.println("여기서 터진거면 어레이 만들 때");
				JSONArray dog = (JSONArray) dogs.get("item");
					if(dog != null) {
						System.out.println("여기서 터진거면 어레이 담을 때 ");
						System.out.println(dog);
						response.getWriter().print(dog);
					}else {
						response.getWriter().print(0);
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
