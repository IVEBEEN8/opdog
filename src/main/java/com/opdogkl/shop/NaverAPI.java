package com.opdogkl.shop;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NaverAPI {
	public static void main(String[] args) {

//		네이버 개발자 센터
//		xsNn_8ET7Ge8rnSa6ees
//		s8uIyGeGT8
		
//		"https://openapi.naver.com/v1/search/shop.json?query="
		
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("검색어? ");
			String str = sc.next();
			
			str = URLEncoder.encode(str,"utf-8");
			System.out.println(str);
			
			String url = "https://openapi.naver.com/v1/search/shop.json?query=" + str + "&display=30";
			URL u = new URL(url);
			HttpsURLConnection huc =(HttpsURLConnection)u.openConnection();
			huc.addRequestProperty("X-Naver-Client-Id", "xsNn_8ET7Ge8rnSa6ees");
			huc.addRequestProperty("X-Naver-Client-Secret", "s8uIyGeGT8");
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			// JSON parse 객체 (json 파싱하려고)
			JSONParser jp = new JSONParser();
			JSONObject naverData = (JSONObject) jp.parse(isr);
			System.out.println(naverData);	
			JSONArray items = (JSONArray) naverData.get("items");
			
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			
			for (int i = 0; i < items.size(); i++) {
					JSONObject item = (JSONObject) items.get(i);
			
			
			String title = (String) item.get("title");
//			String title = item.get("title") + "";
//			String title = item.get("title").toString();
			title = title.replace("<b>", "");
			title = title.replace("</b>", "");
			title = title.replace("&amp;", " ");
//			System.out.println("사진	:	" + item.get("image"));
//			System.out.println("품명	:	" + title);
//			System.out.println("가격	:	" + item.get("lprice"));
//			System.out.println("브랜드	:	" + item.get("brand"));
			String brand = (String) item.get("brand");
			if (brand.equals("")) {
				brand = "no brand";
			}
			
//			System.out.println("------------------------------------------------");
//			System.out.println(items.size());
			
			
			
			String sql = "insert into fashion_kl VALUES (fashion_kl_seq.nextval,?,?,?,?)";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, (String)item.get("image"));
			pstmt.setString(2, title);
			pstmt.setLong(3, Long.parseLong(item.get("lprice").toString()));

			pstmt.setString(4, brand);
			System.out.println("업로드완료!");
			pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	// 강아지 사료, 강아지 간식, 강아지 장난감, 강아지 패션
}
