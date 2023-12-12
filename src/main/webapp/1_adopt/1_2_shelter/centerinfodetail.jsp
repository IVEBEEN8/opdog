<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf95e7fad4ebbf7f5b751c535e5369bf&libraries=services,clusterer,drawing"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<style type="text/css">
.containar{
display: flex;
}
.test{
background-color: skyblue;
display: flex;
}
.test1{
border-color: black;
}
.title_hw{
width:200px;
}
</style>
</head>
<body>
	<!-- <a href="SendMarkC?a=1">testCall</a> -->
<div class="containar">
	<div class="test1">
		<div id="map" style="width: 750px; height: 350px;"></div>
		<div style="border: 1px solid balck" id="printinfo"></div>
	</div>	
<c:forEach var="c" items="${centers}" varStatus="status">

	<div class="test">
		<div class= "test1">
			<div class="title_hw">센터명</div>
			<div class="#">${c.careNm }</div>
		</div>
		<br>
		<div class= "test1">
			<div class="title_hw">센터주소</div>
			<div class="#">${c.careAddr }</div>
		</div>
		<div class= "test1">
			<div class="title_hw">위도</div>
			<div class="#">${c.lat	}</div>
		</div>
		
		<div class= "test1">
			<div class="title_hw">경도</div>
			<div class="#">${c.lng	}</div>
		</div>
		
		<div class= "test1">
			<div class="title_hw">수의사수</div>
			<div class="#">${c.vetPersonCnt }</div>
		</div>
		
		<div class="test1">
			<div class="title_hw">보호소 영업시작</div>
			<div class="#">${c.oprtime}</div>
		</div>
		
		<div class="test1">
			<div class="title_hw">보호소 영업종료</div>
			<div class="#">${c.closetime }</div>
		</div>
		
		<div class="test1">
			<div class="title_hw">보호소휴무일</div>
			<div class="">${c.closeday }</div>
		</div>
	</div>
	<br>
</c:forEach>
</div>

<script>
var mapContainer = document.getElementById('map');
var mapOption = {
    center: new kakao.maps.LatLng(36.501202261595324, 128.0554606771207),
    level: 17,
    mapTypeId: kakao.maps.MapTypeId.ROADMAP
};

var map = new kakao.maps.Map(mapContainer, mapOption);
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
        $("#printinfo").append('<div> 보호소명			:' + markerData.careNm + '</div>');
        $("#printinfo").append('<div> 보호소 주소 		:' + markerData.careAddr + '</div>');
        $("#printinfo").append('<div> 보호소 전화번호	:' + markerData.careTel + '</div>');
        $("#printinfo").append('<div> 보호소 영업시작	:' + markerData.weekOprStime + '</div>');
        $("#printinfo").append('<div> 보호소 영업종료	:' + markerData.weekOprEtime + '</div>');
        $("#printinfo").append('<div> 보호소 휴무일		:' + markerData.closeDay + '</div>');
        $("#printinfo").append('<div> 보호소 수의사수	:' + markerData.vetPersonCnt + '</div>');
       
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

/* 	
	var mapContainer = document.getElementById('map');
	var mapOption = {
	    center: new kakao.maps.LatLng(37.56682, 126.97865),
	    level: 3,
	    mapTypeId: kakao.maps.MapTypeId.ROADMAP
	};
	
	var map = new kakao.maps.Map(mapContainer, mapOption);

	var marker = new kakao.maps.Marker({
	    position: new kakao.maps.LatLng(37.56682, 126.97865),
	    map: map
	});
	var apiUrl = 'https://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo?serviceKey=sJG8TCmXj96iwKxnSPRAaGazSqjp8g97CNLXDwtsv7BNaDo%2F6qhQtG3OIp0MAEreldhU5TicAqKPPvCVcrj7cA%3D%3D&numOfRows=1000&pageNo=1&_type=json';
	 console.log(apiUrl);
	 
	async function fetchData() {
	    try {
	        const response = await fetch(apiUrl);
	        if (!response.ok) {
	            throw new Error('Network response was not ok');
	        }
	        return await response.json();
	    } catch (error) {
	        console.error('Error fetching data:', error);
	    }
	}

	function createMarker(lat, lng) {
	    var marker = new kakao.maps.Marker({
	        position: new kakao.maps.LatLng(lat, lng),
	        clickable: true
	    });
	    marker.setMap(map);

  kakao.maps.event.addListener(marker, 'click', function () {
	        alert("마커를 클릭했습니다!");
            $.ajax({
                url: "SendMarkC",
                data: {
                    lat: lat
                },
                success: function (data) {
                    $("#printinfo").empty();
                    for (var i = 0; i < data.length; i++) {
                        $("#printinfo").append(
                            '<div>' + data[i].careNm + '</div>');
                        $("#printinfo").append(
                            '<div>' + data[i].careAddr + '</div>');
                        $("#printinfo").append(
                            '<div>' + data[i].tel + '</div>');
                        $("#printinfo").append(
                            '<div>' + data[i].verNum + '</div>');
                    }
                },
                error: function (request, status, error) {
                    console.error('Error sending marker coordinates to server:', error);
                }
	    });
	});
}

	async function initializeMap() {
	    const data = await fetchData();
	    console.log("Data received successfully:", data);

	    const markers = [];
	    for (const item of data.response.body.items.item) {
	        createMarker(parseFloat(item.lat), parseFloat(item.lng));
	    }

	    // 마커 클러스터를 사용하여 마커를 묶음
	    const clusterer = new kakao.maps.MarkerClusterer({
	        map: map,
	        markers: markers,
	        averageCenter: true,
	        minLevel: 10
	    });

	    // 클러스터에 마커들 추가
	    console.log(markers);
	    clusterer.addMarkers(markers);
	    console.log("done!");
	}

	initializeMap(); */
