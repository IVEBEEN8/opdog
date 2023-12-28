package com.opdogkl.shop.fashion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.opdoghw.centerinfo.DBManager_khw;

import com.opdogkl.shop.NaverAPI;

public class FashionDAO {
	// 강아지 패션 전체 조회하는 일
	private static ArrayList<Fashion> fashions;
	


	
	public static void getAllFashion(HttpServletRequest request) {
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from fashion_kl";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Fashion fs = null;
			fashions = new ArrayList<Fashion>();
			
			while(rs.next()) {
				fs = new Fashion();
				fs.setFs_no(rs.getInt("fs_no"));
				fs.setFs_img(rs.getString("fs_img"));
				fs.setFs_title(rs.getString("fs_title"));
				fs.setFs_price(rs.getInt("fs_price"));
				fs.setFs_brand(rs.getString("fs_brand"));
				
				System.out.println(rs.getString("fs_title"));
				System.out.println(rs.getString("fs_brand"));
				fashions.add(fs);
				
				
			}
			request.setAttribute("fashions", fashions);
			System.out.println("어트리뷰트 생성!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
	}
	
public static void getFashion(HttpServletRequest request) {
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from fashion_kl where fs_no=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();
			Fashion fs = null;
			
			if (rs.next()) {
				fs = new Fashion();
				fs.setFs_no(rs.getInt("fs_no"));
				fs.setFs_img(rs.getString("fs_img"));
				fs.setFs_title(rs.getString("fs_title"));
				fs.setFs_price(rs.getInt("fs_price"));
				fs.setFs_brand(rs.getString("fs_brand"));
				
				System.out.println(rs.getString("fs_title"));
				System.out.println(rs.getString("fs_brand"));
				
				
			}
			request.setAttribute("fashion", fs);
			System.out.println("패션 어트리뷰트 생성!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
	}
	
	

	public static void paging(int page, HttpServletRequest request) {
		request.setAttribute("curPageNo", page);
		int cnt = 12; 		// 한페이지당 보여줄 개수
		int total = fashions.size();		// 총 데이터 개수 
		// 총페이지수 
		int pageCount = (int) Math.ceil((double)total/cnt);
		request.setAttribute("pageCount", pageCount);
		
		
		int start = total - (cnt * (page - 1));
		
		int end = (page == pageCount) ? -1 : start - (cnt + 1);
		
		ArrayList<Fashion> items = new ArrayList<Fashion>();
		for (int i = start-1; i > end; i--) {
			items.add(fashions.get(i));
		}
		request.setAttribute("fashions", items);
	}

	
	
	public static void regFashion(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			String str = "강아지패션";
			str = URLEncoder.encode(str,"utf-8");
			System.out.println(str);
			
			String url = "https://openapi.naver.com/v1/search/shop.json?query=" + str + "&display=48";
			URL u = new URL(url);
			HttpsURLConnection huc =(HttpsURLConnection)u.openConnection();
			huc.addRequestProperty("X-Naver-Client-Id", "xsNn_8ET7Ge8rnSa6ees");
			huc.addRequestProperty("X-Naver-Client-Secret", "s8uIyGeGT8");
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			// JSON parse 객체 (json 파싱하려고)
			JSONParser jp = new JSONParser();
			JSONObject naverData = (JSONObject) jp.parse(isr);
			System.out.println(11);
			System.out.println(naverData);	
			JSONArray items = (JSONArray) naverData.get("items");
			con = DBManager_khw.connect();
			String sql = "insert into naver_kl VALUES (naver_kl_seq.nextval,?,?,?,?)";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			pstmt = con.prepareStatement(sql); 
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
			if (title.contains(brand)) {
				title = title.replace(brand, "");
			}
			
			
//			System.out.println("------------------------------------------------");
//			System.out.println(items.size());
			System.out.println("----------파파고 API 시작-----------------");
			
			String clientId = "f8E1dHSfLIZGwep16ykM";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "g9Ae4Vludr";//애플리케이션 클라이언트 시크릿값";
	        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
	        String text;
	        
	        try { 
	            text = URLEncoder.encode(title+"\n"+brand, "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("인코딩 실패", e);
	        }

	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);

	        String responseBody = post(apiURL, requestHeaders, text);

	        System.out.println(responseBody);
	        
	        JSONParser jsonParser = new JSONParser();

	        JSONObject jsonObject = (JSONObject) jsonParser.parse(responseBody);
	        JSONObject objMessage = (JSONObject) jsonObject.get("message");
	        JSONObject objResult= (JSONObject) objMessage.get("result");
	        String translatedText = (String) objResult.get("translatedText");
	        
	       System.out.println(translatedText);
	        
	       String[] splitStr= translatedText.split("\n");

	       String translatedTitle = splitStr[0];
	       String translatedBrand = splitStr[1];

			System.out.println("----------파파고 API 끝-----------------");
			
			
			pstmt.setString(1, (String)item.get("image"));
			pstmt.setString(2, translatedTitle);
			pstmt.setLong(3, Long.parseLong(item.get("lprice").toString()));

			pstmt.setString(4, translatedBrand);
			pstmt.executeUpdate();
			System.out.println("등록성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("등록실패");
			
		} finally {
			DBManager_khw.close(con, pstmt, null);
		}
		
	}
	// 파파고 api 메소드 
		private static String post(String apiUrl, Map<String, String> requestHeaders, String text){
	        HttpURLConnection con = connect(apiUrl);
	        NaverAPI shop = new NaverAPI();
	        String postParams = "source=ko&target=en&text=" + text; //원본언어: 한국어 (ko) -> 목적언어: 영어 (en)
	        try {
	            con.setRequestMethod("POST");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }

	            con.setDoOutput(true);
	            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
	                wr.write(postParams.getBytes());
	                wr.flush();
	            }

	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
	                return readBody(con.getInputStream());
	            } else {  // 에러 응답
	                return readBody(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }

	    private static HttpURLConnection connect(String apiUrl){
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }

	    private static String readBody(InputStream body){
	        InputStreamReader streamReader = new InputStreamReader(body);

	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();

	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }

	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }
	    }

		public static void sortFashion(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "";
			String asc = "select * from fashion_kl order by fs_price asc";		// 낮은가격순
			String desc = "select * from fashion_kl order by fs_price desc";	// 높은가격순
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DBManager_khw.connect();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				Fashion fs = null;
				fashions = new ArrayList<Fashion>();
				
				while(rs.next()) {
					fs = new Fashion();
					fs.setFs_no(rs.getInt("fs_no"));
					fs.setFs_img(rs.getString("fs_img"));
					fs.setFs_title(rs.getString("fs_title"));
					fs.setFs_price(rs.getInt("fs_price"));
					fs.setFs_brand(rs.getString("fs_brand"));
					
					System.out.println(rs.getString("fs_title"));
					System.out.println(rs.getString("fs_brand"));
					fashions.add(fs);
					
					
				}
				request.setAttribute("fashions", fashions);
				System.out.println("어트리뷰트 생성!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager_khw.close(con, pstmt, rs);
			}
			
		}
	
}
