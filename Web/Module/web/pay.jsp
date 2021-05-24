<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    <script type="text/javascript" src="resources/js/pay.js"></script>
  </head>
<body>
  <h1>테스트</h1>
  <input type="button" value="결제" onclick="requestPay()">
  <input type="button" value="취소" onclick="location.href='moduleServlet?merchant_uid='">
</body>
</html>
