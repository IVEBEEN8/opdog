package com.opdoghoho.doginfo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.opdoghw.centerinfo.DBManager_khw;

public class DogDbUpdater {

	public static List<String> newList;

	public static void startDbUpdater() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		scheduler.scheduleAtFixedRate(() -> {
			updateDb();
		}, 0, 1, TimeUnit.HOURS);

	}

	public static void updateDb() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
		String url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic?pageNo=1&numOfRows=1000&upkind=417000&state=protect&_type=json&serviceKey="
				+ encodeKey;

		try {
			con = DBManager_khw.connect();

			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			if (huc.getResponseCode() == 200) {
//				중복데이터 조회, 신규데이터 삽입
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				JSONParser jp = new JSONParser();
				JSONObject dogs = (JSONObject) jp.parse(isr);
				dogs = (JSONObject) dogs.get("response");
				dogs = (JSONObject) dogs.get("body");
				System.out.println(dogs.get("totalCount"));
				double totalCount = (double) Integer.parseInt(String.valueOf(dogs.get("totalCount")));
				double pageCounter = Math.ceil(totalCount / 1000);
				newList = new ArrayList<String>();

				for (int i = 1; i <= pageCounter; i++) {
					insertData(i);
				}

			}
//			오래된 데이터 삭제

			sql = "select d_desertionno from dogInfo";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<String> dbList = new ArrayList<String>();
			while (rs.next()) {
				dbList.add(rs.getString("d_desertionno"));
			}

			ArrayList<String> delList = new ArrayList<String>();
			for (String s : dbList) {
				if (!newList.contains(s)) {
					delList.add(s);
				}
			}

			String delListStr = "(" + String.join(",", delList) + ")";
			sql = "delete from dogInfo where d_desertionNo in ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, delListStr);
			pstmt.executeUpdate();
			System.out.println("최신 데이터 갱신 완료!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

	public static void insertData(int page) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
		String url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic?pageNo=" + page
				+ "&numOfRows=1000&upkind=417000&state=protect&_type=json&serviceKey=" + encodeKey;

		String sql = "";
		try {
			con = DBManager_khw.connect();
			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			if (huc.getResponseCode() == 200) {
//				중복데이터 조회
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				JSONParser jp = new JSONParser();
				JSONObject dogs = (JSONObject) jp.parse(isr);
				dogs = (JSONObject) dogs.get("response");
				dogs = (JSONObject) dogs.get("body");
				dogs = (JSONObject) dogs.get("items");
				JSONArray dog = (JSONArray) dogs.get("item");
				String no[] = new String[dog.size()];

//				신규데이터 삽입
				for (int i = 0; i < dog.size(); i++) {
					JSONObject aa = (JSONObject) dog.get(i);

					sql = "select d_desertionNo from dogInfo where d_desertionNo=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, (String) aa.get("desertionNo"));
					rs = pstmt.executeQuery();
					no[i] = (String) aa.get("desertionNo");
					newList.add((String) aa.get("desertionNo"));
					String kind = (String) aa.get("kindCd");
					String kind2[] = kind.split("]");
					String age = (String) aa.get("age");
					int splitIndex = age.indexOf('(');
					String age2 = age.substring(0, splitIndex);
					if (!rs.next()) {
						sql = "insert into dogInfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, (String) aa.get("sexCd"));
						pstmt.setString(2, kind2[1]);
						pstmt.setString(3, (String) aa.get("noticeNo"));
						pstmt.setString(4, (String) aa.get("processState"));
						pstmt.setString(5, (String) aa.get("careAddr"));
						pstmt.setString(6, (String) aa.get("noticeSdt"));
						pstmt.setString(7, (String) aa.get("weight"));
						pstmt.setString(8, (String) aa.get("chargeNm"));
						pstmt.setString(9, (String) aa.get("desertionNo"));
						pstmt.setString(10, (String) aa.get("careNm"));
						pstmt.setString(11, (String) aa.get("careTel"));
						pstmt.setString(12, (String) aa.get("officetel"));
						pstmt.setString(13, (String) aa.get("orgNm"));
						pstmt.setString(14, (String) aa.get("filename"));
						pstmt.setString(15, (String) aa.get("popfile"));
						pstmt.setInt(16, Integer.parseInt((String) aa.get("noticeEdt")));
						pstmt.setString(17, (String) aa.get("neuterYn"));
						pstmt.setString(18, (String) aa.get("happenDt"));
						pstmt.setString(19, age2);
						pstmt.executeUpdate();
						System.out.println("업데이트중~");
					}
				}
				System.out.println(page + "페이지 업데이트 완료!");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

}
