<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>AccountMain</title>
    <link rel="stylesheet" href="0_main/css/header.css" />
    <link rel="stylesheet" href="0_main/css/accountMain.css" />
    <link rel="stylesheet" href="0_main/css/footer.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,200;9..40,300;9..40,400;9..40,500;9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>

    <!-- 회원가입 부분시작 -->
    <form action="SignUpC" method="post">
      <div class="containar-hw">
        <div class="sub-containar-hw">
          <div class="accountPage ac-title">
            <span>Account Page</span>
            <p>welcome to 'Open the dog'</p>
          </div>
          <div class="accountPage ac-fName">
            <p>First name</p>
            <input name="firstName" placeholder="Enter your First name" />
          </div>
          <div class="accountPage ac-lName">
            <p>Last name</p>
            <input name="lastName" placeholder="Enter your Last name" />
          </div>
          <div class="accountPage ac-id">
            <p>E-mail</p>
            <input name="id" placeholder="Type your e-mail" />
          </div>
          <div class="accountPage ac-pw">
            <p>Password</p>
            <input name="pw" type="password" placeholder="Type your password" />
            <div>Must be 8 characters at least</div>
          </div>
          <div class="accountPage ac-pw">
            <p>Check Password</p>
            <input
              name="pwCheck"
              type="password"
              placeholder="Check your password"
            />
            <div>Must be 8 characters at least</div>
          </div>
          <label>
            <input type="checkbox" name="agree" value="mail" />
            <p>
              By creating an account means you agree to the
              <span>Terms and Conditions</span>, and our
              <span>Privacy Policy</span>
            </p>
          </label>
          <div class="hw-account-btn">
            <button>Sign up</button>
          </div>
          <div class="other-account">
            <div></div>
            <p>or do it via other accounts</p>
            <div></div>
          </div>
          <div class="account-icon-wrap">
            <div class="account-icon">
              <a href="#"><img src="0_main/img/google.svg" /></a>
              <a href="#"><img src="0_main/img/apple.svg" /></a>
              <a href="#"><img src="0_main/img/facebook.svg" /></a>
            </div>
          </div>
        </div>
      </div>
    </form>
    
  </body>
</html>
