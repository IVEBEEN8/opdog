<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LoginMainHC" method="post">
	<div class ="containar-hw">
		<div class="sub-containar-hw">
			<h3>Login Page</h3>
			<p>welcome to 'Open the dog'</p>
			<div>
				<p>E-mail or phone number</p>
				<input name="email" placeholder="Type your e-mail or phone number">
			</div>
			<div>
				<p>Password</p>
				<input name="pw" type="password" placeholder="Type your password">
			</div>
			<div>
				<button>Login in</button>
			</div>
			<div>
				<a href="">google</a>
				<a href="">apple</a>
				<a href="">facebook</a>
			</div>
			<div>
				<p>Don't have an account?</p>
				<button type="button" onclick="location.href='SignUpC'" >Sign Up</button>
			</div>
		</div>
	</div>
</form>
</body>
</html>