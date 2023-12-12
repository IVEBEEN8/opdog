<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>LoginMain</title>
    <link rel="stylesheet" href="0_main/css/header.css" />
    <link rel="stylesheet" href="0_main/css/loginMain.css" />
    <link rel="stylesheet" href="0_main/css/footer.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,200;9..40,300;9..40,400;9..40,500;9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <!-- 헤더 메뉴바 -->
    <header>
      <nav id="main_header" style="background: white">
        <!-- 헤더 왼쪽 로고 -->
        <div class="header_logo">Logo</div>
        <!-- 메뉴 -->
        <div class="nav-var">
          <div class="nav-items">
            <a href="#" class="nav-text home"><span>Home</span></a>
          </div>
          <div class="nav-items">
            <a href="#" class="nav-text"><span>Adopt</span></a>
            <div class="nav-subnav">
              <a href="#">Stary Dogs</a>
              <a href="#">Shelter Info</a>
              <a href="#">Adoption Process</a>
              <a href="#">Adoption Review</a>
            </div>
          </div>
          <div class="nav-items">
            <a href="#" class="nav-text"><span>Shop</span></a>
            <div class="nav-subnav">
              <a href="#">Feed</a>
              <a href="#">Snack</a>
              <a href="#">Fashion</a>
              <a href="#">Toy</a>
            </div>
          </div>
          <div class="nav-items">
            <a href="#" class="nav-text"><span>Volunteer</span></a>
            <div class="nav-subnav">
              <a href="#">Go Together</a>
            </div>
          </div>
          <div class="nav-items">
            <a href="#" class="nav-text"><span>Services</span></a>
            <div class="nav-subnav">
              <a href="#">Check Registration Number</a>
              <a href="#">Naming</a>
            </div>
          </div>
        </div>
        <!-- 회원가입 로그인 버튼 -->
        <div class="header-r">
          <button class="reg-btn">
            <span class="reg-text">SignUp</span>
          </button>
          <button onclick="" class="login-btn">
            <span class="login-text">Login</span>
          </button>
        </div>
      </nav>
    </header>
	<!--  컨텐츠페이지 -->
	<div align="center">
		<div><jsp:include page = "${contentPage }"></jsp:include></div>	
	</div>	 
    <!-- 푸터!!! -->
    <footer>
      <div>
        <div class="footer1">
          <img src="/img/top.png" />
          <a class="top" href="#top">Top</a>
        </div>
        <div class="footer2">
          <div class="askMe">ask me</div>
          <div>
            <input type="text" />
            <a href="#"><img src="/img/send-icon.png" alt="보내기버튼" /></a>
          </div>
        </div>
        <div class="footer3">
          <div class="sns-var">
            <a href="#"><img src="/img/footer-menu-Facebook.svg" /></a>
            <a href="#"><img src="/img/footer-menu-insta.svg" /></a>
            <a href="#"><img src="/img/footer-menu-Linkedin.svg" /></a>
            <a href="#"><img src="/img/footer-menu-Twitter.svg" /></a>
          </div>
          <div class="footer-menu">
            <span>About Us</span>
            <span>Support</span>
            <span>Adoption Process</span>
            <span>Service</span>
            <span>Shelter Map</span>
          </div>
        </div>
      </div>
    </footer>
  </body>
</html>
