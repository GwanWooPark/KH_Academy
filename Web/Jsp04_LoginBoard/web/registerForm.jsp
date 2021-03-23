<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<title>Title</title>
<script type="text/javascript">

    function idCheckConfirm() {
        var chk = document.getElementsByName("myId")[0].title;

        if (chk == "n") {
            alert("아이디 중복 체크를 먼저 해주세요.");
            document.getElementsByName("myId")[0].focus();
        }
    }

    function idCheck() {
        var doc = document.getElementsByName("myId")[0];
        if (doc.value.trim() == "" || doc.value == null) {
            alert("id를 입력해주세요.");
        } else {
            open("loginController.jsp?command=idChk&myId=" + doc.value, "", "width=200, height=200");
        }
    }
</script>
</head>
<body>
    <h1>회원 가입</h1>
    <form action="loginController.jsp?command=regist" method="post">
        <table border="1">
            <tr>
                <th>아이디</th>
                <td><input type="text" name="myId" title="n" required="required"></td>
                <td><input type="button" onclick="idCheck();" value="중복확인"></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="myPass" required="required" onclick="idCheckConfirm();"></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" name="myName" required="required" onclick="idCheckConfirm();"></td>
            </tr>
            <tr>
                <th>주소</th>
                <td><input type="text" name="myAddr" required="required" onclick="idCheckConfirm();"></td>
            </tr>
            <tr>
                <th>번호</th>
                <td><input type="text" name="myPhone" required="required" onclick="idCheckConfirm();"></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="text" name="myEmail" required="required" onclick="idCheckConfirm();"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="회원가입">
                    <input type="button" value="취소" onclick="window.close();">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
