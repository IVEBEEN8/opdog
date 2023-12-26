<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="4_service/js/namingYourDog.js"></script>
<link rel="stylesheet" href="4_service/css/namingYourDog.css">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
	rel="stylesheet" />
</head>
<body>

	<div class="container">
		<h1>Dog name generator</h1>
		<h1>반려견 이름 생성기</h1>
		<!-- 성별 선택 -->
		<div class="wrapper" id="genderOptions">
			<h2>What is your pet's gender?</h2>
			<div class="choice-wrap">
				<button onclick="selectGender('Boy')">
					<img src="4_service/img/naming-boy.png">
					<p class="boy">Boy</p>
				</button>
				<button onclick="selectGender('Girl')">
					<img src="4_service/img/naming-girl.png">
					<p>Girl</p>
				</button>
			</div>
		</div>

		<!-- 털 색상 선택 -->
		<div class="choice-wrap" id="colorOptions" style="display: none">
			<h2>털 색상 선택</h2>
			<button onclick="selectColor('검정')">검정</button>
			<button onclick="selectColor('흰색')">흰색</button>
			<button onclick="selectColor('갈색')">갈색</button>
			<button onclick="selectColor('기타')">기타</button>
		</div>

		<!-- 머리길이 선택 -->
		<div class="choice-wrap" id="hairLengthOptions" style="display: none">
			<h2>머리길이 선택</h2>
			<button onclick="selectHairLength('직모')">직모</button>
			<button onclick="selectHairLength('장모')">장모</button>
			<button onclick="selectHairLength('단모')">단모</button>
			<button onclick="selectHairLength('곱슬')">곱슬</button>
		</div>

		<!-- 성격 선택 -->
		<div class="choice-wrap" id="personalityOptions" style="display: none">
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
		<div class="loadingwords" id="loadingwords">"강아지와 찰떡인 이름을 만들고
			있습니다. 조금만 기다려주세요!"</div>
	</div>
</body>
</html>