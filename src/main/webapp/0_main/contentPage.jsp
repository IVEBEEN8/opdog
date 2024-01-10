<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>LoginMain</title>
<link rel="stylesheet" href="0_main/css/header.css" />
<link rel="stylesheet" href="0_main/css/loginMain.css" />
<link rel="stylesheet" href="0_main/css/footer.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,200;9..40,300;9..40,400;9..40,500;9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
	rel="stylesheet" />
</head>
<body>
	<!-- 메인 상단 : 헤더 -->
	<header>
		<nav id="all_header">
			<!-- 헤더 왼쪽 로고 -->
			<div class="header_logo">
				<img src="0_main/img/logo-OPEN THE DOG-dark.svg" alt=""
					onclick="location.href='HC'" />
			</div>
			<!-- 메뉴 -->
			<div class="nav-var">
				<div class="nav-items">
					<a href="HC" class="nav-text home"><span>HOME</span></a>
				</div>
				<div class="nav-items">
					<a onclick="location.href='DoginfoHC'" class="nav-text"><span>Adopt</span></a>
					<div class="nav-subnav">
						<a onclick="location.href='DoginfoHC'">Stary Dogs</a> <a
							onclick="location.href='CenterMainC'">Shelter Info</a> <a
							onclick="location.href='ProcessC'">Checklist</a> <a
							onclick="location.href='ReviewC'">Adoption Review</a>
					</div>
				</div>
				<div class="nav-items">
					<a onclick="location.href='FashionC'" class="nav-text"><span>Shop</span></a>
					<div class="nav-subnav">
						<a onclick="location.href='FashionC'">Fashion</a> <a
							onclick="location.href='FeedC'">Feed</a> <a
							onclick="location.href='SnackC'">Snack</a> <a
							onclick="location.href='ToyC'">Toy</a>
					</div>
				</div>
				<div class="nav-items">
					<a onclick="location.href='VolunteerMainC'" class="nav-text"><span>Volunteer</span></a>
					<div class="nav-subnav">
						<a onclick="location.href='VolunteerMainC'">Go Together</a>
					</div>
				</div>
				<div class="nav-items">
					<a onclick="location.href='CheckRegNmC'" class="nav-text"><span>Services</span></a>
					<div class="nav-subnav">
						<a onclick="location.href='CheckRegNmC'">Check Registration
							Number</a> <a onclick="location.href='NamingMainC'">Naming</a>
					</div>
				</div>
			</div>
			<!-- 회원가입 로그인 버튼 -->
			<div>
				<div><jsp:include page="${loginLogoutBtn}"></jsp:include></div>
			</div>
		</nav>
	</header>

	<!--  컨텐츠페이지 -->
	<div align="center" class="contentBox">
		<div><jsp:include page="${contentPage }"></jsp:include></div>
	</div>

	<!-- 푸터!!! -->
	<footer>
		<div>
			<div class="footer1">
				<img src="0_main/img/top.png" /> <a class="top" href="#top">Top</a>
			</div>
			<div class="footer2">
				<div class="ask-input">
					<form action="AskAboutDogMainC" method="post">
						<input class="askanything" name="askanything" id="input"
							type="text" placeholder="Ask anything"  onfocus="this.placeholder = ''" />
						<button class="send-btn">
							<img src="0_main/img/send-icon.png" alt="보내기버튼" />
						</button>
					</form>
				</div>
			</div>
			<div class="footer3">
				<div class="sns-var">
					<a href="#"><img src="0_main/img/footer-menu-Facebook.svg" /></a>
					<a href="#"><img src="0_main/img/footer-menu-insta.svg" /></a> <a
						href="#"><img src="0_main/img/footer-menu-Linkedin.svg" /></a> <a
						href="#"><img src="0_main/img/footer-menu-Twitter.svg" /></a>
				</div>
				<div class="footer-menu">
					<span onclick="location.href='HC'">About Us</span> <span
						onclick="location.href='DoginfoHC'">Support</span> <span
						onclick="location.href='ProcessC'">Checklist</span> <span
						onclick="location.href='CheckRegNmC'">Service</span> <span
						onclick="location.href='CenterMainC'">Shelter Map</span>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>
