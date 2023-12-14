<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf95e7fad4ebbf7f5b751c535e5369bf&libraries=services,clusterer,drawing"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link rel="stylesheet" type="text/css" href="1_adopt/css/shelter.css">
</head>
<body>
	<!-- <a href="SendMarkC?a=1">testCall</a> -->
<div class="containar1-2">
	<div class="map" id="map"></div>
		
	<div class="infobox-wrap1-2">
	 <c:forEach var="c" items="${centers}" varStatus="status">
	 
	 	<div class="centerinfo-print-wrap1-2">
	 		<div class="centerimg1-2" >이미지들어갈꺼구열</div>
	 		<div class="centerinfo-print1-2">보호소정보
	 			<div class="center-title1-2">보호소이름</div>
	 			<div class="center-addr-wrap1-2">
	 				<div class="center-addr-icon1-2"></div>
	 				<div class="center-addr1-2">보호소주소</div>
	 			</div>
	 			<div class="center-oprtime-wrap1-2">
	 				<div class="center-oprtime-icon1-2"></div>
	 				<div class="center-oprtime1-2">오픈/클로즈/휴무일</div>
	 			</div>
	 		</div>
	 	</div>
<%-- 		<div class="test">
			<div class= "title-wrap">
				<div class="title_hw">센터명</div>
				<div class="#">${c.careNm }</div>
			</div>
		</div>
		<div class="test">
			<div class= "title-wrap">
				<div class="title_hw">센터주소</div>
				<div class="#">${c.careAddr }</div>
			</div>
		</div>
	
		<div class="test">
			<div class= "title-wrap">
				<div class="title_hw">수의사수</div>
				<div class="#">${c.vetPersonCnt }</div>
			</div>
		</div>
		<div class="test">
			<div class="title-wrap">
				<div class="title_hw">보호소 영업시작</div>
				<div class="#">${c.oprtime}</div>
			</div>
		</div>
		<div class="test">
			<div class="title-wrap">
				<div class="title_hw">보호소 영업종료</div>
				<div class="#">${c.closetime }</div>
			</div>
		</div>
		<div class="test">
			<div class="title-wrap">
				<div class="title_hw">보호소휴무일</div>
				<div class="">${c.closeday }</div>
			</div>
		</div>
		<div class="test">
			<button name="showinthemap" class="showinthemap" value="${c.careNm }!${c.careAddr }!${c.lat}!${c.lng}!${c.oprtime}!${c.closetime }!${c.closeday }">ShowInTheMap</button>
		</div> --%>
       </c:forEach>
	</div>
</div>

<script>
var mapContainer = document.getElementById('map'); //지도를 표시할 div id
var mapOption = {
    center: new kakao.maps.LatLng(36.501202261595324, 128.0554606771207), //지도의 중심좌표
    level: 17,
    mapTypeId: kakao.maps.MapTypeId.SKYVIEW
};
// 지도생성
var map = new kakao.maps.Map(mapContainer, mapOption);
var mapTypeControl = new kakao.maps.MapTypeControl();
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
//클러스터링을 위한 마커배열생성!
var markers = [];

async function fetchData() {
    var apiUrl = 'https://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo?serviceKey=sJG8TCmXj96iwKxnSPRAaGazSqjp8g97CNLXDwtsv7BNaDo%2F6qhQtG3OIp0MAEreldhU5TicAqKPPvCVcrj7cA%3D%3D&numOfRows=1000&pageNo=1&_type=json';
    try {
        const response = await fetch(apiUrl);
        if (!response.ok) {
            throw new Error('네트워크 응답이 올바르지 않습니다.');
        }
        return await response.json();
    } catch (error) {
        console.error('데이터를 가져오는 중 오류 발생:', error);
    }
}

function createMarker(lat, lng, data) {
    var marker = new kakao.maps.Marker({
        position: new kakao.maps.LatLng(lat, lng),
        clickable: true
    });

    marker.data = data;  // 데이터를 마커에 연결
    markers.push(marker);
    
    kakao.maps.event.addListener(marker, 'click', function () {
        var markerData = marker.data;
        $("#printinfo").empty();
        $("#printinfo").append('<div class="box-title"><div class="small-title"> 보호소명			</div><div>:' + markerData.careNm + '</div></div>');
        $("#printinfo").append('<div class="box-title"><div class="small-title"> 보호소 주소 		</div><div>:' + markerData.careAddr + '</div></div>');
        $("#printinfo").append('<div class="box-title"><div class="small-title"> 보호소 전화번호	</div><div>:' + markerData.careTel + '</div></div>');
        $("#printinfo").append('<div class="box-title"><div class="small-title"> 보호소 영업시작	</div><div>:' + markerData.weekOprStime + '</div></div>');
        $("#printinfo").append('<div class="box-title"><div class="small-title"> 보호소 영업종료	</div><div>:' + markerData.weekOprEtime + '</div></div>');
        $("#printinfo").append('<div class="box-title"><div class="small-title"> 보호소 휴무일		</div><div>;' + markerData.closeDay + '</div></div>');
        $("#printinfo").append('<div class="box-title"><div class="small-title"> 보호소 수의사수	</div><div>;' + markerData.vetPersonCnt + '</div></div>');
    });

    marker.setMap(map);
}

