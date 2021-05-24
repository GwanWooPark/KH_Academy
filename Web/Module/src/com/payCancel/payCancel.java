package com.payCancel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;
import java.util.Map.Entry;


public class payCancel {

    public payCancel() {

    }
    public static final String IMPORT_TOKEN_URL = "https://api.iamport.kr/users/getToken";
    public static final String IMPORT_CANCEL_URL = "https://api.iamport.kr/payments/cancel";

    public static final String KEY = "imp_apikey";
    public static final String SECRET = "ekKoeW8RyKuT0zgaZsUtXXTLQ4AhPFW3ZGseDA6bkA5lamv9OqDMnxyeB9wqOsuO9W3Mx9YSJ4dTqJ3f";

    // 아임포트 인증(토큰)을 받아주는 함수
    public String getImportToken() {
        String result = "";
        HttpClient client = HttpClientBuilder.create().build();
        // HttpClient 생성
        HttpPost post = new HttpPost(IMPORT_TOKEN_URL);
        // Post URL 생성
        Map<String,String> m =new HashMap<String,String>();

        m.put("imp_key", KEY);
        m.put("imp_secret", SECRET);
        try {
            post.setEntity(new UrlEncodedFormEntity(convertParameter(m)));
            //수정할 수 있는 HTTP요청을 포함하는 엔티티
            // NameValuePair형식으로 POST값을 보냄
            // UrlEncodedFormEntity : 매개 변수를 인코딩하고 필요한 형식으로 출력

            HttpResponse res = client.execute(post);
            // 요청을 실행하고 응답을 받는다.

            ObjectMapper mapper = new ObjectMapper();

            String body = EntityUtils.toString(res.getEntity());
            // 요청에 응답된 필요한 데이터(res.getEntity)를 가지고 온다.


            JsonNode rootNode = mapper.readTree(body);
            //mapper로 데이터(문자열)를 읽어서 트리형식(JsonNode)으로 만들수 있다.
            JsonNode resNode = rootNode.get("response");
            //읽어온 데이터중 response에 해당하는 부분을 가지고 옴

            result = resNode.get("access_token").asText();
            // 해당 데이터를 String으로 변환

        } catch (Exception e) {
            e.printStackTrace();
        } return result;
    }

    // Map을 사용해서 Http요청 파라미터를 만들어 주는 함수
    private List<NameValuePair> convertParameter(Map<String,String> paramMap){
        // NameValuePair
        // httpClient 컴포넌트는 클라이언트에서 서버로 데이터를 전송하기 위해 NameValuePair와 URIBuilder를 제공

        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        Set<Entry<String,String>> entries = paramMap.entrySet();
        for(Entry<String,String> entry : entries) {
            // paramList에 키와 값 형태로 저장
            paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return paramList;
    }

    // 결제취소
    public void cancelPayment(String token, String mid) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(IMPORT_CANCEL_URL);
        Map<String, String> map = new HashMap<String, String>();
        post.setHeader("Authorization", token);
        // 설정된 이름으로 첫번째 헤더를 덮어 쓴다.

        map.put("merchant_uid", mid);
        String asd = "";
        try {
            post.setEntity(new UrlEncodedFormEntity(convertParameter(map)));
            HttpResponse res = client.execute(post);
            ObjectMapper mapper = new ObjectMapper();
            String enty = EntityUtils.toString(res.getEntity());
            JsonNode rootNode = mapper.readTree(enty);
            asd = rootNode.get("response").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (asd.equals("null")) {
            System.out.println("환불실패");
        } else {
            System.out.println("환불성공");
        }
    }
}
