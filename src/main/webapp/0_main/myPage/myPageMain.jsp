<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="0_main/css/myPage.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script src="0_main/js/myPage.js"></script>
	
</head>
<body>

	<div class="myPageContainer">
		<div class="totalPage">
			<div class="buttonBox">
				<div>img desu~</div>
				<div id="myPageButton" class="button" onclick="myPageButton()">my info</div>
				<div id="likeButton" class="button" onclick="likeButton()">like</div>
				<div id="pointButton" class="button" onclick="pointButton()">point</div>
			</div>
			<div class="totalInnerPage">
				<div id="infoPage" class="innerPage p1">
					<h1>mypageです〜</h1>
					<div>info</div>
					<div>ID: ${account.email }</div>
					<div>First Name: ${account.firstname }</div>
					<div>Last Name: ${account.lastname }</div>
					<div>PW: ********</div>
					<button onclick="location.href='UpdateInfoC'">change</button>
				</div>


				<div id="likePage" class="innerPage p2">
					<div>my booked dog</div>
					<c:forEach var="list" items="${list }" varStatus="status">
						<div>나이: ${list.age } 품종: ${list.kind } 성별: ${list.sex }
							중성화: ${list.neuter }</div>
						<button id="detail" value="${status.count }">상세보기</button>
					</c:forEach>
				</div>

				<div id="pointPage" class="innerPage p3">
					<div>point</div>
				</div>
			</div>


		</div>
	</div>







</body>
</html>