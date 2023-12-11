<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf95e7fad4ebbf7f5b751c535e5369bf&libraries=services,clusterer,drawing"></script>
   
</head>
<body>

<h1>확실해?????</h1>
<div id="map" style="width:100%;height:400px;"></div>
<p id="result"></p>

<c:forEach var="c" items="${centers}" varStatus="status">
	<div class="#">
		<div class= "#">
			<div class="#">no.</div>
			<div class="#">${c.no }</div>
		</div>
		<div class= "#">
			<div class="#">센터명</div>
			<div class="#">${c.careNm }</div>
		</div>
		<div class= "#">
			<div class="#">센터주소</div>
			<div class="#">${c.careAddr }</div>
		</div>
		<div class= "#">
			<div class="#">위도</div>
			<div class="#">${c.lat	}</div>
		</div>
		<div class= "#">
			<div class="#">경도</div>
			<div class="#">${c.lng	}</div>
		</div>
		<div class= "#">
			<div class="#">수의사수</div>
			<div class="#">${c.vetPersonCnt }</div>
		</div>
		<div>
			<div class="#">전화번호</div>
			<div class="#">${c.careTel }</div>
		</div>
	</div>
</c:forEach>

<script>
    function initMap() {
        // 카카오 초기화작업.
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

    			// 주소값을 받기위한 플렛폼!
    			var geocoder = new kakao.maps.services.Geocoder();
    			geocoder.coord2Address(latlng.getLng(), latlng.getLat(), function(result, status) {
        		
    					
    			//주소가 성공적으롤 검색되었다는뜻!
       			if (status === kakao.maps.services.Status.OK) {
		           		var address = result[0].address.address_name;

          		 // Display the address
           		var message = '위도 : ' + latlng.getLat();
           		 message += ' 경도 : ' + latlng.getLng() + ' 주소 : ' + address + '여기는 아무 값이나 가능한가여 ? ? ? ? ? '

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
    // 카카오맵 로드.
   	kakao.maps.load(initMap);

    
</script>
</body>
</html>