package com.opdoghw.centerinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CenterInfoDAO {

	public static void getCenterInfo(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from centerinfo_test";
		CenterInfoDTO c = null;
		ArrayList<CenterInfoDTO> center = new ArrayList<CenterInfoDTO>();
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				c = new CenterInfoDTO();
				c.setNo(rs.getInt("c_no"));
				c.setCareNm(rs.getString("c_carenm"));
				c.setCareAddr(rs.getString("c_careaddr"));
				c.setLat(rs.getFloat("c_lat"));
				c.setLng(rs.getFloat("c_lng"));
				c.setVetPersonCnt(rs.getInt("c_vetpersoncnt"));
				c.setCareTel(rs.getString("c_caretel"));
				center.add(c);
			}
			request.setAttribute("centers", center);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	@SuppressWarnings("unchecked")
	public static void sendMarker(HttpServletRequest request, HttpServletResponse response) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from centerinfo_test where c_lat=? and c_lng=? ";
		try {
			String lat = request.getParameter("lat");
			String lng = request.getParameter("lng");

			System.out.println(lat);
			System.out.println(lng);
			String result = "";

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			System.out.println("연결성공!!123");
			pstmt.setString(1, lat);
			pstmt.setString(2, lng);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = "값받아오기성공!!!!!!!!!";
				System.out.println(result);
				JSONArray mydbCenterData = new JSONArray();
				JSONObject obj = new JSONObject();
				obj.put("careNm", rs.getString("c_careNm"));
				obj.put("careAddr", rs.getString("c_careAddr"));
				obj.put("verNum", rs.getInt("c_vetPersonCnt"));
				obj.put("tel", rs.getString("c_careTel"));
				mydbCenterData.add(obj);
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().print(mydbCenterData);

			} else {
				result = "존재하지 않는 데이터 입니다.";
			}
			// 값받아오기 성공 실패 화면출력을 위함.
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

}
