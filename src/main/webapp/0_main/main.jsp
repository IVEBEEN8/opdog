<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>MainPage</title>
<link rel="stylesheet" href="0_main/css/main.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="1_adopt/css/modal.css" />
</head>
<body>
	<!-- 메인 상단 : 헤더 -->
	<header>
		<nav id="main_header" class="main_header">
			<!-- 헤더 왼쪽 로고 -->
			<div class="header_logo">
				<img src="0_main/img/logo-OPEN THE DOG-light.svg" alt="" />
			</div>
			<div class="header_logo2">
				<img style="width:9vw;" src="0_main/img/logoWhite2.5.png" alt="" />
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
						<a onclick="location.href='CheckRegNmC'">Check
							Registration Number</a> <a onclick="location.href='NamingMainC'">Naming</a>
					</div>
				</div>
			</div>
			<!-- 회원가입 로그인 버튼 -->
			<div class="header-r-wrap">
				<div><jsp:include page="${mainLoginLogoutBtn}"></jsp:include></div>
			</div>
			 <a href="#" class="navbar_toogleBtn"
          ><img style="width: 3vw" src="0_main/img/hambuger.svg" alt=""
        /></a>
		</nav>
	</header>
	<!-- 메인 컨텐츠 : 슬라이드로 1,2,3,4까지 넘어감. -->
	<div id="fullpage">
		<div class="quick">
			<ul></ul>
		</div>
		<div class="fullsection full1" pageNum="1">
			<!-- 메인페이지1 동영상 백그라운드 -->
			<div id="video_area">
				<video src="0_main/img/f1video.mp4" id="background_video"
					preload="auto" autoplay="autoplay" loop="loop" muted="muted"></video>
			</div>
			<!-- 텍스트부분 -->
			<div class="full1-txtFrame">
				<div class="full1-bigTxt">
					Adopt Animals <br /> Adopt Family
				</div>
				<div class="full1-smallTxt">
					We aim to promote social change by creating valuable connections
					between <br /> abandoned dogs and adopters, correcting
					misconceptions about abandoned dogs, <br /> and creating a
					responsible pet culture.
				</div>
			</div>
		</div>
		<div class="fullsection full2" pageNum="2">
			<!-- <div class="full2-frame"> -->
			<div class="full2-txtFrame">
				<div class="full2-bigTxt">Please become an adoptive family</div>
				<div class="full2-smallTxt">
					Children rescued from euthanasia or abuse are gathered at the
					protection center. <br /> Please help me get to a warm home as
					soon as possible.
				</div>
				<button class="full2-btn" onclick="location.href='DoginfoHC'">View
					More</button>
			</div>
			<!-- 메인2 슬라이드부분 -->
			<div class="styling-tv">
				<div class="animation-list animation">
					<div class="img-list">
					<p style="display: none;" id="account">${account.no }</p>
						<c:forEach var="dogs" items="${dog }" varStatus="status" end="9">
							<div class="img-box">
								<input type="hidden" value="${dogs.no }">
								<div class="img-wrap">
									<div class="slide-img">
										<img src="${dogs.popfile }" alt="유기견${status.count }" />
									</div>
									<div class="txt-box">
										<div class="img-name">D-${dogs.dday }day</div>
										<div class="img-info">
											${dogs.age }<br /> ${dogs.sexCd },<br /> ${dogs.specialMark }<br />
											${dogs.date }
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="img-list">
						<c:forEach var="dogs" items="${dog }" varStatus="status" end="9">
							<div class="img-box">
								<div class="img-wrap">
									<div class="slide-img">
										<img src="${dogs.popfile }" alt="유기견${status.count }" />
									</div>
									<div class="txt-box">
										<div class="img-name">D-${dogs.dday }day</div>
										<div class="img-info">
											${dogs.age }<br /> ${dogs.sexCd },<br /> ${dogs.specialMark }<br />
											${dogs.date }
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<!-- main 3page start -->
		<div class="fullsection full3" pageNum="3">
			<div class="full3-bigTxt">Current status of abandoned dog</div>
			<div class="count">
				<p style="display: none;" id="count">${count }</p>
				0
			</div>
			<div class="full3-smallTxt">dogs</div>
		</div>
		<div class="fullsection full4" pageNum="4">
			<!-- 메인페이지1 동영상 백그라운드 -->
			<div id="video_area">
				<video src="0_main/img/f4viedo.mp4" id="background_video"
					preload="auto" autoplay="autoplay" loop="loop" muted="muted"
					volume="0"></video>
			</div>
			<!-- 텍스트부분 -->
			<div class="full4-txtFrame">
				<div class="full4-bigTxt">About &nbsp;&nbsp;Us</div>
				<div class="full4-smallTxt">
					<div>
						<a onclick="location.href='ProcessC'">Checklist</a>
					</div>
					<div>
						<a onclick="location.href='ReviewC'">Adopt Review</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="modalWrap" style="z-index: 1000;">
		<div id="modalBody">
			<span id="closeBtn">&times;</span>
		</div>
	</div>
	<div id="pointWrap">
		<div id="givePoint">
			<span id="pointClose">&times;</span>
			<div id="totalPoint"></div>
			<div>얼마를 후원하시겠습니까?</div>
			<div>
				<input type="text" name="point" value="0">point
			</div>
			<button id="doSupport">후원하기</button>
			<input type="hidden" value="">
		</div>
	</div>
</body>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src="0_main/js/main.js"></script>
<script src="0_main/js/main_hambuger.js"></script>
</html>
