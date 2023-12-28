<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--제이쿼리 연결-->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<!--카카오지도 라이브러리  -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf95e7fad4ebbf7f5b751c535e5369bf&libraries=services,clusterer,drawing"></script>
<!--css 연결  -->
<link rel="stylesheet" type="text/css" href="1_adopt/css/shelter.css">
<!--폰트 적용 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300&display=swap" rel="stylesheet">
<script src="1_adopt/js/searchhw.js"></script>
</head>
<body>
<div class="containar1-2">
	<button class="reload-map1-2"><img class="reloadi" src="1_adopt/img/reloadi.png"><span class="wordReload">Reload</span></button>
	<div class="map" id="map"></div>
	<!--검색창!-->
	<div class="row">
        <form action="SearchC" method="post" name="keywords-serch" id="searchForm">
            <div class="pull-right-wrap1-2">
                    <div class="pull-right1-2">
                        <select class="form-control" name="searchField">
                            <option value="0">&nbsp;&nbsp; Select</option>
                            <option value="c_careNm">&nbsp;&nbsp;ShelterName</option>
                            <option value="c_careAddr">&nbsp;&nbsp;Address</option>
                        </select>
                    </div>
                    <div class="pull-right1-2">
                        <input type="text" id ="inputSearch" class="form-control input-search1-2" placeholder=" Put Keywords" name="searchText" maxlength="100">
                    </div>
                    <div class="pull-right1-2">
                        <button type="button" class="searchButton1-2" id="searchButton"><img class="searchi" src="1_adopt/img/search.png"></button>
                   </div>
            </div>
        </form>
    </div>
    <!-- 인풋박스 시작! -->
	<div class="infobox-wrap1-2">
	 <c:forEach var="c" items="${centers}" varStatus="status">
	 	<button class="showinthemap" value="${c.careNm }!${c.careAddr }!${c.lat}!${c.lng}!${c.oprtime}!${c.closetime }!${c.closeday }!${c.careTel}">
	 	<div class="centerinfo-print-wrap1-2">
	 		<div class="centerinfo-print1-2">
	 			<div class="center-title1-2">${c.careNm }</div>
	 			<div class="center-info-wrap1-2">
	 				<div class="center-icon1-2"><img class="icon1-2" src="1_adopt/img/markicon.png" alt="address" /></div>
	 				<div class="center-info1-2"><div class="center-info-span1-2">${c.careAddr }</div></div>
	 			</div>
	 			<div class="center-info-wrap1-2">
	 				<div class="center-icon1-2"><img class="icon1-2" src="1_adopt/img/clockicon.png" alt="time" /></div>
	 				<div class="center-info1-2">${c.oprtime}~${c.closetime } (${c.closeday })</div>
	 			</div>
	 			<div class="center-info-wrap1-2">
	 				<div class="center-icon1-2"><img class="icon2-1-2" src="1_adopt/img/phoneicon.svg" alt="time" /></div>
	 				<div class="center-info1-2">${c.careTel}</div>
	 			</div>
	 		</div>
	 	</div>
	 	</button>
       </c:forEach>
	</div>
</div>

<!-- 모달! -->
	<div id="printinfo">
  		<div id="modalContent">
   			 <div id="modalBody">
    		</div>
  		</div>
	</div>
	
<!--검색 모달! -->
	<div id="printinfo1">
  		<div id="modalContent1"><span class="mtitle">Searched Info</span><div style="z-index:8;"id="closeBtn1">x</div>
   			 <div id="modalBody1">
    		</div>
  		</div>
	</div>

<script>

var mapContainer = document.getElementById('map'); //지도를 표시할 div id
var mapOption = {
    center: new kakao.maps.LatLng(36.501202261595324, 128.0554606771207), //지도의 중심좌표
    level: 13,
    mapTypeId: kakao.maps.MapTypeId.ROADMAP
};

// 지도생성
var map = new kakao.maps.Map(mapContainer, mapOption);
var mapTypeControl = new kakao.maps.MapTypeControl();
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

//클러스터링을 위한 마커배열생성!
var markers = [];

//공공데이터 api를 가져와서 사용!	
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
        return null;
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
       
        //이전 모달데이터 초기화~	
        $("#modalBody").empty();
        //전화번호 대체처리! 
        const tel = markerData.careTel === "***********" ? "1577-0954" : markerData.careTel;
        //수의사 정보 대체처리!
        const vet = markerData.vetPersonCnt === 0 ? "vet service not available" : markerData.vetPersonCnt + "명";
        //휴업일 대체처리!
        const modifiedCloseDay = markerData.closeDay.replace(/\+/g, ', ').replace(/0/g, 'Open Always');
        // 모댤에에 나올정보!
        
        $("#modalBody").append('<div id="closeBtn">x<div>')
        $("#modalBody").append('<div class="box-info box-center-info">Center Info</div>')
        $("#modalBody").append('<div class="box-info"><img class="bitmap1" src="1_adopt/img/Bitmap.png"></div>')        
        $("#modalBody").append('<div class="box-title modal-carenm">' + markerData.careNm + '</div>');
        $("#modalBody").append('<div class="box-title">' + markerData.careAddr + '</div></div>');
        $("#modalBody").append('<div class="box-title">' + tel + '</div></div>');
        $("#modalBody").append('<div class="box-title"><span class="modal-title-color">Operation</span>	' + markerData.weekOprStime +'~'+ markerData.weekOprEtime + '</div>');
        $("#modalBody").append('<div class="box-title"><span class="modal-title-color">Closed</span>	' + modifiedCloseDay + '</div>');
        
        // 모달 보이기
        $("#printinfo").show();
        $("#closeBtn").on("click", function () {
            $("#printinfo").hide();
        });
    });
    marker.setMap(map);
}

