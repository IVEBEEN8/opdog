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

<div id="map" style="width:750px;height:350px;"></div>
<div id="printinfo">정보출력</div>

<script>
    

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(37.56682, 126.97865), // 지도의 중심좌표
	        level: 3, // 지도의 확대 레벨
	        mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
	    }; 
	// 지도를 생성한다 
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	// 지도에 마커를 생성하고 표시한다
	var marker = new kakao.maps.Marker({
	    position: new kakao.maps.LatLng(37.56682, 126.97865), // 마커의 좌표
	    map: map // 마커를 표시할 지도 객체
	});
	// 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
	kakao.maps.event.addListener(marker, 'click', function() {
	    console.log(marker);
	    var marker. = $(this).val();
	    alert("마커를 클릭했습니다!");
	    $.ajax({
	        url: "SendMarkerC",
	        type: "GET",
	        data: { value: 37.41593, value2: 127.2758 },
	        success: function (response) {
	          $("#printinfo").append(
	        	'<div>' + response.careNm + '</div>' 		  
	        	'<div>' + response.careAddr + '</div>' 		  
	        	'<div>' + response.verNum + '</div>' 		  
	        	'<div>' + response.tel + '</div>' 		  
	          )
	          
	          }
	        }); 
	    
	    
	    })
	    
	});
</script>

</body>
</html>