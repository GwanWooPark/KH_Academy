<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<title>Title</title>

<script type="text/javascript">

    onload = function () {
        var myId = opener.document.getElementsByName("myId")[0].value;
        document.getElementsByName("myId")[0].value = myId;
    };

    function confirmId(bool) {
        if (bool === "true") {
            opener.document.getElementsByName("myId")[0].title = "y";
            opener.document.getElementsByName("myPass")[0].focus();
        } else {
            opener.document.getElementsByName("myId")[0].focus();
        }
        window.close();
    }
</script>
</head>
<body>
<%
    String idNotUsed = request.getParameter("idNotUsed");
%>

    <table border="1">
        <tr>
            <td><input type="text" name="myId"></td>
        </tr>
        <tr>
            <td><%=idNotUsed.equals("true") ? "아이디 생성 가능" : "중복 아이디"%></td>
        </tr>
        <tr>
            <td>
                <input type="button" value="확인" onclick="confirmId('<%=idNotUsed%>')">
            </td>
        </tr>
    </table>
</body>
</html>
