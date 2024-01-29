package com.opdoghw.centerinfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CenterInfoDAO {

	public static void getCenterInfo(HttpServletRequest request, HttpServletResponse response) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from centerinfo1 order by c_no";
		CenterInfoDTO c = null;
		ArrayList<CenterInfoDTO> center = new ArrayList<CenterInfoDTO>();
		try {
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				c = new CenterInfoDTO();
				c.setNo(rs.getInt("c_no"));
				c.setCareNm(rs.getString("c_carenm")); // 보호소명
				c.setCareAddr(rs.getString("c_careaddr")); // 보호소주소
				c.setLat(rs.getFloat("c_lat")); // 보호소위도
				c.setLng(rs.getFloat("c_lng")); // 보호소경도
				c.setVetPersonCnt(rs.getInt("c_vetpersoncnt")); // 보호소수의사수
				c.setCareTel(rs.getString("c_caretel")); // 보호소전화번호
				c.setClosetime(rs.getString("c_closetime")); // 보호소종료시간
				c.setOprtime(rs.getString("c_oprtime")); // 보호소시작시간
				c.setCloseday(rs.getString("c_closeday")); // 보호소휴무일
				c.setCareTel(rs.getString("c_caretel")); // 보호소전화번호
				center.add(c);
			}
			// String jsonCenterinfo = new Gson().toJson(center);
			// System.out.println(jsonCenterinfo);
			request.setAttribute("centers", center);

			// response.setContentType("application/json");
			// response.getWriter().write(jsonCenter);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
	}

	@SuppressWarnings("unchecked")
	public static void sendMarker(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from centerinfo1 where c_lat=? and c_lng=?"; // 나중에추가해보기. 데이터베이스 lng값이 소수점 1자리가 모자람.
		try {
			String lat = request.getParameter("lat");
			String lng = request.getParameter("lng");

			System.out.println(lat);
			System.out.println(lng);
			String result = "";

			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			System.out.println("연결성공!!123");
			pstmt.setString(1, lat);
			pstmt.setString(2, lng);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println(result);
				JSONArray mydbCenterData = new JSONArray();
				JSONObject obj = new JSONObject();
				obj.put("careNm", rs.getString("c_careNm")); // 보호소명
				obj.put("careAddr", rs.getString("c_careAddr")); // 보호소주소
				obj.put("verNum", rs.getInt("c_vetPersonCnt")); // 보호소수의사수
				obj.put("tel", rs.getString("c_careTel")); // 보호소전화번호
				obj.put("oprtime", rs.getString("c_oprtime")); // 보호소오픈시간
				obj.put("closetime", rs.getString("c_closetime")); // 보호소닫는시간
				obj.put("closeday", rs.getString("c_closeday")); // 보호소휴무일

				// 결과값이 잘 들어갔는지 확인!
				// System.out.println(obj);
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
			DBManager_khw.close(con, pstmt, rs);
		}
	}

	public static void putCenterInfo(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		Connection con = null;

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
			BufferedReader rd = null;
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
			con = DBManager_khw.connect();

			for (Object object : items) {
				String sql = "insert into centerinfo1 values (centerinfo1_seq.nextval,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);

				JSONObject item = (JSONObject) object;

				String careNm = (String) item.get("careNm");
				String careAddr = (String) item.get("careAddr");

				String translatedCareNm = papagoTranslate(careNm);
				String translatedCareAddr = papagoTranslate(careAddr);

				pstmt.setString(1, translatedCareNm);
				pstmt.setString(2, translatedCareAddr);

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
				pstmt.setString(6, (String) item.get("weekOprStime"));
				pstmt.setString(7, (String) item.get("weekOprEtime"));
				pstmt.setString(8, (String) item.get("closeDay"));
				pstmt.setString(9, (String) item.get("careTel"));
				pstmt.executeUpdate();
				// System.out.println(11);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, null);
		}

	}

	@SuppressWarnings("unused")
	private static String papagoTranslate(String text) {
		try {
			String clientId = "G_LumDg1eMO6O8wBrhcP";
			String clientSecret = "WAFpoo4142";
			// String clientId = "f8E1dHSfLIZGwep16ykM";// 애플리케이션 클라이언트 아이디값";
			// String clientSecret = "g9Ae4Vludr";
			// String clientId = "6c4er8GLss670lWmpB12";
			// String clientSecret = "wONSCvVVKS";
			String apiURL = "https://openapi.naver.com/v1/papago/n2mt";

			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			String postParams = "source=ko&target=en&text=" + URLEncoder.encode(text, "UTF-8");
			con.setDoOutput(true);
			con.getOutputStream().write(postParams.getBytes("UTF-8"));

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			StringBuilder response = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				response.append(line);
			}
			br.close();

			JSONParser jp = new JSONParser();
			JSONObject resultData = (JSONObject) jp.parse(response.toString());
			JSONObject obj = (JSONObject) resultData.get("message");
			obj = (JSONObject) obj.get("result");
			return (String) obj.get("translatedText");

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static void searchCenter(HttpServletRequest request, HttpServletResponse response) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String searchField = request.getParameter("searchField");
		String searchText = request.getParameter("searchText");
		// 대소문자 구분없이 변경가능하게..
		String sql = "select * from centerinfo1 where UPPER(" + searchField + ") like UPPER(?)";

		JSONArray searchedInfo = new JSONArray();
		JSONObject si = null;

		try {
			System.out.println(searchField);
			System.out.println(searchText);

			con = DBManager_khw.connect();
			System.out.println("checked");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + searchText + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				si = new JSONObject();
				si.put("careNm", rs.getString("c_careNm")); // 보호소명
				si.put("careAddr", rs.getString("c_careAddr")); // 보호소주소
				si.put("verNum", rs.getInt("c_vetPersonCnt")); // 보호소수의사수
				si.put("tel", rs.getString("c_careTel")); // 보호소전화번호
				si.put("oprtime", rs.getString("c_oprtime")); // 보호소오픈시간
				si.put("closetime", rs.getString("c_closetime")); // 보호소닫는시간
				si.put("closeday", rs.getString("c_closeday")); // 보호소휴무일
				System.out.println(si);
				searchedInfo.add(si);
			}
			// 결과값이 잘 들어갔는지 확인!
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(searchedInfo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
	}

}
