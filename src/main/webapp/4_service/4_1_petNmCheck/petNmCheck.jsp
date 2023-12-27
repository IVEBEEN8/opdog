<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script type="module" src="4_service/js/petNmCheck.js"></script>
<link rel="stylesheet" href="4_service/css/petNmCheck.css">

</head>
<style>

</style>
<body>
<div class="big-mama">
<div class="title-box4_1">
	<span class="title4_1">Search registration numbers</span>
	<img class="paw-img" src="4_service/img/paw.png">
	<img class="paw-img1" src="4_service/img/titledog.png">
</div>
<hr class="yellow-bar">

<div class="petnmcheck-wrap">
	<div class="petnm-info-box">
		<ul>
		<br>
			<li>In the case of an animal registration number search, the owner must be a member of the animal protection management system and the owner's information must be registered to properly search.</li>
		<br>
			<li>In order to prevent the animal registration information from being checked arbitrarily, the owner's personal information must be additionally entered to search for the animal registration number.</li>
		</ul>
		<br>
	</div>
	
<div class="wrap-for-input-wrap">
	<div class="input-wrap">
		<p class="input-name4_1">Full Name Of The Owner</p>
		<input class="owner-input" id= "name">
	<br>
	</div>
	<div class="input-wrap">
		<p class="input-name4_1">Registration Numbers</p>
		<input class="petnm-input" id= "petnum">
	</div>
	
	<button class="find-btn4_1" id="submit">Search</button>
	<div id="resultContainer"></div>
</div>
</div>
</div>	
</body>
</html>
