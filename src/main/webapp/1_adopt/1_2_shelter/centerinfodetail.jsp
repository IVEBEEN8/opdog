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
<style type="text/css">
.containar{

}

.map-info-wrap{
display: flex;
}
.title-wrap{
display: flex;
}

.test{
width:1000px;
}
.title_hw{
text-align:left;
width:200px;
}
.map{
position: fixed ;
}
.printinfo{
left:0;
position: fixed;
top: 81vh;
width: 50vw;
}
.infobox-wrap{

position: relative;
display: block;
width: 60vw;
left: 60vw;
}
.box-title{
display: flex;
}
.small-title{
width: 200px;
text-align:left;

}
.overlaybox {
position:relative;
width:360px;
height:350px;
background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/box_movie.png') no-repeat;
padding:15px 10px;
}

.overlaybox div, ul {overflow:hidden;margin:0;padding:0;}
.overlaybox li {list-style: none;}
.overlaybox .boxtitle {color:#fff;font-size:16px;font-weight:bold;margin-bottom:8px;}
.overlaybox .first {position:relative;width:247px;height:136px;margin-bottom:8px;}
.first .text {color:#fff;font-weight:bold;}
.first .triangle {position:absolute;width:48px;height:48px;top:0;left:0;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/triangle.png') no-repeat; padding:6px;font-size:18px;}
.first .movietitle {position:absolute;width:100%;bottom:0;background:rgba(0,0,0,0.4);padding:7px 15px;font-size:14px;}
.overlaybox ul {width:247px;}
.overlaybox li {position:relative;margin-bottom:2px;background:#2b2d36;padding:5px 10px;color:#aaabaf;line-height: 1;}
.overlaybox li span {display:inline-block;}
.overlaybox li .number {font-size:16px;font-weight:bold;}
.overlaybox li .title {font-size:13px;}
.overlaybox ul .arrow {position:absolute;margin-top:8px;right:25px;width:5px;height:3px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/updown.png') no-repeat;} 
.overlaybox li .up {background-position:0 -40px;}
.overlaybox li .down {background-position:0 -60px;}
.overlaybox li .count {position:absolute;margin-top:5px;right:15px;font-size:10px;}
.overlaybox li:hover {color:#fff;background:#d24545;}
.overlaybox li:hover .up {background-position:0 0px;}
.overlaybox li:hover .down {background-position:0 -20px;}     

</style>
</head>
<body>
	<!-- <a href="SendMarkC?a=1">testCall</a> -->
<div class="containar">
	<div class="map-info-wrap">
		<div class="map" id="map" style="width: 50vw; height: 80vh;"></div>
		<div class= "printinfo" id="printinfo"></div>
	</div>	
<c:forEach var="c" items="${centers}" varStatus="status">
	<div class="infobox-wrap">
		<div class="test">
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
		</div>
	</div>
  </c:forEach>
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