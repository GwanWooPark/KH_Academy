<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<c:catch var="err">   <%-- 자바에서의 try ~ catch 구문 --%>
	<c:set var="weatherURL"
		value="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=${code }" />
	<c:import var="weather" url="${weatherURL }" /> <%-- url에 요청을 --%>
	<x:parse var="wrss" xml="${weather }" />        <%-- wrss라는 변수명으로 구문분석한 weather을 받음--%>
	<%-- xml 문서를 읽어서 파싱(구조화 되어있는 데이터에서 내가 원하는 것을 가지고 옴, 객체화)한다. --%>
{"pubDate":"<x:out select="$wrss/rss/channel/pubDate" />",
"temp":"<x:out
		select="$wrss/rss/channel/item/description/body/data/temp" />",
"reh":"<x:out select="$wrss/rss/channel/item/description/body/data/reh" />",
"pop":"<x:out select="$wrss/rss/channel/item/description/body/data/pop" />",
"x":"<x:out select="$wrss/rss/channel/item/description/header/x" />",
"y":"<x:out select="$wrss/rss/channel/item/description/header/y" />",
"wfKor":"<x:out
		select="$wrss/rss/channel/item/description/body/data/wfKor" />"}
</c:catch>
<c:if test="${err!=null }">
	${err }
</c:if>