// 닫기 버튼 클릭 이벤트 핸들러
const printinfobox = document.getElementById('printinfo');

// 창 외부 클릭 시 모달 닫기
$(document).on("click", function(event) {
    if (event.target === printinfobox) {
        printinfobox.style.display = 'none';
    }
});

async function initializeMap() {
    const data = await fetchData();
    if (!data) return;

    for (const item of data.response.body.items.item) {
        createMarker(parseFloat(item.lat), parseFloat(item.lng), item);
    }

    // 마커 클러스터를 사용하여 마커를 묶음
    clusterer = new kakao.maps.MarkerClusterer({
        map: map,
        markers: markers,
        averageCenter: true,
        minLevel: 10
    });
}

initializeMap();

var centeraddrId;

function copyText(){
	
	var spanText = document.getElementById(centeraddrId);
	console.log("this is spanText" + spanText);
	window.getSelection().removeAllRanges();
	var range = document.createRange();
 	
	
	range.selectNode(spanText);
 	
    window.getSelection().addRange(range);
    document.execCommand("copy");
    window.getSelection().removeAllRanges();
    alert("You've just copied the address!");
    }


//db파일에 있는 데이터값 들고와서 사용!
var map;
$(document).ready(function() {
    $('.reload-map1-2').on("click", function(){
    	location.reload();
    })
	
	$('.showinthemap').on("click", function(){
		
        var clickedValue = $(this).val();
        var scv = clickedValue.split("!");
        for(let i =0; i<scv.length; i++){
            console.log(scv[i]);
        }
      
      
        if (scv.length === 8 && scv[2] !== "" && scv[3] !== "") {
            // 좌표값이 유효한 경우에만 지도를 생성하고 이동시킵니다.
            var centername = scv[0]; // 보호소이름
            var centeraddr = scv[1]; // 보호소 주소
            var latitude = parseFloat(scv[2]); // 위도
            var longitude = parseFloat(scv[3]); // 경도
            var opentime = scv[4]; // 오픈시간
            var closetime = scv[5]; // 오픈시간
            var closeday = scv[6]; // 휴무일
            var caretel = scv[7]; // 전화번호
			
            
            
            var mapOption = {
                center: new kakao.maps.LatLng(latitude, longitude), //지도의 중심좌표
                level: 5,
                mapTypeId: kakao.maps.MapTypeId.ROADMAP
            };
            // 지도 객체 생성
            
            var map = new kakao.maps.Map(mapContainer, mapOption);
            centeraddrId = "mycopyaddr" + Math.random().toString(36).substr(2, 9);
           	console.log(centeraddrId);
            var content = '<div class="overlaybox1-2">' + 
                '   			 <div class="boxtitle1-2">CENTER INFO</div>' + '<div class="mid-overlaybox1-2">' +
                '    			<ul class="li-wrap1-2">'    + 
                '        				<li class="li1-2">' +
                '          				<span class="title"><img class="bitmap" src="1_adopt/img/Bitmap.png"></span>'  +
                '        				</li>' +
                '        				<li class="li1-2">' +
                '            				<span class="title centername">'+centername+'</span>' +
                '        				</li>' +    
                '        				<li class="li1-2">' +
                '            				<span class="title centeraddr" id="'+centeraddrId+'">'+centeraddr+'</span>' +
                '        				</li>' +    
                '   				    <li class="li1-2">'  +
                '            				<span class="title caretel">'+caretel+'</span>' +
                '			      	    </li>' +
                '			           <li class="li1-2">' +
                '		                     <span class="title"><span>Operation </span>'+opentime+'~'+closetime+'</span>' +
                ' 			           </li>' +
                '			           <li class="li1-2">'  +
                '		                   <span class="title"><span>closed </span><span class="red-col">'+closeday+'</span>' +
                ' 			           </li>' +
                '    			</ul>'+
                '				<div class="copylocationbtn-wrap"><button onclick="copyText()" class="copylocationbtn">Copy location</button></div>'	+
                '</div>' +
                '</div>';
            
           
			
                
            // 커스텀 오버레이가 표시될 위치!	
            var position = new kakao.maps.LatLng(latitude, longitude);  

            // 커스텀 오버레이를 생성!
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
            // 마커 지도에 표시
            marker.setMap(map);
        }
        clickedValue=null;
    });


});
</script>
</body>
</html>