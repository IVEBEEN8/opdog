<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
<link rel="stylesheet" href="0_main/css/main.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
      rel="stylesheet"
    />
</head>
<body>
<!-- 메인 상단 : 헤더 -->
    <header>
      <nav id="main_header" class="main_header">
        <!-- 헤더 왼쪽 로고 -->
        	<div class="header_logo">
            	<img src="0_main/img/logo-OPEN THE DOG-light.svg" alt="" />
         	</div>
        <!-- 메뉴 -->
        <div class="nav-var">
          <div class="nav-items">
            <a href="#" class="nav-text home"><span>Home</span></a>
          </div>
          <div class="nav-items">
            <a href="#" class="nav-text"><span>Adopt</span></a>
            <div class="nav-subnav">
              <a onclick="location.href='DoginfoHC'">Stary Dogs</a>
              <a onclick="location.href='CenterMainC'">Shelter Info</a>
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
              <a onclick="location.href='VolunteerMainC'">Go Together</a>
            </div>
          </div>
          <div class="nav-items">
            <a href="#" class="nav-text"><span>Services</span></a>
            <div class="nav-subnav">
              <a onclick="location.href='CheckRegNmC'">Check Registration Number</a>
              <a onclick="location.href='NamingMainC'">Naming</a>
            </div>
          </div>
        </div>
          <!-- 회원가입 로그인 버튼 -->
          <div>
		<div><jsp:include page = "${mainLoginLogoutBtn}"></jsp:include></div>	
		</div>	
      </nav>
    </header>
    <!-- 메인 컨텐츠 : 슬라이드로 1,2,3,4까지 넘어감. -->
    <div id="fullpage">
      <div class="quick"><ul></ul></div>
      <div class="fullsection full1" pageNum="1">
        <!-- 메인페이지1 동영상 백그라운드 -->
        <div id="video_area">
          <video
            src="0_main/img/f1video.mp4"
            id="background_video"
            preload="auto"
            autoplay="autoplay"
            loop="loop"
            muted="muted"
          ></video>
        </div>
        <!-- 텍스트부분 -->
        <div class="full1-txtFrame">
          <div class="full1-bigTxt">
            Adopt Animals <br />
            Adopt Family
          </div>
          <div class="full1-smallTxt">
            We aim to promote social change by creating valuable connections
            between <br />
            abandoned dogs and adopters, correcting misconceptions about
            abandoned dogs, <br />
            and creating a responsible pet culture.
          </div>
        </div>
      </div>
      <div class="fullsection full2" pageNum="2">
        <!-- <div class="full2-frame"> -->
        <div class="full2-txtFrame">
          <div class="full2-bigTxt">Please become an adoptive family</div>
          <div class="full2-smallTxt">
            Children rescued from euthanasia or abuse are gathered at the
            protection center. <br />
            Please help me get to a warm home as soon as possible.
          </div>
          <button class="full2-btn">View More</button>
        </div>
        <!-- 메인2 슬라이드부분 -->
        <div class="styling-tv">
          <div class="animation-list animation">
            <div class="img-list">
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/beny.jpeg" alt="유기견1" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Beny</div>
                    <div class="img-info">
                      I'm Beny, 3 years old! <br />
                      I am male and weigh 9 kg. <br />
                      I am innocent and like everyone.
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/tera.jpeg" alt="유기견2" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Tera</div>
                    <div class="img-info">
                      I'm Tera, 1 years old! <br />
                      I am female and weight 3 kg. <br />
                      I have a curious and bright personality.
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/luna2.jpeg" alt="유기견3" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Runa</div>
                    <div class="img-info">
                      I'm Runa, 1 years old! <br />
                      I am female and weight 7 kg. <br />
                      I like playing around with people more than eating.
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/stella.jpeg" alt="유기견4" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Stella</div>
                    <div class="img-info">
                      I'm Stella, 1 years old! <br />
                      I am female and weight 3.2 kg. <br />
                      Shy and cautious, but full of affection
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/bao.jpeg" alt="유기견5" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Bao</div>
                    <div class="img-info">
                      I'm Bao, 1 years old! <br />
                      I am female and weight 4.11 kg. <br />
                      I'm wearing brown socks
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/beny.jpeg" alt="유기견1" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Beny</div>
                    <div class="img-info">
                      I'm Beny, 3 years old! <br />
                      I am male and weigh 9 kg. <br />
                      I am innocent and like everyone.
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/tera.jpeg" alt="유기견2" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Tera</div>
                    <div class="img-info">
                      I'm Tera, 1 years old! <br />
                      I am female and weight 3 kg. <br />
                      I have a curious and bright personality.
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/luna2.jpeg" alt="유기견3" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Runa</div>
                    <div class="img-info">
                      I'm Runa, 1 years old! <br />
                      I am female and weight 7 kg. <br />
                      I like playing around with people more than eating.
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/stella.jpeg" alt="유기견4" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Stella</div>
                    <div class="img-info">
                      I'm Stella, 1 years old! <br />
                      I am female and weight 3.2 kg. <br />
                      Shy and cautious, but full of affection
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/bao.jpeg" alt="유기견5" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Bao</div>
                    <div class="img-info">
                      I'm Bao, 1 years old! <br />
                      I am female and weight 4.11 kg. <br />
                      I'm wearing brown socks
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="img-list">
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/beny.jpeg" alt="유기견1" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Beny</div>
                    <div class="img-info">
                      I'm Beny, 3 years old! <br />
                      I am male and weigh 9 kg. <br />
                      I am innocent and like everyone.
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/tera.jpeg" alt="유기견2" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Tera</div>
                    <div class="img-info">
                      I'm Tera, 1 years old! <br />
                      I am female and weight 3 kg. <br />
                      I have a curious and bright personality.
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/luna2.jpeg" alt="유기견3" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Runa</div>
                    <div class="img-info">
                      I'm Runa, 1 years old! <br />
                      I am female and weight 7 kg. <br />
                      I like playing around with people more than eating.
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/stella.jpeg" alt="유기견4" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Stella</div>
                    <div class="img-info">
                      I'm Stella, 1 years old! <br />
                      I am female and weight 3.2 kg. <br />
                      Shy and cautious, but full of affection
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/bao.jpeg" alt="유기견5" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Bao</div>
                    <div class="img-info">
                      I'm Bao, 1 years old! <br />
                      I am female and weight 4.11 kg. <br />
                      I'm wearing brown socks
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/beny.jpeg" alt="유기견1" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Beny</div>
                    <div class="img-info">
                      I'm Beny, 3 years old! <br />
                      I am male and weigh 9 kg. <br />
                      I am innocent and like everyone.
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/tera.jpeg" alt="유기견2" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Tera</div>
                    <div class="img-info">
                      I'm Tera, 1 years old! <br />
                      I am female and weight 3 kg. <br />
                      I have a curious and bright personality.
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/luna2.jpeg" alt="유기견3" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Runa</div>
                    <div class="img-info">
                      I'm Runa, 1 years old! <br />
                      I am female and weight 7 kg. <br />
                      I like playing around with people more than eating.
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/stella.jpeg" alt="유기견4" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Stella</div>
                    <div class="img-info">
                      I'm Stella, 1 years old! <br />
                      I am female and weight 3.2 kg. <br />
                      Shy and cautious, but full of affection
                    </div>
                  </div>
                </div>
              </div>
              <div class="img-box">
                <div class="img-wrap">
                  <div class="slide-img">
                    <img src="0_main/img/bao.jpeg" alt="유기견5" />
                  </div>
                  <div class="txt-box">
                    <div class="img-name">Bao</div>
                    <div class="img-info">
                      I'm Bao, 1 years old! <br />
                      I am female and weight 4.11 kg. <br />
                      I'm wearing brown socks
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="fullsection full3" pageNum="3">
        <div class="full3-bigTxt">Current status of abandoned dog</div>
        <div class="count">0</div>
        <div class="full3-smallTxt">dogs</div>
      </div>
      <div class="fullsection full4" pageNum="4">
        <!-- 메인페이지1 동영상 백그라운드 -->
        <div id="video_area">
          <video
            src="0_main/img/f4viedo.mp4"
            id="background_video"
            preload="auto"
            autoplay="autoplay"
            loop="loop"
            muted="muted"
            volume="0"
          ></video>
        </div>
        <!-- 텍스트부분 -->
        <div class="full4-txtFrame">
          <div class="full4-bigTxt">About &nbsp;&nbsp;Us</div>
          <div class="full4-smallTxt">
            <div><a href="#">Our Goal</a></div>
            <div><a href="#">Adopt Review</a></div>
          </div>
        </div>
      </div>
    </div>
  </body>

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"
  ></script>
  <script src="0_main/js/main.js"></script>
</html>
