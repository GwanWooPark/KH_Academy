package com.chatbot;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import com.google.gson.Gson;


@WebServlet("/chatbot.do")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		// 대화 연결에 필요한 정보 셋팅
		String openApiURL = "http://aiopen.etri.re.kr:8000/Dialog";
	    String accessKey = "b75624ad-9e2a-40da-9280-02e21b2e93dd";
		String method = "dialog";

	    // URL과 접근키 받아옴
		String uuid = (String) session.getAttribute("uuid");

		// 보낸 메시지를 받아온다.
		String text = request.getParameter("message");

		Gson gson = new Gson();
		 
        Map<String, Object> APIrequest = new HashMap<>();
        Map<String, String> argument = new HashMap<>();
		
        argument.put("uuid", uuid);
        argument.put("method", method);
        argument.put("text", text);
 
        APIrequest.put("access_key", accessKey);
        APIrequest.put("argument", argument);
 
 
        URL url;
        String responBody;

        try {
        	url = new URL(openApiURL);
        	HttpURLConnection con = (HttpURLConnection)url.openConnection();
        	con.setRequestMethod("POST");
        	con.setDoOutput(true);
 
        	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        	wr.write(gson.toJson(APIrequest).getBytes(StandardCharsets.UTF_8));
        	wr.flush();
        	wr.close();

            InputStream is = con.getInputStream();
            byte[] buffer = new byte[is.available()];
            responBody = new String(buffer);

            // 응답받은 데이터 중 메세지만 잘라냄
            int a = responBody.indexOf("\"system_text\":") + "system_text".length() + 4;
            int b = responBody.indexOf("n\"") - 1;
            String result = responBody.substring(a, b);
            
            // json에 메세지 담기
            JSONObject obj = new JSONObject();
            obj.put("senderName", "챗봇");
            obj.put("message", result);
            
            // ajax 응답
            response.getWriter().print(obj);

                
        } catch (IOException e) {
                e.printStackTrace();
        }
    }


}
