<%@ page import="com.chatbot.openChat" %>
<%@ page import="org.json.simple.parser.ParseException" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charser=UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	*{ margin: 0; padding: 0; }
	.chat { padding-bottom: 80px; }
	.chat ul { width: 100%; list-style: none; }
	.chat ul li { width: 100%; }
	.chat ul li.left { text-align: left; }
	.chat ul li.right { text-align: right; }
	.chat ul li > div { font-size: 13px; }
	.chat ul li > div.sender { margin: 10px 20px 0 20px; font-weight: bold; }
	.chat ul li > div.message { display: inline-block; word-break:break-all; margin: 5px 20px; max-width: 75%; border: 1px solid #888; padding: 10px; border-radius: 5px; background-color: #FCFCFC; color: #555; text-align: left; }
	.input { position: fixed; bottom: 0; width: 100%; background-color: #FFF; text-align: center; border-top: 1px solid salmon; }
	.input > textarea { width: 100%; height: 60px; border: none; padding: 10px; }
	.form { display: none; }

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/chatbot.js"></script>
</head>
<body>
<%
    String uuid = null;
    try {
        uuid = openChat.opendialog();
    } catch (ParseException e) {
        e.printStackTrace();
    }
    // 대화세션 생성을 위한 고유ID 값을 받아온다.
	session.setAttribute("uuid", uuid);
%>
	 <div class="chat">
        <ul>
        	<li>
        		<div class="sender"><span>챗봇</span></div>
        		<div class="message"><span>안녕하세요. 도움이 필요하신가요? 반려 동물이 먹는 음식과 관련된 질의응답과 연계 병원/가게 예약 시스템을 제공하고 있어요 !</span></div>
	       </li>
        </ul>
    </div>
    <div class="input">
        <textarea placeholder="메세지 입력 후 엔터를 눌러주세요." style="resize: none;"></textarea>
    </div>
 	<br/>
 	<br/>
    <div class="chat form">
        <ul>
            <li>
                <div class="sender">
                    <span></span>
                </div>
                <div class="message">
                    <span></span>
                </div>
            </li>
        </ul>
    </div>
</body>
</html>