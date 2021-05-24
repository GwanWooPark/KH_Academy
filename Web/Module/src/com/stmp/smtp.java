package com.stmp;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;


public class smtp {
	
	public static void mail(String toEmail, String fromEmail, String fromPw, String fromName, String title, String content) {

		// properties 설정 - stmp 서버와 관련된 정보 설정
		Properties props = new Properties();
		props.put("mail.smtp.user", fromEmail);				// 보내는 사람 메일 주소
		props.put("mail.smtp.host", "smtp.gmail.com");		// 발송할 smtp 서버. gmail 이용함. 네이버의 경우 smtp.naver.com
		props.put("mail.smtp.port", "465");					// smtp 통신 포트. gmail - 465, 네이버 - 587
		props.put("mail.smtp.starttls.enable", "true");		// 로그인 하기전에 tls 보호 연결로 연결 전환 (암호화)
		props.put("mail.smtp.auth", "true");				// smtp 인증 사용 설정

		// gmail 인증용 Secure Socket Layer 설정
		props.put("mail.smtp.socketFactory.port", "465");	// 소캣 팩토리 사용 시 연결할 포트 설정
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // smtp 소켓 만드는데 사용
		props.put("mail.smtp.socketFactory.fallback", "false");	// true일 경우 지정된 소켓 팩토리 클래스를 사용하여 소켓을 생성하지 못하면 java.net 사용하여 소켓 생성

		// properties에 저장된 설정 값으로 메일 세션 생성
		Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			// 인증 정보 - 암호 인증을 사용하기 위해 호출함
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail,fromPw);
				}
		});
				
		// 이메일 전송
		try {
			// 보내는 사람 설정
			InternetAddress addr = new InternetAddress();
			addr.setPersonal(fromName, "UTF-8");
			addr.setAddress(fromEmail);

			// MimeMessage클래스에 메일과 관련된 내용 지정
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(addr);
			// UTF-8로 되어있는 메일 보내기 - 한글 깨짐 해결
			msg.setSubject(MimeUtility.encodeText(title, "UTF-8","B"));	// 메일 제목 // "B" - Base64
			msg.setContent(content, "text/html; charset=UTF-8");		// 메일 내용
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			
			// 메세지 객체 msg 전송
			Transport.send(msg);
			System.out.println("메일 발송 완료");

			} catch (Exception e) {
				e.printStackTrace();
	
			}

	}


}
