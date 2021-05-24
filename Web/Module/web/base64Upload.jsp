<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charser=UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/stylesheet.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/summernote-lite.css">

<style type="text/css">
#community_insert_contentbox{
	position : relative;
	align-self : center;
	border : 2px solid salmon;
	height: 800px;
	width: 800px;
	margin: 30px auto 20px;
}

#community_insert_title{
	text-align: center;	
    font-weight: 600;
    font-size: 15pt;
    width: 780px;
    margin: 10px;
    height: 50px;
    border : 1px solid #bbb;
    
}

#community_insert_input_box{
    margin: 0 auto;
    width: 800px;
    border : 1px solid black;
}


.insert_button{
	float:right;
    border: 2px solid salmon;
    background-color: white;
    color: salmon;
    padding: 5px;
    margin-top: 2px;
    border-radius: 4px;
    margin-left: 10px;
}

.insert_button:hover{
    background-color: salmon;
    color: white;
}


</style>
</head>


<!-- include libraries(jQuery, bootstrap) 써머노트는 부트스트랩 기반 버전과 아닌 버전을 선택해서 사용 가능, 프로젝트에서 사용한 것은 부트스트랩 사용 버전 -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js  써머노트-lite 라고 되어 있는게 부트스트랩 없는 버전-->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	//여기 아래 부분
	$('#summernote').summernote({ //서머노트 실행 구문
		  height: 780,                 // 에디터 높이
		  minHeight: 610,             // 최소 높이
		  maxHeight: 610,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '내용을 입력해 주세요'	//placeholder 설정
		  //이 외의 툴바 관련 설정은 홈페이지 참고 : https://summernote.org/deep-dive/
	});
});

</script>

<body>
	<form action="servlet" method="post" >
	<input type="hidden" name="command" value="insert">
		<div id="community_insert_fullbox">
			<div id ="community_insert_contentbox">
				<div id="community_insert_title">
					<input required="required" style="width:780px;height:50px"type="text" name="title"/>
				</div>	
				<div id="community_insert_content">
					<textarea required="required" id="summernote" name="content"></textarea>
				</div>
				<div id="community_insert_button">
					<input class="insert_button" type="button" value="돌아가기">
					<input class="insert_button" type="submit" value="작성">
				</div>
			</div>
		</div>
	
	</form>

</body>
</html>