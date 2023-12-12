package com.opdoghoho.doginfo;

public class DatabaseSetter {
	public static void main(String[] args) {
////		---------------- 보호소 table setter --------------------		
////		api 키
//		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
//		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
//		String statecode = null;
//		String citycode = null;
//		String url= null;
////		connection set
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "select* from gungu";	
//		try {
//
////			db insert
//			con = DBManager.connect();
//			pstmt = con.prepareStatement(sql); 
//			rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				statecode = rs.getString("g_uprCd");
//				citycode = rs.getString("g_orgCd");
//				System.out.println(statecode);
//				
//				sql = "insert into shelter values(?,?,?,?)";
//				pstmt = con.prepareStatement(sql); 
//				
//
//				url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/shelter?upr_cd="+statecode+"&org_cd="+citycode+"&_type=json&serviceKey="+encodeKey;				
//				URL u = new URL(url);
//				HttpURLConnection huc = (HttpURLConnection) u.openConnection();
//				InputStream is = huc.getInputStream();
//				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
//				
//				JSONParser jp = new JSONParser();
//				JSONObject centers = (JSONObject) jp.parse(isr);
//				centers = (JSONObject) centers.get("response");
//				centers = (JSONObject) centers.get("body");
//				centers = (JSONObject) centers.get("items");
//				JSONArray center = (JSONArray) centers.get("item");
//				if (center==null) {
//					continue;
//				}
//				for (int i = 0; i < center.size(); i++) {
//					JSONObject aa = (JSONObject) center.get(i);
//					pstmt.setString(1, statecode);
//					pstmt.setString(2, citycode);
//					pstmt.setString(3, (String) aa.get("careRegNo"));
//					pstmt.setString(4, (String) aa.get("careNm"));
//					pstmt.executeUpdate();
//				}
//			}
//			
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

////		---------------- 군/구 table setter --------------------		
////		api 키
//		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
//		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
//		String statecode = null;
//		String url= null;
////		connection set
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "select s_orgCd from sido";	
//		try {
//
////			db insert
//			con = DBManager.connect();
//			pstmt = con.prepareStatement(sql); 
//			rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				statecode = rs.getString("s_orgCd");
//				System.out.println(statecode);
//				
//				sql = "insert into gungu values(?,?,?)";
//				pstmt = con.prepareStatement(sql); 
//				
//
//				url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu?upr_cd="+statecode+"&_type=json&serviceKey="+encodeKey;				
//				URL u = new URL(url);
//				HttpURLConnection huc = (HttpURLConnection) u.openConnection();
//				InputStream is = huc.getInputStream();
//				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
//				
//				JSONParser jp = new JSONParser();
//				JSONObject gungus = (JSONObject) jp.parse(isr);
//				gungus = (JSONObject) gungus.get("response");
//				gungus = (JSONObject) gungus.get("body");
//				gungus = (JSONObject) gungus.get("items");
//				if (statecode.equals("5690000")) {
//					continue;
//				}
//				JSONArray gungu = (JSONArray) gungus.get("item");
//				for (int i = 0; i < gungu.size(); i++) {
//					JSONObject aa = (JSONObject) gungu.get(i);
//					pstmt.setString(1, (String) aa.get("uprCd"));
//					pstmt.setString(2, (String) aa.get("orgCd"));
//					pstmt.setString(3, (String) aa.get("orgdownNm"));
//					pstmt.executeUpdate();
//				}
//			}
//			
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		------------- 시/도 table setter -----------------
//		api 키
//		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
//		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
//		String url= "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido?numOfRows=100&pageNo=1&_type=json&serviceKey="+encodeKey;
////		connection set
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "insert into sido values(?,?)";	
//		try {
////			api 호출
//			URL u = new URL(url);
//			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
//			InputStream is = huc.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
//			
//			JSONParser jp = new JSONParser();
//			JSONObject sidos = (JSONObject) jp.parse(isr);
//			sidos = (JSONObject) sidos.get("response");
//			sidos = (JSONObject) sidos.get("body");
//			sidos = (JSONObject) sidos.get("items");
//			JSONArray sido = (JSONArray) sidos.get("item");
//			
////			db insert
//			con = DBManager.connect();
//			pstmt = con.prepareStatement(sql); 
//			
//			for (int i = 0; i < sido.size(); i++) {
//				JSONObject aa = (JSONObject) sido.get(i);
//				pstmt.setString(1, (String) aa.get("orgCd"));
//				pstmt.setString(2, (String) aa.get("orgdownNm"));
//				pstmt.executeUpdate();
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
