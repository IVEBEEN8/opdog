<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="SignUpC" method="post">
	<div class ="containar-hw">
		<div class="sub-containar-hw">
			<h3>Create your account</h3>
			<p>Open the door with 'Open the dog'!</p>
			<div>
				<p>First name</p>
				<input name="firstname" placeholder="Enter your First name">
			</div>
			<div>
				<p>Last name</p>
				<input name="lastname" placeholder="Enter your Last name">
			</div>
			<div>
				<p>E-mail</p>
				<input name="email" placeholder="Enter your e-mail">
			</div>
			<div>
				<p>Password</p>
				<input name="pw" type="password" placeholder="Type your password">
				<p>Must be 8 characters at least</p>
			</div>
			<div>
				<p>Check Password</p>
				<input type="password" placeholder="Check your password">
				<p>Must be 8 characters at least</p>
			</div>
			<div>
				<input type="checkbox"> By creating an account means you agree to the Terms and Conditions, and our Privacy Policy
			</div>
				
			<div>
				<button>Sign Up</button>
			</div>
			<div>
				<p>or do it via other accounts</p>
			</div>
			<div>
				<a href="">google</a>
				<a href="">apple</a>
				<a href="">facebook</a>
			</div>
			<div>
				<p>Already have an account?</p>
				<button type="button" onclick="location.href='LoginMainHC'" >Sign In</button>
			</div>
		</div>
	</div>
</form>


</body>
</html>