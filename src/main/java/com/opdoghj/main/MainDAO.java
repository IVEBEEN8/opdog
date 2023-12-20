package com.opdoghj.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MainDAO {

	public static void listLoading(HttpServletRequest request, HttpServletResponse response) {
		
		Date currenDate =  new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currenDate);
		calendar.add(calendar.DAY_OF_MONTH, -17);		
		Date newDate = calendar.getTime();
		System.out.println(currenDate);
		System.out.println(newDate);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String bgnde =  dateFormat.format(newDate);
		String endde = dateFormat.format(currenDate);
		System.out.println(bgnde);
		System.out.println(endde);
		
		
		
		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
		String url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic?bgnde="+ bgnde +"&endde="+ endde +"&pageNo=1&numOfRows=10&upkind=417000&state=protect&_type=json&serviceKey=" + encodeKey;		
		
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
				System.out.println(dog.get(1));
				ArrayList<DogB> doglist = new ArrayList<DogB>();
				DogB d = null;
				for (int i = 0; i < dog.size(); i++) {
					JSONObject aa = (JSONObject) dog.get(i);
					String a = (String) aa.get("kindCd");
					String Cd[] = a.split("]");
					d = new DogB();
					d.setAge((String)aa.get("age"));
					d.setKindCd(Cd[1]);
					d.setPopfile((String)aa.get("popfile"));
					d.setSexCd((String)aa.get("sexCd"));
					d.setSpecialMark((String)aa.get("specialMark"));
					doglist.add(d);
					System.out.println(aa.get("noticeEdt"));
				}
				request.setAttribute("dog", doglist);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
