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
<script type="text/javascript" src="petNmCheck.js"></script>

</head>
<style>
.input-wrap{
width: 500px;
display: flex;
}
p{
width: 500px;
}
</style>
<body>
<div>
<br>sads
<br>sads
<br>sads
<br>sads
<br>sads
<br>sads
<br>sads
<br>sads
<br>sads
<br>sads
<br>sads
<br>sads
<br>sads
<br>sads
	<div class="input-wrap">
	<p>보호자명</p>
	<input id= "name">
	<br>
	</div>
	<div class="input-wrap">
	<p>동물등록번호</p>
	<input id= "petnum">
	</div>
	<button id="submit">조회하기</button>
	<div id="resultContainer"></div>

</div>	
</body>
</html>
