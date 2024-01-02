package com.opdoghj.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.opdoghw.centerinfo.DBManager_khw;

public class sample {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String bgnde="20231201";
		String endde="20231220";
		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
		String url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic?bgnde=" + bgnde + "&endde="
				+ endde + "&pageNo=1&numOfRows=1000&upkind=417000&state=protect&_type=json&serviceKey=" + encodeKey;

		
		String sql="";
		try {
			con = DBManager_khw.connect();
			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			if (huc.getResponseCode()==200) {
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");

				JSONParser jp = new JSONParser();
				JSONObject dogs = (JSONObject) jp.parse(isr);

				dogs = (JSONObject) dogs.get("response");
				dogs = (JSONObject) dogs.get("body");
				dogs = (JSONObject) dogs.get("items");
				JSONArray dog = (JSONArray) dogs.get("item");
				String no[] = new String[dog.size()];
				for (int i = 0; i < dog.size(); i++) {
					sql = "select * from dogsample where s_desertionNo=?";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					JSONObject aa = (JSONObject) dog.get(i);
					pstmt.setString(1, (String) aa.get("desertionNo"));
					no[i] = (String) aa.get("desertionNo");
					if (!rs.next()) {
						sql ="insert into dogsample values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, (String) aa.get("sexCd"));
						pstmt.setString(2, (String) aa.get("kindCd"));
						pstmt.setString(3, (String) aa.get("noticeNo"));
						pstmt.setString(4, (String) aa.get("processState"));
						pstmt.setString(5, (String) aa.get("careAddr"));
						pstmt.setString(6, (String) aa.get("noticeSdt"));
						pstmt.setString(7, (String) aa.get("weight"));
						pstmt.setString(8, (String) aa.get("chargeNm"));
						pstmt.setString(9, (String) aa.get("desertionNo"));
						pstmt.setString(10, (String) aa.get("careNm"));
						pstmt.setString(11, (String) aa.get("careTel"));
						pstmt.setString(12, (String) aa.get("officeTel"));
						pstmt.setString(13, (String) aa.get("orgNm"));
						pstmt.setString(14, (String) aa.get("filename"));
						pstmt.setString(15, (String) aa.get("popfile"));
						pstmt.setString(16, (String) aa.get("noticeEdt"));
						pstmt.setString(17, (String) aa.get("neuterYn"));
						pstmt.setString(18, (String) aa.get("happenDt"));
						pstmt.setString(19, (String) aa.get("age"));
						pstmt.executeUpdate();
					}
				}
				for (int i = 0; i < dog.size(); i++) {
					sql = "select * from dogsample where s_desertionNo=?";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					JSONObject aa = (JSONObject) dog.get(i);
					pstmt.setString(1, (String) aa.get("desertionNo"));
					if (rs.next()) {
						
					}
//					sql = "delete from dogsample where s_desertionNo not in ?";
//					pstmt = con.prepareStatement(sql);
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
