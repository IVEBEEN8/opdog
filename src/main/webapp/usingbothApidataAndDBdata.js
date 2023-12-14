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

		//url 을 던져서 response로 값받기.
		 fetch(apiUrl)
	
		     .then(response => {
		         if (!response.ok) {
		             throw new Error('Network response was not ok');
		         }
		         return response.json();
		     })
			 //공공 api 데어터가 "data" 값으로 들어감.
		     .then(data => {
		         console.log("Data received successfully:", data);
					
				 // lat, lng의 파라미터값을 가진 함수 생성!		
		         function createMarker(lat, lng) {
		             var marker = new kakao.maps.Marker({
		                 position: new kakao.maps.LatLng(lat, lng),
		                 clickable: true,
						
	
		             });
		             marker.setMap(map);
		             
		             //마커를 클릭했을때 발생하는 클릭 이벤트 리스너 등록
		             kakao.maps.event.addListener(marker, 'click', function () {
		                 // 마커 클릭 시 해당 위치 정보를 서버로 전송
		                 alert("마커를 클릭했습니다!");

						//ajax함수 클릭시 실행!
		                 $.ajax({
							//sendMarkC 컨트롤러로 이동
		                     url: "SendMarkC",
							// lat의 key에 data의 lat의 값이 들어감!
							// lng의 key에 data의 lng의 값이 들어감!	
		                     data: {
		                         lat : lat , lng : lng
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
				//createMarker함수에 lat lng의 값을 넣어서 마커 표시함.
				//공공데이터의 api를 사용하는것임.
		             createMarker(parseFloat(item.lat), parseFloat(item.lng));
		         }

		         kakao.maps.load();
		         console.log("done!");
		     });