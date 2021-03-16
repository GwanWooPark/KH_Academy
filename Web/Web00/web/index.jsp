<%@ page import="com.dept.dao.DeptDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dept.dto.DeptDto" %>

<%--
  Created by IntelliJ IDEA.
  User: parkgw
  Date: 2021/03/16
  Time: 4:06 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%
    // scriptlet : java code 영역
    // jsp : Java, Server, Page -> html 안에 scriptlet을 사용해서 java 코드를 작성
    DeptDao dao = new DeptDao();
    List<DeptDto> list = dao.selectList();
  %>

    <h1>DEPT</h1>
    <table border="1">
      <tr>
        <th>deptno</th>
        <th>dname</th>
        <th>loc</th>
      </tr>
      <%
        for (int i = 0; i < list.size(); i++) {

      %>
      <tr>
        <td><%=list.get(i).getDeptNo()%></td> <%-- <%=%> 값을 넣어준다는 의미--%>
        <td><%=list.get(i).getdName()%></td>
        <td><%=list.get(i).getLoc()%></td>
      </tr>
      <%
        }
      %>
    </table>
  </body>
</html>
