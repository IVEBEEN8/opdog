package com.opdoghw.checkregnm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CheckRegNmDAO {

	@SuppressWarnings("unchecked")
	public static void translateInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			String dogNm = request.getParameter("dogNm");
			String sexNm = request.getParameter("sexNm");
			String kindNm = request.getParameter("kindNm");
			String orgNm = request.getParameter("orgNm");

			dogNm = papagoTranslate(dogNm);
			sexNm = papagoTranslate(sexNm);
			kindNm = papagoTranslate(kindNm);
			orgNm = papagoTranslate(orgNm);

			JSONArray translatedInfo = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("dogNm", dogNm);
			obj.put("sexNm", sexNm);
			obj.put("kindNm", kindNm);
			obj.put("orgNm", orgNm);

			System.out.println(obj);
			translatedInfo.add(obj);
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(translatedInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	private static String papagoTranslate(String text) {
		try {
			//String clientId = "G_LumDg1eMO6O8wBrhcP";
			//String clientSecret = "WAFpoo4142";
			String clientId = "f8E1dHSfLIZGwep16ykM";// 애플리케이션 클라이언트 아이디값";
			String clientSecret = "g9Ae4Vludr";
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

}
