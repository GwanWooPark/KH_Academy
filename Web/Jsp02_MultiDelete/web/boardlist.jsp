<%@ page import="java.util.List" %>
<%@ page import="com.muldel.dto.MDBoardDto" %>
<%@ page import="com.muldel.biz.MDBoardBIz" %>
<%@ page import="com.muldel.biz.MDBoardBIzImpl" %>

<%--
     / : root (최상위 디렉토리)
    ./ : 나와 같은 디렉토리
   ../ : 상위 디렉토리
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

    $(function () {

        // .submit : submit 이벤트가 발생될 때, 실행
        $("#muldelform").submit(function () {
            if ($("#muldelform input:checked").length === 0) {
                alert("하나 이상 체크");
                return false;
            }
        });
    });

</script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    MDBoardBIz biz = new MDBoardBIzImpl();
    List<MDBoardDto> list = biz.selectList();
%>
<%@include file="form/header.jsp"%>

    <h1>LIST</h1>

    <form action="muldel.jsp" method="post" id="muldelform">
        <table border="1">
            <col width="30px">
            <col width="50px">
            <col width="100px">
            <col width="500px">
            <col width="100px">
            <tr>
                <th><input type="checkbox" name="all" value=""></th>
                <th>번호</th>
                <th>작성자</th>
                <th><a href="#">제목</a></th>
                <th>작성일</th>
            </tr>
            <%
                for (MDBoardDto dto : list) {
            %>
            <tr>
                <td><input type="checkbox" name="chk" value="<%=dto.getSeq()%>"></td>
                <td align="center"><%=dto.getSeq()%></td>
                <td align="center"><%=dto.getWriter()%></td>
                <td><a href=""><%=dto.getTitle()%></a></td>
                <td align="center"><%=dto.getRegdate()%></td>
            </tr>

            <%
                }
            %>
            <tr>
                <td colspan="5" align="right">
                    <input type="submit" value="선택 삭제">
                    <input type="button" value="글 작성" onclick="location.href='isert.jsp'">
                </td>
            </tr>
        </table>
    </form>
<%@include file="form/footer.jsp"%>
</body>
</html>
