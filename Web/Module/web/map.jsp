<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style type="text/css">
      .map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
      .map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
      .map_wrap {position:relative;width:100%;height:500px;}
      #menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
      .bg_white {background:#fff;}
      #menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
      #menu_wrap .option{text-align: center;}
      #menu_wrap .option p {margin:10px 0;}  
      #menu_wrap .option button {margin-left:5px;}
      #placesList li {list-style: none;}
      #placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
      #placesList .item span {display: block;margin-top:4px;}
      #placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
      #placesList .item .info{padding:10px 0 10px 55px;}
      #placesList .info .gray {color:#8a8a8a;}
      #placesList .info .jibun {padding-left:26px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
      #placesList .info .tel {color:#009900;}
      #placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
      #placesList .item .marker_1 {background-position: 0 -10px;}
      #placesList .item .marker_2 {background-position: 0 -56px;}
      #placesList .item .marker_3 {background-position: 0 -102px}
      #placesList .item .marker_4 {background-position: 0 -148px;}
      #placesList .item .marker_5 {background-position: 0 -194px;}
      #placesList .item .marker_6 {background-position: 0 -240px;}
      #placesList .item .marker_7 {background-position: 0 -286px;}
      #placesList .item .marker_8 {background-position: 0 -332px;}
      #placesList .item .marker_9 {background-position: 0 -378px;}
      #placesList .item .marker_10 {background-position: 0 -423px;}
      #placesList .item .marker_11 {background-position: 0 -470px;}
      #placesList .item .marker_12 {background-position: 0 -516px;}
      #placesList .item .marker_13 {background-position: 0 -562px;}
      #placesList .item .marker_14 {background-position: 0 -608px;}
      #placesList .item .marker_15 {background-position: 0 -654px;}
      #pagination {margin:10px auto;text-align: center;}
      #pagination a {display:inline-block;margin-right:10px;}
      #pagination .on {font-weight: bold; cursor: default;color:#777;}
      .detailView{background-color: wheat; color:salmon; padding: 3px 10px; border-radius:3px; border: 2px solid salmon;}
      .bookableMap{text-align:center; background-color:salmon;color:white;border-radius:3px;}
      .bookableBtn{background-color:#fae8ac;color:salmon;border:2px solid white;padding: 3px 20px;border-radius:4px cursor:pointer;font-style:strong;}
      .mapHeader{text-align:center;color:white;background-color:salmon;border-radius:4px;margin: 7px;padding:5px; }
      .map{
       	
	  	width: 600px;
	  	height: 700px;
	  }
	   .dot {overflow:hidden;float:left;width:12px;height:12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/mini_circle.png');}    
	  .dotOverlay {position:relative;bottom:10px;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;float:left;font-size:12px;padding:5px;background:#fff;}
      .dotOverlay:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}    
      .number {font-weight:bold;color:#ee6152;}
      .dotOverlay:after {content:'';position:absolute;margin-left:-6px;left:50%;bottom:-8px;width:11px;height:8px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white_small.png')}
      .distanceInfo {position:relative;top:5px;left:5px;list-style:none;margin:0;}
      .distanceInfo .label {display:inline-block;width:50px;}
      .distanceInfo:after {content:none;}
      .distance{
        text-align:center;
        font-weight:bold;
      	color:salmon;
      	background-color:wheat;
      	border-radius:4px;
      	margin: 8px;
      	padding:5px;
      }
</style>

<body>
	<!-- 지도 화면에 띄우기 -->
  <div class="map">
	<div class="mapHeader"> Insert title </div>
	<div class="map_wrap">
          <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
          <div id="menu_wrap" class="bg_white">
              <div class="option">
                  <div>
                      <form onsubmit="searchPlaces(); return false;">
                          키워드 : <input type="text" value="" id="keyword" size="15"> 
                          <button type="submit">검색</button> 
                      </form>
                  </div>
              </div>
              <hr>
              <ul id="placesList"></ul>
              <div id="pagination"></div>
          </div>
      </div>
      <p class="bookableMap">
      	<input class="bookableBtn" type="button" value="Click" onclick="addressToMarker();"/>
      </p>
   </div>
   <!-- 카카오맵 api키 -->
 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dc7ccb141837d7f5a52ed786b3831578&libraries=services"></script>
  <!-- 1.지도띄우기 기능 -->  
 <script type="text/javascript"  src="resources/js/map_main.js"></script>
 <!-- 2. 장소검색 기능-->
  <script type="text/javascript"  src="resources/js/map_search.js"></script>
  <!-- 3. 거리, 시간구하는 기능 -->
  <script type="text/javascript"  src="resources/js/map_distance.js"></script>


</body>
</html>