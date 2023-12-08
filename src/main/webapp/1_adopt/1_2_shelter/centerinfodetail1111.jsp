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

</head>
<body>
	<a href="SendMarkC?a=1">testCall</a>
	<div id="map" style="width: 750px; height: 350px;"></div>
	<div style="border: 1px solid balck" id="printinfo">정보출력</div>


	<script>
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
        /* var apiUrl = 'https://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo?serviceKey=sJG8TCmXj96iwKxnSPRAaGazSqjp8g97CNLXDwtsv7BNaDo%2F6qhQtG3OIp0MAEreldhU5TicAqKPPvCVcrj7cA%3D%3D&numOfRows=1000&pageNo=1&_type=json';
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
       			 
       			 
       		 // 여기서 지도 객체를 생성하고, 지도의 중심 좌표 등을 설정합니다.
       	        var mapContainer = document.getElementById('map');
       	        var options = {
       	            center: new kakao.maps.LatLng(37.566826, 126.9786567), // 서울시청을 기본 중심으로 설정
       	            level: 10
       	        };
       	        var map = new kakao.maps.Map(mapContainer, options);

       	        // 데이터에서 좌표를 읽어와 마커를 생성하고 지도에 추가합니다.
       	        data.response.body.items.item.forEach(item => {
       	            var marker = new kakao.maps.Marker({
       	                position: new kakao.maps.LatLng(parseFloat(item.lat), parseFloat(item.lng)),
       	                clickable: true
       	            });

       	            // 마커를 지도에 추가합니다.
       	            marker.setMap(map);
       	        });
       	        
       	    })
       	    .catch(error => {
       	        console.error('There was a problem with the fetch operation:', error);
       	    });	 
		 */
		 
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
		        	 console.log(item);
		             createMarker(parseFloat(item.lat), parseFloat(item.lng));
		         }

		         kakao.maps.load();
		         console.log("done!");
		     });


			
/* 		$(document).ready(
				function() {
					// 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
					kakao.maps.event.addListener(marker, 'click', function() {
						console.log(marker);
						console.log("마커를 클릭했습니다!");
						var value1 = "36.18434";
						var value2 = "127.058";
						$.ajax({

							url : "SendMarkC",
							data : {
								value1, value2								
							},
							success : function(data) {
								$("#printinfo").empty();
								$("#printinfo").append(
								'<div>'+data[0].careNm+'</div>'
								)
								$("#printinfo").append(
								'<div>'+data[0].careAddr+'</div>'
								)
								$("#printinfo").append(
								'<div>'+data[0].tel+'</div>'
								)
								$("#printinfo").append(
								'<div>'+data[0].verNum+'</div>'
								)
							},
							error : function(request, status, error) {
								console.log("code:" + request.status + "\n"
										+ "message:" + request.responseText
										+ "\n" + "error:" + error);
							}
						});

					})

					kakao.maps.load()
				}); */
	</script>

</body>
</html>