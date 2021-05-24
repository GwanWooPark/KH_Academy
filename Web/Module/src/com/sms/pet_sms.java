package com.sms;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//필요 jar : gson-2.8.6.jar, ini4j-0.5.4.jar, commons-codec-1.11.jar
public class pet_sms {
	
	
	public static void main(String[] args) {
		
		try {
			SendSMS("20210102", "16:00", "장근장근병원", "이장근", "010-6319-4712");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	
	public static void SendSMS(String book_date, String book_time, String business_name, String Name, String phone) throws IOException {
		String massage = null;
		if(book_time==null) {
			massage = Name + "님 " + book_date.charAt(4) + "월" + book_date.charAt(7) + "일" + business_name + "에 예약되었습니다.";
		}else {
			massage = Name + "님 " + book_date.charAt(4) + "월" + book_date.charAt(7) + "일" + book_time + " " + business_name + "에 예약되었습니다.";
		}
		
		
		String targetUrl = "https://api.solapi.com/messages/v4/send"; 
		//값을 보낼 URL 주소 https://api.solapi.com/<ServiceName>/<Version>/<ResourcePath>
		
		String parameters = " {\"message\":{\"to\":\""+phone+"\",\"from\":\"01063194712\",\"text\":\""+massage+"\",\"type\":\"SMS\"}}";
		System.out.println(parameters);
		/* parameter 내용
		Name			Type 		Required 		Description
		to				string			O			수신번호
		from			string			O			발신번호(사전 등록된 전화번호만 사용 가능)
		text			string			O			메시지 내용(한글 1,000자, 영문 2,000자 제한)
		type			string						메시지 타입
		country			string						국가번호 (기본: 82, 미국(캐나다):1, 중국: 86, 일본: 81)
		subject			string						메시지 제목 : 한글 20자, 영문 40자 제한
		imageId 		string						Storage API에 등록된 이미지 아이디 참고
		kakaoOptions 	object						친구톡, 알림톡을 보내기 위한 옵션
		customFields	object						확장 필드로 사용. 키는 30자, 값은 100자 제한
		autoTypeDetect	boolean						타입 설정이 없을 경우 자동으로 설정함. 기본 값은 true
		 */
		
		
		URL url = new URL(targetUrl); //URL 생성
		
		
		HttpURLConnection con = (HttpURLConnection)url.openConnection(); //URL에 연결 객체 생성

	    con.setRequestMethod("POST"); //보내는 방식 : POST

		con.setRequestProperty("Authorization", APIInit.getHeaders());//인증키 세팅
		con.setRequestProperty("Content-Type", "application/json"); //타입 json으로 설정
	    con.setDoOutput(true);

	    //OutputStreamWriter는 바이트 단위로 쓰는 OutputStream을 이용해서 문자 단위로 쓰는 것을 바이트 단위로 쓰도록 변형
	    OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream()); //output스트림설정
	    BufferedWriter bw = new BufferedWriter(osw);//bufferwriter 설정 : 속도향상
	    PrintWriter pw = new PrintWriter(bw);//pw 프린트 할 수 있는 생성자
	    pw.print(parameters); //파라미터를 url주소에다 넣어주기
	    pw.flush(); //남은거 다 보내기
	    pw.close(); // 닫기
	      
	    int responseCode = con.getResponseCode(); //해당 서버에서 응답 값 받기
	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); // 인풋스트림 버퍼로 바꿔서
	    String line;
	    StringBuffer smsresponse = new StringBuffer(); 
	    while ((line = in.readLine()) != null) { // 가져온 응답값이 끝날때 까지 반복
	      smsresponse.append(line); //스트링 버퍼에 계속 추가
	    }
	    in.close(); //끝나면 닫기
	    /*
	     * 
		리스폰스 값 정보
		Name			Type		Should Return		Description
		groupId			string			O				그룹 아이디
		messageId		string 			O				메시지 아이디
		accountId		string			O				계정 고유 번호
		statusMessage	string			O				상태 메시지 참고
		statusCode		string			O				상태 코드 참고
		to				string			O				수신번호
		from			string			O				발신번호 :사전 등록된 전화번호만 사용 가능
		type			string			O				메시지 타입
		country			string			O				국가번호 (기본: 82, 미국(캐나다):1, 중국: 86, 일본: 81)
		
		메시지 상태 코드 
		1xxx	:	접수 중 오류
		2000	:	정상 접수
		2xxx	:	플랫폼 내부 처리 중 오류
		3000	:	이통사로 접수 완료(정상)
		3xxx	:	통신사에서 처리 중 오류
		4000	:	발송 처리를 완료함
		세부 내용은 사이트 참조 :  https://docs.solapi.com/api-reference/message-status-codes
		 * 
		 */

	    System.out.println("HTTP response code : " + responseCode);
	    System.out.println("HTTP body : " + smsresponse.toString());	    
	    	
	    JsonObject resjson = (JsonObject) JsonParser.parseString(smsresponse.toString()); //Json형태로 오는 응답값 중 상태만 뽑아서 리턴~!
	    String  statusMessage = resjson.get("statusMessage").getAsString();
		System.out.println(statusMessage);
	}
}
