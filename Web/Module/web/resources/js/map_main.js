// 마커를 담을 배열
var markers = [];

// 시작위치
var mapContainer = document.getElementById('map'),
    mapOption = {
    center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 9 // 지도의 확대 레벨
};

// 지도
var map = new kakao.maps.Map(mapContainer, mapOption);