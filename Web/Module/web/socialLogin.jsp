<%@page import="java.math.BigInteger"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.net.URLEncoder"%>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<%
response.setContentType("text/html; charser=UTF-8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- rest api를 사용한 카카오 로그인 (네이버도 같은 방식으로 구현) -->

<%
		// 사용자 동의 화면 호출 -> 인가 코드 발급 요청
		
		// api 신청 시 받은 rest api 키
		String clientId = "39cbfc25bdd943573118565016e1297d";
		
		// redirect 주소
		String redirectUri = URLEncoder.encode("http://localhost:8787/socialLoginModule/login.do?", StandardCharsets.UTF_8);

		// 난수 생성
		SecureRandom random = new SecureRandom();
			    
		// 로그인 요청과 콜백 간의 상태 유지하기 위해 사용하는 임의 문자열
		String state = new BigInteger(130, random).toString(); // BigInteger : 문자열 형태로 이루어져 있어 숫자의 범위가 무한함
		
		// 띄워지는 화면에서 추가 상호작용
		// login : 화면 띄울 때마다 카카오 계정 로그인 화면 출력
		// none : 사용자에게 동의 화면을 노출하지 않고 코드 발급받을 때 사용
		String prompt = "login";
		String apiUrl = "https://kauth.kakao.com/oauth/authorize?client_id=" + clientId + "&redirect_uri=" + redirectUri + "&response_type=code&" + "&state=" + state + "&prompt=" + prompt;

%>
		<a href="<%=apiUrl %>"><img src="${pageContext.request.contextPath}/resources/image/kakaologo.png"/></a>

</body>
</html>