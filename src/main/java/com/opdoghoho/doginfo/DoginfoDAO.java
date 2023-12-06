package com.opdoghoho.doginfo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class DoginfoDAO {
	public static void main(String[] args) {
		
	}

	public static void sido(HttpServletRequest request) {
		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
		String url= "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido?numOfRows=100&pageNo=1&_type=json&serviceKey="+encodeKey;
		
		try {
			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			System.out.println(isr);
			
			JSONParser jp = new JSONParser();
			JSONObject sidos = (JSONObject) jp.parse(isr);
			sidos = (JSONObject) sidos.get("response");
			sidos = (JSONObject) sidos.get("body");
			sidos = (JSONObject) sidos.get("items");
			JSONArray sido = (JSONArray) sidos.get("item");
			ArrayList<sidoB> sidoB = new ArrayList<sidoB>();
			sidoB s =  null;
			for (int i = 0; i < sido.size() ; i++) {
				JSONObject name = (JSONObject) sido.get(i);
				s = new sidoB();
				s.setOrgCd((String)name.get("orgCd"));
				s.setOrgdownNm((String)name.get("orgdownNm"));
				sidoB.add(s);
			}	
			request.setAttribute("sido", sidoB);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	public static void sigungu(HttpServletRequest request, HttpServletResponse response) {
		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
		String url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu?upr_cd="+request.getParameter("value")+"&_type=json&serviceKey="+encodeKey;
		try {
			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			
			JSONParser jp = new JSONParser();
			JSONObject sigungus = (JSONObject) jp.parse(isr);
			sigungus = (JSONObject) sigungus.get("response");
			sigungus = (JSONObject) sigungus.get("body");
			sigungus = (JSONObject) sigungus.get("items");
			JSONArray sigungu = (JSONArray) sigungus.get("item");

			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(sigungu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void center(HttpServletRequest request, HttpServletResponse response) {
		String a = request.getParameter("value");
		String Cd[] = a.split("!");
		
		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
		String url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/shelter?upr_cd="+Cd[0]+"&org_cd="+Cd[1]+"&_type=json&serviceKey="+encodeKey;
		try {
			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			
			JSONParser jp = new JSONParser();
			JSONObject centers = (JSONObject) jp.parse(isr);
			centers = (JSONObject) centers.get("response");
			centers = (JSONObject) centers.get("body");
			centers = (JSONObject) centers.get("items");
			JSONArray center = (JSONArray) centers.get("item");
			System.out.println(center);

			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(center);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	public static void kind(HttpServletRequest request) {
		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
		String url= "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido?numOfRows=100&pageNo=1&_type=json&serviceKey="+encodeKey;
		
		try {
			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			System.out.println(isr);
			
			JSONParser jp = new JSONParser();
			JSONObject sidos = (JSONObject) jp.parse(isr);
			sidos = (JSONObject) sidos.get("response");
			sidos = (JSONObject) sidos.get("body");
			sidos = (JSONObject) sidos.get("items");
			JSONArray sido = (JSONArray) sidos.get("item");
			ArrayList<sidoB> sidoB = new ArrayList<sidoB>();
			sidoB s =  null;
			for (int i = 0; i < sido.size() ; i++) {
				JSONObject name = (JSONObject) sido.get(i);
				s = new sidoB();
				s.setOrgCd((String)name.get("orgCd"));
				s.setOrgdownNm((String)name.get("orgdownNm"));
				sidoB.add(s);
			}	
			request.setAttribute("sido", sidoB);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
