package com.chatbot;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class openChat {

	public static String opendialog() throws IOException, ParseException {
		
		HttpSession session = null;
	    // 대화 세션을 설정할 토큰을 받기 위해 연결에 필요한 정보 셋팅
		String openApiURL = "http://aiopen.etri.re.kr:8000/Dialog";
		String accessKey = "b75624ad-9e2a-40da-9280-02e21b2e93dd";


		String domain = "chatbot";
		String access_method = "internal_data";
		String method = "open_dialog";
		Gson gson = new Gson();
		
		Map<String, Object> APIrequest = new HashMap<>();
		Map<String, String> argument = new HashMap<>();
		
		argument.put("name", domain);
		argument.put("access_method", access_method);
		argument.put("method", method);
		
		APIrequest.put("access_key", accessKey);
		APIrequest.put("argument", argument);
		
		
		URL url;
		String responBody;

		// 웹페이지에 엑세스하기
		// urlConnection은 웹을 통해 데이터 주고 받을 때 사용
		url = new URL(openApiURL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		// 요청 방식
		con.setRequestMethod("POST");
		// 서버에서 온 데이터를 출력할 수 있는 상태인지 - true
		con.setDoOutput(true);
		// 출력 스트림 요청 - byte 출력
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		// 바이트 배열을 출력스트림에 작성
		wr.write(gson.toJson(APIrequest).getBytes(StandardCharsets.UTF_8));
		// 버퍼링된 출력 바이트가 스트림에 기록됨
		wr.flush();
		wr.close();
		InputStream is = con.getInputStream();

		// available : 입력 스트림에서 읽을 수 있거나 건너뛸 수 있는 바이트수 추정치를 반환
		byte[] buffer = new byte[is.available()];

		responBody = new String(buffer);

		JSONParser parser = new JSONParser();
		JSONObject res_object = (JSONObject) parser.parse(responBody);
		JSONObject return_object = (JSONObject) res_object.get("return_object");
		// 대화 세션 생성을 위한 고유id값 얻기
		String uuid = (String) return_object.get("uuid");
		// 세션에 저장

		return uuid;
	}
}