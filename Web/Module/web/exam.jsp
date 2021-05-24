<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="resources/js/paging.js"></script>
<script type="text/javascript">


</script>
<style type="text/css">

	body{
		background-color: #FFF6E3;
	}

	h2{width:200px; margin: 10px auto;}
	#main-background{width: 100%; height: 1219px;}
	#table {display: table; width: 70%; margin: 20px auto;}
	.row {display: table-row;}
	.main{background-color: salmon; color:white; text-align: center;}
	.cell {display: table-cell; padding: 3px; border: 0.5px solid #DDD; text-align: center;}
	.col1 {width: 1%;}
	.col2 {width: 1%;}
	.paginate{width: 200px; margin : 0px auto;}
	
</style>
</head>
<body>
				
				
		<div id="table">
			<div class="row main">
				<span class="cell col1">글번호</span>
				<span class="cell col2">작성자</span>
				<span class="cell col3">내용</span>
				
			</div>
		
			<c:forEach items="${list }" var="dto">
				<div class="row">
					<span class="cell col1">${dto.myno }</span>
					<span class="cell col2">${dto.myname }</span>
					<span class="cell col2">${dto.mytitle }</span>
				</div>
			</c:forEach>
		</div>
		
		<jsp:include page="paging.jsp" flush="true">
			<jsp:param name="servletPath" value="${servletPath }"/>
			<jsp:param name="recordsPerPage" value="${paging.recordsPerPage }"/>
			<jsp:param name="firstPageNo" value="${paging.firstPageNo }"/>
			<jsp:param name="prevPageNo" value="${paging.prevPageNo }"/>
			<jsp:param name="startPageNo" value="${paging.startPageNo }"/>
			<jsp:param name="currentPageNo" value="${paging.currentPageNo }"/>
			<jsp:param name="endPageNo" value="${paging.endPageNo }"/>
			<jsp:param name="nextPageNo" value="${paging.nextPageNo }"/>
			<jsp:param name="finalPageNo" value="${paging.finalPageNo }"/>
		</jsp:include>


</body>
</html>