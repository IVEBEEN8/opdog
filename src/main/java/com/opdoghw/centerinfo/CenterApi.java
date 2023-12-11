package com.opdoghw.centerinfo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CenterApi {
	public static void main(String[] args) {
		try {
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
					+ "=sJG8TCmXj96iwKxnSPRAaGazSqjp8g97CNLXDwtsv7BNaDo%2F6qhQtG3OIp0MAEreldhU5TicAqKPPvCVcrj7cA%3D%3D"); /*
																															 * Service
																															 * Key
																															 */
			// urlBuilder.append("&" + URLEncoder.encode("care_reg_no","UTF-8") + "=" +
			// URLEncoder.encode("", "UTF-8")); /*보호센터등록번호*/
			// urlBuilder.append("&" + URLEncoder.encode("care_nm","UTF-8") + "=" +
			// URLEncoder.encode("", "UTF-8")); /*동물보호센터명*/
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("1000", "UTF-8")); /* 한 페이지 결과 수 (1,000 이하) */
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
			urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
					+ URLEncoder.encode("json", "UTF-8")); /* xml(기본값) 또는 json */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);

			}
			JSONParser jp = new JSONParser();
			JSONObject resultData = (JSONObject) jp.parse(sb.toString());
			JSONObject obj = (JSONObject) resultData.get("response");
			obj = (JSONObject) obj.get("body");
			obj = (JSONObject) obj.get("items");
			JSONArray items = (JSONArray) obj.get("item");

			// db에 연결하기!
			Connection con = null;
			PreparedStatement pstmt = null;

			for (Object object : items) {
				String sql = "insert into centerinfo_test values (centerinfo_test_seq.nextval,?,?,?,?,?,?)";
				con = DBManager_khw.connect();
				System.out.println("연결성공!!");
				pstmt = con.prepareStatement(sql);

//    	   	System.out.println(object);
				JSONObject item = (JSONObject) object;
//    	   	System.out.println("상호명 : " + item.get("careNm"));
//    	   	System.out.println("지역명 : " + item.get("orgNm"));
//    	   	System.out.println("주소 : " +  item.get("careAddr"));
//    	   	System.out.println("위도 : " + item.get("lat"));
//    	   	System.out.println("경도 : " + item.get("lng"));
//    	   	System.out.println("수의사수 : " + item.get("vetPersonCnt") + "명");
//    	   	System.out.println("전화번호 : " + item.get("careTel"));
//    	   	System.out.println("-------");

				pstmt.setString(1, (String) item.get("careNm"));
				pstmt.setString(2, (String) item.get("careAddr"));

				Double lat = (Double) item.get("lat");
				Double lng = (Double) item.get("lng");

				if (lat != null && lng != null) {
					pstmt.setDouble(3, lat);
					pstmt.setDouble(4, lng);
				} else {
					// 값이 null일 경우에 대한 처리 (예: 기본값 또는 예외 처리)
					pstmt.setNull(3, java.sql.Types.DOUBLE);
					pstmt.setNull(4, java.sql.Types.DOUBLE);
				}

				Long vetPersonCnt = (Long) item.get("vetPersonCnt");

				if (vetPersonCnt != null) {
					pstmt.setLong(5, vetPersonCnt);
				} else {
					// 값이 null일 경우에 대한 처리 (예: 기본값 또는 예외 처리)
					pstmt.setNull(5, java.sql.Types.BIGINT);
				}

				pstmt.setString(6, (String) item.get("careTel"));
				System.out.println("done----");
				pstmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}