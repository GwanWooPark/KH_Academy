<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!-- directive tag 지시자 = %@ -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- uri 부분을 통해 우리가 어떤 '표준 태그 라이브러리' 를 쓸 것인지 식별 -->
<!-- c는 alias라고 보면 됨. -->
<!-- URI : JSTL 라이브러리에서 지원되는 기능을 태그별로 구분해주는 구분자이다. -->
<!-- c는 보통 코어 일반 프로그래밍 언어에서 제공하는 것과 비슷한 변수 선언 -->
<!-- 실행흐름의 제어 기능을 제공, 다른 JSP로의 이동을 제어하는 기능 제공 -->


<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%></></></></>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>JSTL TEST</h1>
<table border="1">
    <tr>
        <th>이름</th>
        <th>국어</th>
        <th>영어</th>
        <th>수학</th>
        <th>총점</th>
        <th>평균</th>
        <th>등급</th>
    </tr>
    <c:forEach items="${list }" var="score">
        <%-- <%=for%> -> <c:forEach로 변형된 형태 %>--%>
        <%-- items는 반복할 객체 var = 반복할 객체에 사용할 변수이름--%>
        <tr>
            <td>
                <c:if test="${score.name eq '이름10' }">
                    <%-- test내의 el 구문이 참이면 실행된다 else는 존재 x. 또한, 필수 속성으로 속성값으로 EL 비교식(eq)을 가진다.--%>
                    <c:out value="홍길동"></c:out>
                </c:if>
                    <%-- if가 단순 if구문이라면 choose는 if ~ else문이다. --%>
                <c:choose>
                    <c:when test="${score.name eq '이름20' }">
                        <c:out value="${score.name } 님"></c:out>
                    </c:when>
                    <c:when test="${score.name eq '이름30' }">
                        <c:out value="${score.name }"></c:out>
                    </c:when>
                    <c:otherwise>
                        <c:out value="누구"></c:out>
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${score.kor}</td>
            <td>
                <c:if test="${score.eng > 70 }">
                    <c:if test="${score.eng == 90 }">
                        <c:out value="잘하네"></c:out>
                    </c:if>
                </c:if>
            </td>
            <td>${score.math }</td>
            <td>${score.sum }</td>
            <td>${score.avg }</td>
            <td>
                <c:choose>
                    <c:when test="${score.grade eq 'A' || score.grade eq 'B' }">
                        <c:out value="PASS"></c:out>
                    </c:when>
                    <c:otherwise>
                        <c:out value="FAIL"></c:out>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

<hr>

<c:forEach begin="1" end="10" step="2" var="i">
    ${i }<br>
</c:forEach>

    <h3>구구단</h3>
    <table>
        <c:forEach begin="2" end="9" var="i">
            <tr>

            <c:forEach begin="1" end="9" var="j">
                <td>${i } * ${j } = ${i * j }</td>
            </c:forEach>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
