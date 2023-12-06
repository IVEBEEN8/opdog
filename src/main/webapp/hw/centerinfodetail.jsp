<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <!-- Kakao Map API 스크립트 포함 -->
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf95e7fad4ebbf7f5b751c535e5369bf&libraries=services,clusterer,drawing"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf95e7fad4ebbf7f5b751c535e5369bf&libraries=services"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf95e7fad4ebbf7f5b751c535e5369bf&libraries=LIBRARY"></script>
    <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=cf95e7fad4ebbf7f5b751c535e5369bf&libraries"></script>
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <style>
        #map {
            width: 100%;
            height: 400px;
        }
    </style>
</head>
<body>

<h1>이거실화야?</h1>

<div id="map" style="width:100%;height:400px;"></div>
<p><em>궁금한 마커를 클릭해주세요!!</em>
<p id="result"></p>

<c:forEach var="c" items="${centers}" varStatus="status">
	<table border ="1">
		<tr>
			<td>No</td>
			<td>${c.no }</td>
		</tr>
		<tr>
			<td>센터명</td>
			<td>${c.careNm }</td>
		</tr>
		<tr>
			<td>센터주소</td>
			<td>${c.careAddr }</td>
		</tr>
		<tr>
			<td>위도</td>
			<td>${c.lat	}</td>
		</tr>
		<tr>
			<td>경도</td>
			<td>${c.lng }</td>
		</tr>
		<tr>
			<td>수의사수</td>
			<td>${c.vetPersonCnt }</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${c.careTel }</td>
		</tr>
	</table>
</c:forEach>

<script>
    function initMap() {
        // Initialize KakaoMap
        var mapContainer = document.getElementById('map');
        var options = {
            center: new kakao.maps.LatLng(37.5665, 126.9780), // Seoul, South Korea
            level: 12
   
        };
        var map = new kakao.maps.Map(mapContainer, options);

        // Retrieve data from the API
        var apiUrl = 'https://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo?serviceKey=sJG8TCmXj96iwKxnSPRAaGazSqjp8g97CNLXDwtsv7BNaDo%2F6qhQtG3OIp0MAEreldhU5TicAqKPPvCVcrj7cA%3D%3D&numOfRows=1000&pageNo=1&_type=json';

        fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                // Process the data and create markers
                var markers = data.response.body.items.item.map(item => {
                    return new kakao.maps.Marker({
                        position: new kakao.maps.LatLng(parseFloat(item.lat), parseFloat(item.lng)),
                        clickable: true
                    });
                });

			
             	// 지도에 클릭 이벤트를 등록합니다
             	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
             	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
    			var latlng = mouseEvent.latLng;

    			// Perform reverse geocoding to get the address
    			var geocoder = new kakao.maps.services.Geocoder();
    			geocoder.coord2Address(latlng.getLng(), latlng.getLat(), function(result, status) {
       			if (status === kakao.maps.services.Status.OK) {
           		 // Address successfully retrieved
           		var address = result[0].address.address_name;

          		 // Display the address
           		var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
           		 message += '경도는 ' + latlng.getLng() + ' 이며, 주소는 ' + address + ' 입니다';

            	var resultDiv = document.getElementById('result');
            	resultDiv.innerHTML = message;
            	
        							}
    					});
				});
                
                
                // Use MarkerClusterer to cluster the markers
                var clusterer = new kakao.maps.MarkerClusterer({
                    map: map,
                    averageCenter: true,
                    minLevel: 10
                
                });

                // Add markers to the clusterer
                clusterer.addMarkers(markers);
                
                
                
                
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });      
    }

    
    // Load the KakaoMap SDK and initialize the map
    kakao.maps.load(initMap);
    
</script>
</body>
</html>