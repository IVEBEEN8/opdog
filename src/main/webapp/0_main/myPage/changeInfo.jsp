<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
	<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
	rel="stylesheet" />
</head>
<script src="0_main/js/changeInfo.js"></script>
<link rel="stylesheet" href="0_main/css/myPage.css">
</head>
<body>
	<div class="container">
	<p class="title">ChangeInfo</p>
	<div class="columnBoxP1">
		<div class="columnP1">ID</div>
		<div class="textP1">&nbsp;&nbsp;${account.email }</div>
	</div>
	<div class="columnBoxP1">
		<div class="columnP1">First Name</div>
		<div class="textP1">&nbsp;&nbsp;&nbsp;&nbsp;${account.firstname }</div>
	</div>
	<div class="columnBoxP1">
		<div class="columnP1">Last Name</div>
		<div class="textP1">&nbsp;&nbsp;&nbsp;&nbsp;${account.lastname }</div>
	</div>
	<div class="columnBoxP2">
		<div class="columnP1">Password</div>
		<div class="textP1">
			<input name="oldPW" value="${account.pw }" type="password"
				disabled="disabled" class="yellowBox">
		</div>
	</div>
	<div class="columnBoxP2">
		<div class="columnP1">Password check</div>
		<div class="textP1">
			<input name="oldPW" type="password" class="yellowBox">
		</div>
	</div>
	<div class="selectBox-wrap">
		<input type="hidden" value="${uprCd }" id="defaultUpr"> <input
			type="hidden" value="${orgCd }" id="defaultOrg"> 
			<select class="selectBox"
			name="sido" id="sidoSelect">
			<option value="">state</option>
			<c:forEach var="sido" items="${sido }">
				<option value="${sido.orgCd }">${sido.orgdownNm }</option>
			</c:forEach>
		</select> 
		<select class="selectBox" name="sigun" id="sigunSelect">
			<option value="">city</option>
		</select>
	</div>
	<div class="columnBoxP2">
		<div class="columnP1">New password</div>
		<div class="textP1">
			<input name="newPW" type="password" class="yellowBox">
		</div>
	</div>
	<div class="columnBoxP2">
		<div class="columnP1">New password check</div>
		<div class="textP1">
			<input name="newPWCheck" type="password" class="yellowBox">
		</div>
	</div>
	<span>marked elements are essential</span>
	<button class="changeBtn" id="change">change</button>
</div>
</body>
</html>