async function initializeMap() {
    const data = await fetchData();
    console.log("데이터를 성공적으로 받았습니다:", data);
	
    for (const item of data.response.body.items.item) {
        createMarker(parseFloat(item.lat), parseFloat(item.lng), item);
    }
    // 마커 클러스터를 사용하여 마커를 묶음
    const clusterer = new kakao.maps.MarkerClusterer({
        map: map,
        markers: markers,
        averageCenter: true,
        minLevel: 12
    });

    console.log("완료!");
}



initializeMap();

$(document).ready(function() {
	$('.showinthemap').on("click", function(){
			alert("마커를 클릭했습니다!")
			var clickedValue = $(this).val();
			var scv = clickedValue.split("!");
			for(i =0; i<scv.length; i++){
				console.log(scv[i]);
			}
			
			
		 	if (scv.length === 7 && scv[2] !== "" && scv[3] !== "") {
	            // 좌표값이 유효한 경우에만 지도를 생성하고 이동시킵니다.
	            
			 var centername = scv[0]; // 보호소이름
			 var centeraddr = scv[1]; // 보호소 주소
			 var latitude = parseFloat(scv[2]); // 위도
			 var longitude = parseFloat(scv[3]); // 경도
			 var opentime = scv[4]; // 오픈시간
			 var closetime = scv[5]; // 오픈시간
			 var vetnum = parseInt(scv[6]);
	           
	            
	            
	            var mapContainer = document.getElementById('map'); //지도를 표시할 div id
	            var mapOption = {
	                center: new kakao.maps.LatLng(latitude, longitude), //지도의 중심좌표
	                level: 5,
	                mapTypeId: kakao.maps.MapTypeId.ROADMAP
	            };
	            // 지도 객체 생성
	            var map = new kakao.maps.Map(mapContainer, mapOption);
	            var content = '<div class="overlaybox">' +
	            '    <div class="boxtitle">보호소정보</div>' +
	            '    <div class="first">' +
	            '        <div class="triangle text"></div>' +
	            '        <div class="movietitle text"></div>' +
	            '    </div>' +
	            '    <ul>' +
	            '        <li class="up">' +
	            '            <span class="number">2</span>' +
	            '            <span class="title">'+centername+'</span>' +
	            '            <span class="arrow up"></span>' +
	            '            <span class="count">2</span>' +
	            '        </li>' +
	            '        <li>' +
	            '            <span class="number">3</span>' +
	            '            <span class="title">'+centeraddr+'</span>' +
	            '            <span class="arrow up"></span>' +
	            '            <span class="count">6</span>' +
	            '        </li>' +
	            '        <li>' +
	            '            <span class="number">4</span>' +
	            '            <span class="title">'+opentime+'</span>' +
	            '            <span class="arrow up"></span>' +
	            '            <span class="count">3</span>' +
	            '        </li>' +
	            '        <li>' +
	            '            <span class="number">5</span>' +
	            '            <span class="title">'+closetime+'</span>' +
	            '            <span class="arrow down"></span>' +
	            '            <span class="count">1</span>' +
	            '        </li>' +
	            '        </li>' +
	            '        <li>' +
	            '            <span class="number">6</span>' +
	            '            <span class="title">여긴보호소 전화번호 넣기</span>' +
	            '            <span class="arrow down"></span>' +
	            '            <span class="count">1</span>' +
	            '        </li>' +
	            '    </ul>' +
	            '</div>';

	        // 커스텀 오버레이가 표시될 위치입니다 
		        var position = new kakao.maps.LatLng(latitude, longitude);  
	
		        // 커스텀 오버레이를 생성합니다
		        var customOverlay = new kakao.maps.CustomOverlay({
		            position: position,
		            content: content,
		            xAnchor: 0.3,
		            yAnchor: 0.91
		        });
		        customOverlay.setMap(map);
	            var mapTypeControl = new kakao.maps.MapTypeControl();
	            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
	            var zoomControl = new kakao.maps.ZoomControl();
	            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
		            
	            
	            // 마커 생성
	            var markerPosition = new kakao.maps.LatLng(latitude, longitude);
	            var marker = new kakao.maps.Marker({
	                position: markerPosition
	            });
	            //var map = new kakao.maps.Map(mapContainer, mapOption);
	            
	            // 마커 지도에 표시
	            marker.setMap(map);
	      
	         
		 }
		 clickedValue=null;
		
		
    });
});

</script>
</body>
</html>