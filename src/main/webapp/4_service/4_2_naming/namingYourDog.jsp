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
				<button onclick="selectColor('Black')">
					<img style="width: 12vw" src="4_service/img/naming-black.png">
					<p>Black</p>
				</button>
				<button onclick="selectColor('White')">
					<img style="width: 12vw" src="4_service/img/naming-white.png">
					<p>White</p>
				</button>
				<button onclick="selectColor('Brown')">
					<img style="width: 12vw" src="4_service/img/naming-brown.png">
					<p>Brown</p>
				</button>
				<button onclick="selectColor('Etc')">
					<img style="width: 12vw" src="4_service/img/naming-etc.png">
					<p>Etc</p>
				</button>
			</div>
		</div>

		<!-- 머리길이 선택 -->
		<div class="wrapper" id="hairLengthOptions" style="display: none">
			<p>What is your dog's hair style?</p>
			<div class="choice-wrap">
				<button onclick="selectHairLength('Straight hair')">
					<img style="width: 12vw" src="4_service/img/naming-straight.png">
					<p>Straight hair</p>
				</button>
				<button onclick="selectHairLength('Long hair')">
					<img style="width: 12vw" src="4_service/img/naming-long.png">
					<p>Long hair</p>
				</button>
				<button onclick="selectHairLength('Short hair')">
					<img style="width: 12vw" src="4_service/img/naming-short.png">
					<p>Short hair</p>
				</button>
				<button onclick="selectHairLength('Curly hair')">
					<img style="width: 12vw" src="4_service/img/naming-curly.png">
					<p>Curly hair</p>
				</button>
			</div>
		</div>

		<!-- 성격 선택 -->
		<div class="wrapper" id="personalityOptions" style="display: none">
			<p>What is your dog's personality?</p>
			<div class="choice-wrap">
				<button onclick="selectPersonality('Smart')">
					<img style="width: 15vw; border-radius: 1vw;" src="4_service/img/naming-smart.jpg">
					<p>Smart</p>
				</button>
				<button onclick="selectPersonality('Fainthearted')">
					<img style="width: 15vw; border-radius: 1vw;" src="4_service/img/naming-p1.jpg">
					<p>Fainthearted</p>
				</button>
				<button onclick="selectPersonality('Angry')">
					<img style="width: 15vw; border-radius: 1vw;" src="4_service/img/naming-angry.jpg">
					<p>Angry</p>
				</button>
				<button onclick="selectPersonality('Playful')">
					<img style="width: 15vw; border-radius: 1vw;" src="4_service/img/naming-playful.jpg">
					<p>Playful</p>
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
		<button id="send" style="display:none;">generate!</button>
		<div class="loadingwords" id="loadingwords">"We are generating the name matched perfectly well with your lovely dog!"</div>
	</div>
</body>
</html>