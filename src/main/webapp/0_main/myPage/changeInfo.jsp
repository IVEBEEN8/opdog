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
<script src="../js/changeInfo.js"></script>
</head>
<body>
<h1>ChangeInfoです〜</h1>
*ID: <input name="email" value="${account.email }"> <br>
*FirstName: <input name="firstName" value="${account.firstname }"> <br>
*LastName: <input name="lastName" value="${account.lastname }"> <br>
Password: <input name="oldPW" value="${account.pw }" type="password" disabled="disabled"> <br>
*Password check: <input name="oldPWCheck" type="password"> <br>
New password: <input name="newPW" type="password"> <br>
New password check: <input name="newPWCheck" type="password">  <br>
<div>*가 표시된 항목은 필수 입력 항목입니다.</div>
<button id="change"> change </button>

</body>
</html>