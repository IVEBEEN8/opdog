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
<script type="text/javascript">
	function aa(){
		if ('${alert}'!="") {
			alert('${alert}')
		}
	}
	
	function rememberPreviousPages() {
	    // 현재 페이지 경로 가져오기
	    var currentPage = window.location.href;

	    // 이전 페이지를 세션 스토리지에서 가져오기
	    var previousPage = sessionStorage.getItem("previousPage");

	    // 전전 페이지를 세션 스토리지에서 가져오기
	    var previousPage2 = sessionStorage.getItem("previousPage2");

	    // 현재 페이지를 세션 스토리지에 저장
	    sessionStorage.setItem("previousPage2", previousPage);
	    sessionStorage.setItem("previousPage", currentPage);

	    // true를 반환하면 폼이 제출되고, false를 반환하면 제출이 취소됩니다.
	    console.log("Current Page: " + currentPage);
	    console.log("Previous Page: " + previousPage);
	    console.log("Previous Page 2: " + previousPage2);
	    return true;
	}
</script>

</head>
  <body onload="aa()">

    <!-- 로그인부분시작 -->
    <form action="LoginMainHC" method="post" onsubmit="rememberPreviousPage()">
    	<input type="hidden" id="previousPage" name="previousPage" />
      <div class="containar-hw">
        <div class="sub-containar-hw">
          <div class="loginpage lp-title">
            <span>Login Page</span>
            <p>welcome to 'Open the dog'</p>
          </div>
          <div class="loginpage lp-id">
            <p>E-mail or phone number</p>
            <input
              name="email"
              placeholder="Type your e-mail or phone number"
            />
          </div>
          <div class="loginpage lp-pw">
            <p>Password</p>
            <input name="pw" type="password" placeholder="Type your password" />
          </div>
          <div class="forgot-pw">
            <div>Forgot Password?</div>
          </div>
          <div class="hw-login-btn">
            <button>Login</button>
          </div>
      <!--     <div class="other-account">
            <div></div>
            <p>or do it via other accounts</p>
            <div></div>
          </div>
          <div class="account-icon-wrap">
            <div class="account-icon">
              <a href="#"><img src="0_main/img/google.svg" /></a>
              <a href="#"><img src="0_main/img/apple.svg" /></a>
              <a href="#"><img src="0_main/img/facebook.svg" /></a>
            </div> -->
          </div>
          <div class="signUp-guide">
            <p>Don't have an account?</p>
            <button type="button" onclick="location.href='SignUpC'">
              Sign Up
            </button>
          </div>
        </div>
    </form>
 
  </body>
</html>
