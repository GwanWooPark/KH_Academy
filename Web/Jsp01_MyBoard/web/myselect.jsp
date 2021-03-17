<%@ page import="com.my.dto.MyBoardDto" %>
<%@ page import="com.my.biz.MyBoardBiz" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/16
  Time: 9:58 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int myno = Integer.parseInt(request.getParameter("myno"));

    MyBoardBiz biz = new MyBoardBiz();
    MyBoardDto dto = biz.selectOne(myno);


%>
    <h1>MY SELECT</h1>

   <table border="1">
       <tr>
           <th>작성자</th>
           <td><%=dto.getMyname()%></td>
           <th>날짜</th>
           <td><%=dto.getMydate()%></td>
       </tr>
       <tr>
           <th>제목</th>
           <td colspan="3"><%=dto.getMytitle()%></td>
       </tr>
       <tr>
           <th>내용</th>
           <td colspan="3"> <textarea rows="10" cols="60" readonly="readonly"><%=dto.getMycontent()%></textarea></td>
       </tr>
       <tr>
           <td colspan="5" align="right">
               <input type="button" value="수정" onclick="location.href='myupdate.jsp?myno=<%=dto.getMyno()%>'">
               <input type="button" value="삭제" onclick="location.href='mydelete.jsp?myno=<%=dto.getMyno()%>'">
               <input type="button" value="목록" onclick="location.href='mylist.jsp'">
           </td>
       </tr>
   </table>

<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

</script>
</body>
</html>