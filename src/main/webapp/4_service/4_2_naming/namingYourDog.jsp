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
		<p>Dog name generator</p>
		<!-- 성별 선택 -->
		<div class="wrapper" id="genderOptions">
			<p>What is your pet's gender?</p>
			<div class="choice-wrap">
				<button onclick="selectGender('Boy')">
					<img style="width: 12vw" src="4_service/img/naming-boy.png">
					<p class="boy">Boy</p>
				</button>
				<button onclick="selectGender('Girl')">
					<img style="width: 12vw" src="4_service/img/naming-girl.png">
					<p>Girl</p>
				</button>
			</div>
		</div>

		<!-- 털 색상 선택 -->
		<div class="wrapper" id="colorOptions" style="display: none">
			<p>What is the fur color?</p>
			<div class="choice-wrap">
				<button onclick="selectColor('black')">
					<img style="width: 12vw" src="4_service/img/naming-black.png">
					<p>black</p>
				</button>
				<button onclick="selectColor('white')">
					<img style="width: 12vw" src="4_service/img/naming-white.png">
					<p>white</p>
				</button>
				<button onclick="selectColor('brown')">
					<img style="width: 12vw" src="4_service/img/naming-brown.png">
					<p>brown</p>
				</button>
				<button onclick="selectColor('etc')">
					<img style="width: 12vw" src="4_service/img/naming-etc.png">
					<p>etc</p>
				</button>
			</div>
		</div>

		<!-- 머리길이 선택 -->
		<div class="wrapper" id="hairLengthOptions" style="display: none">
			<p>What is your dog's hair length?</p>
			<div class="choice-wrap">
				<button onclick="selectHairLength('straight hair')">
					<img style="width: 12vw" src="4_service/img/naming-straight.png">
					<p>straight hair</p>
				</button>
				<button onclick="selectHairLength('long hair')">
					<img style="width: 12vw" src="4_service/img/naming-long.png">
					<p>long hair</p>
				</button>
				<button onclick="selectHairLength('short hair')">
					<img style="width: 12vw" src="4_service/img/naming-short.png">
					<p>short hair</p>
				</button>
				<button onclick="selectHairLength('curly')">
					<img style="width: 12vw" src="4_service/img/naming-curly.png">
					<p>curly</p>
				</button>
			</div>
		</div>

		<!-- 성격 선택 -->
		<div class="wrapper" id="personalityOptions" style="display: none">
			<p>What is your dog's personality?</p>
			<div class="choice-wrap">
				<button onclick="selectPersonality('smart')">
					<img style="width: 15vw; border-radius: 1vw;" src="4_service/img/naming-smart.jpg">
					<p>smart</p>
				</button>
				<button onclick="selectPersonality('fainthearted')">
					<img style="width: 15vw; border-radius: 1vw;" src="4_service/img/naming-p1.jpg">
					<p>fainthearted</p>
				</button>
				<button onclick="selectPersonality('angry')">
					<img style="width: 15vw; border-radius: 1vw;" src="4_service/img/naming-angry.jpg">
					<p>angry</p>
				</button>
				<button onclick="selectPersonality('playful')">
					<img style="width: 15vw; border-radius: 1vw;" src="4_service/img/naming-playful.jpg">
					<p>playful</p>
				</button>
			</div>
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