</script>
<!--
		 var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.56682, 126.97865), // 지도의 중심좌표
			level : 3, // 지도의 확대 레벨
			mapTypeId : kakao.maps.MapTypeId.ROADMAP
		// 지도종류
		};
		// 지도를 생성한다 
		var map = new kakao.maps.Map(mapContainer, mapOption);
		// 지도에 마커를 생성하고 표시한다
		var marker = new kakao.maps.Marker({
			position : new kakao.maps.LatLng(37.56682, 126.97865), // 마커의 좌표
			map : map
		// 마커를 표시할 지도 객체

		});
        		 
		 var apiUrl = 'https://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo?serviceKey=sJG8TCmXj96iwKxnSPRAaGazSqjp8g97CNLXDwtsv7BNaDo%2F6qhQtG3OIp0MAEreldhU5TicAqKPPvCVcrj7cA%3D%3D&numOfRows=1000&pageNo=1&_type=json';
		 console.log(apiUrl);

		 fetch(apiUrl)
		     .then(response => {
		         if (!response.ok) {
		             throw new Error('Network response was not ok');
		         }
		         return response.json();
		     })
		     .then(data => {
		         console.log("Data received successfully:", data);

		         function createMarker(lat, lng) {
		             var marker = new kakao.maps.Marker({
		                 position: new kakao.maps.LatLng(lat, lng),
		                 clickable: true
		             });
		             marker.setMap(map);
		             
		             // 클릭 이벤트 리스너 등록
		             kakao.maps.event.addListener(marker, 'click', function () {
		                 // 마커 클릭 시 해당 위치 정보를 서버로 전송
		                 alert("마커를 클릭했습니다!");
		                 $.ajax({
		                     url: "SendMarkC",
		                     data: {
		                         lat, lng
		                     },
		                     success: function (data) {
		                         $("#printinfo").empty();
		                         for (var i = 0; i < data.length; i++) {
		                             $("#printinfo").append(
		                                 '<div>' + data[i].careNm + '</div>');
		                             $("#printinfo").append(
		                                 '<div>' + data[i].careAddr + '</div>');
		                             $("#printinfo").append(
		                                 '<div>' + data[i].tel + '</div>');
		                             $("#printinfo").append(
		                                 '<div>' + data[i].verNum + '</div>');
		                             $("#printinfo").append(
		                                 '<div>' + data[i].oprtime + '</div>');
		                             $("#printinfo").append(
		                                 '<div>' + data[i].closetime + '</div>');
		                             $("#printinfo").append(
		                                 '<div>' + data[i].closeday + '</div>');
		                                 
		                         }
		                     },
		                     error: function (request, status, error) {
		                         console.error('Error sending marker coordinates to server:', error);
		                     }
		                 });
		             });
		         }

		         // 데이터에서 위도와 경도를 읽어와서 마커 생성
		         for (var i = 0; i < data.response.body.items.item.length; i++) {
		             var item = data.response.body.items.item[i];
		             createMarker(parseFloat(item.lat), parseFloat(item.lng));
		         }

		         kakao.maps.load();
		         console.log("done!");
		     }); -->


</body>
</html>