package com.socialLoginModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


@WebServlet("/login.do")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();
		
		String client_id = "39cbfc25bdd943573118565016e1297d";
		String redirect_uri = URLEncoder.encode("http://localhost:8787/socialLoginModule/login.do?", StandardCharsets.UTF_8);
		
		// 응답받은 코드
		String code = request.getParameter("code");
			
		// 토큰을 받기 위한 url 주소
		String kakao_apiURL = "https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id=" + client_id + "&redirect_uri=" + redirect_uri
								+ "&code=" + code;

		try {
			URL url = new URL(kakao_apiURL);
		    // 웹페이지에 엑세스하기
		    // urlConnection은 웹을 통해 데이터 주고 받을 때 사용
		    HttpURLConnection con = (HttpURLConnection)url.openConnection();
		        
		    // Get 메서드 사용
		    // setRequestMEthod 를 사용하여 메서드 변경 가능
		    con.setRequestMethod("GET");
		       
		    // 응답 코드를 받아옴
		    int responseCode = con.getResponseCode();
		        
		    // 입력받은 문자열의 길이가 가변적일 수 있어서 Buffer사용
		    BufferedReader br;
		        
		    if(responseCode==200) { // 정상 호출
		    	// inputStream을 char형태로 처리하기위해 중개자 역할의 InputStreamReader 사용
		        // BufferedReader로 입력받은 char type을 직렬화 - 문자열로 저장
		        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		    } else {  // 에러 발생
		        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		    }
		    
		    String inputLine;
		    StringBuffer res = new StringBuffer();
		    while ((inputLine = br.readLine()) != null) {
		    	res.append(inputLine);
		    }
		    br.close();
		        
		    if(responseCode==200) {
		    	// json 사용해서 access_token 값 가져오기
				JSONParser parsing = new JSONParser();
				Object obj = parsing.parse(res.toString());
				JSONObject jsonObj = (JSONObject)obj;
				System.out.println(jsonObj);
		        	
				// 토큰 값 저장
				String access_token = (String)jsonObj.get("access_token");
				//-------------------------------------------------------------
				// 토큰을 사용하여 사용자 정보 받아오기
				// 정보 받아오기 위해 필요한 값 입력
				String header = "Bearer " + access_token;
					
				kakao_apiURL = "https://kapi.kakao.com/v1/user/access_token_info";
				url = new URL(kakao_apiURL);
				con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Authorization", header);

				responseCode = con.getResponseCode();

				if(responseCode==200) { // 정상 호출
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else {  // 에러 발생
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}

				res = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					res.append(inputLine);
				}
				br.close();
		    
				// json 사용해서 id값(고유번호) 가져오기
				// 카카오에서 필수적으로 받아올 수 있는 정보가 id값 밖에 없어서 이것만 받아옴
				obj = parsing.parse(res.toString());
				jsonObj = (JSONObject)obj;
				long kakao_id = (long) jsonObj.get("id");
				jsResponse(response, "카카오 고유번호는 " + kakao_id +", 연동 성공", "socialLogin.jsp");
		  
				// DB연동 회원가입, 로그인 기능 생략
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsResponse(response, "연동 실패", "socialLogin.jsp");
		
	}
	
	private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException {
		String responseText = "<script>"
							+ "alert('"+msg+"');"
							+ "location.href='"+url+"';"
							+ "</script>;";
		response.getWriter().append(responseText);
	}
	
}
