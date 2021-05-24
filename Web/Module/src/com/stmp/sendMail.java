package com.stmp;

public class sendMail {
	public static void main(String[] args) {
		// 받는 사람 메일 주소 
		String toEmail = "";
		
		// 보내는 사람 메일 주소 (gmail)
		String fromEmail = "";
		
		// 보내는 사람 메일 비밀번호
		String fromPw = "";
		
		// 보내는 사람 이름
		String fromName = "";
		
		// 메일 제목
		String title = "";
		
		// 메일 내용
		String content = "";
		smtp.mail(toEmail, fromEmail, fromPw, fromName, title, content);
		
	}
}
