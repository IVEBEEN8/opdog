package com.opdoghj.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class MainDAO {

	public static void listLoading(HttpServletRequest request, HttpServletResponse response) {

		Date currenDate = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currenDate);
		calendar.add(calendar.DAY_OF_MONTH, -17);
		Date newDate = calendar.getTime();
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(currenDate);
		calendar2.add(calendar2.DAY_OF_MONTH,-10);
		Date dDay = calendar2.getTime();

		System.out.println(currenDate);
		System.out.println(newDate);
		System.out.println(dDay);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String endde = dateFormat.format(currenDate);
		String bgnde = dateFormat.format(newDate);
		System.out.println(bgnde);
		System.out.println(endde);
		
		
		
		
//		SimpleDateFormat dateFormatforC = new SimpleDateFormat("yyyy,M,d");
//		String newDateforC = dateFormatforC.format(newDate);
//		String dDayforC = dateFormatforC.format(dDay);
//		System.out.println(newDateforC);
//		System.out.println(dDayforC);
		

		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
		String url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic?bgnde=" + bgnde + "&endde="
				+ endde + "&pageNo=1&numOfRows=1000&upkind=417000&state=protect&_type=json&serviceKey=" + encodeKey;

		try {
			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			if (huc.getResponseCode() == 200) {
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");

				JSONParser jp = new JSONParser();
				JSONObject dogs = (JSONObject) jp.parse(isr);

				dogs = (JSONObject) dogs.get("response");
				dogs = (JSONObject) dogs.get("body");
				dogs = (JSONObject) dogs.get("items");
				JSONArray dog = (JSONArray) dogs.get("item");
				ArrayList<DogB> doglist = new ArrayList<DogB>();
				DogB d = null;
				for (int i = 0; i < dog.size(); i++) {
					JSONObject aa = (JSONObject) dog.get(i);
					String a = (String) aa.get("kindCd");
					String Cd[] = a.split("]");
					int noticeEdt = Integer.parseInt((String) aa.get("noticeEdt"));
					String bbb = (String)aa.get("noticeEdt");
					Date ccc = dateFormat.parse(bbb);
					long diffMS = currenDate.getTime()-ccc.getTime();
					long diffdays = 10-(diffMS/(24*60*60*1000L))%365;
					d = new DogB();
					if (ccc.after(dDay)) {

						d.setAge((String) aa.get("age"));
						d.setKindCd(Cd[1]);
						d.setPopfile((String) aa.get("popfile"));
						d.setSexCd((String) aa.get("sexCd"));
						d.setSpecialMark((String) aa.get("specialMark"));
						d.setDate(noticeEdt);
						d.setDday(diffdays);
						doglist.add(d);
					}

				}
				Comparator<DogB> comparedDate = Comparator.comparing(DogB::getDate, Comparator.naturalOrder());
				ArrayList<DogB> comparedDogList = (ArrayList<DogB>) doglist.stream().sorted(comparedDate)
						.collect(Collectors.toList());

				request.setAttribute("dog", comparedDogList);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void totalCountLoading(HttpServletRequest request) {
		String encodeKey = "I0hU0%2BkJjjUJgSP2JDRG%2BB0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR%2BiMQ%3D%3D"; // 인증키
		String decodeKey = "I0hU0+kJjjUJgSP2JDRG+B0keboYbyMGx9zmERg13WAwHhmlLgpJ4zk1Uyy7cvWmN9hKEzIGdunsMPK7SR+iMQ==";
		String url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic?&pageNo=1&numOfRows=1000&state=protect&upkind=417000&_type=json&serviceKey="
				+ encodeKey;

		try {
			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			HttpSession hs = request.getSession();

			if (huc.getResponseCode() == 200) {
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");

				JSONParser jp = new JSONParser();
				JSONObject dogs = (JSONObject) jp.parse(isr);

				dogs = (JSONObject) dogs.get("response");
				dogs = (JSONObject) dogs.get("body");
				System.out.println(dogs.get("totalCount"));
				int count = Integer.parseInt(String.valueOf(dogs.get("totalCount")));
				request.setAttribute("count", count);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
