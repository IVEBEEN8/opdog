<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
	
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf95e7fad4ebbf7f5b751c535e5369bf&libraries=services,clusterer,drawing"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf95e7fad4ebbf7f5b751c535e5369bf&libraries=services"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf95e7fad4ebbf7f5b751c535e5369bf&libraries=LIBRARY"></script>
<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=cf95e7fad4ebbf7f5b751c535e5369bf&libraries"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="1_adopt/js/shelter.js"></script>
<link rel="stylesheet" type="text/css" href="1_adopt/css/shelter.css">
</head>
<body>
    <!-- 지도를 표시할 컨테이너 -->
    <div id="map"></div>

    <!-- 데이터를 표시할 컨테이너 -->
    <div id="data-container">
        <h2>Database Data</h2>
        <p>여기에 데이터베이스에서 가져온 정보를 표시합니다.</p>
        <ul>
            <li>데이터 1 예시</li>
            <li>데이터 2 예시</li>
            <!-- 필요에 따라 데이터를 동적으로 생성하거나 서버에서 가져와서 삽입합니다. -->
        </ul>
    </div>
</body>
</html>