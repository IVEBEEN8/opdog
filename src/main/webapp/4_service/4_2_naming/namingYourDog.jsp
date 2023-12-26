<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="4_service/js/namingYourDog.js"></script>
<link rel="stylesheet" href="4_service/css/namingYourDog.css">
</head>
<body>
<br>dd
<br>dd
<br>dd
<br>dd
<br>dd
<br>dd
<br>dd
<br>dd
<br>dd
<br>dd
<br>dd
<br>dd
<br>dd

   <h1>반려견 이름 생성기</h1>

    <!-- 성별 선택 -->
    <div id="genderOptions">
      <h2>성별선택</h2>
      <button onclick="selectGender('남자')">남자</button>
      <button onclick="selectGender('여자')">여자</button>
    </div>

    <!-- 털 색상 선택 -->
    <div id="colorOptions" style="display: none">
      <h2>털 색상 선택</h2>
      <button onclick="selectColor('검정')">검정</button>
      <button onclick="selectColor('흰색')">흰색</button>
      <button onclick="selectColor('갈색')">갈색</button>
      <button onclick="selectColor('기타')">기타</button>
    </div>

    <!-- 머리길이 선택 -->
    <div id="hairLengthOptions" style="display: none">
      <h2>머리길이 선택</h2>
      <button onclick="selectHairLength('직모')">직모</button>
      <button onclick="selectHairLength('장모')">장모</button>
      <button onclick="selectHairLength('단모')">단모</button>
      <button onclick="selectHairLength('곱슬')">곱슬</button>
    </div>

    <!-- 성격 선택 -->
    <div id="personalityOptions" style="display: none">
      <h2>성격 선택</h2>
      <button onclick="selectPersonality('세심한')">세심한</button>
      <button onclick="selectPersonality('소심한')">소심한</button>
      <button onclick="selectPersonality('화난')">화난</button>
      <button onclick="selectPersonality('장난꾸러기')">장난꾸러기</button>
    </div>
    <div class="chat-content">
    <div class="loading" id="loading">Loading...</div>
      <div class="line">
        <span class="chat-box"></span>

        <div class="line">
          <span class="chat-box mine"></span>
        </div>
      </div>
    </div>
    <button id="send">generate!</button>
    <div class="loadingwords" id="loadingwords">
      "강아지와 찰떡인 이름을 만들고 있습니다. 조금만 기다려주세요!"
    </div>
</body>
</html>