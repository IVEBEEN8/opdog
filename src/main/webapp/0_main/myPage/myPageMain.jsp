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
			<div class="infoTag">
				<div class="tagImg">
					<img alt="" src="0_main/img/Ellipse1.svg" style="width: 100%;">
				</div>
				<div class="tagText">
					<div class="tagText-name">名字</div>
					<div class="tagText-op">紹介</div>
				</div>
			</div>
			<div class="buttonBox">
				<div id="myPageButton" class="button" onclick="myPageButton()">my info</div>
				<div id="likeButton" class="button" onclick="likeButton()">like</div>
				<div id="pointButton" class="button" onclick="pointButton()">point</div>
			</div>

			<div class="totalInnerPage">
				<div id="infoPage" class="innerPage p1">
					<div class="p1Inner">
						<div>
							<h1>My info</h1>
						</div>
						<div class="itemBoxP1">
							<div class="columnBoxP1">
								<div class="columnP1">ID</div>
								<div class="textP1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${account.email }</div>
							</div>
							<div class="columnBoxP1">
								<div class="columnP1">First Name</div>
								<div class="textP1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${account.firstname }</div>
							</div>
							<div class="columnBoxP1">
								<div class="columnP1">Last Name</div>
								<div class="textP1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${account.lastname }</div>
							</div>
							<div class="columnBoxP1">
								<div class="columnP1">addr</div>
								<div class="textP1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${account.uprText }&nbsp;${account.orgText }</div>
							</div>
						</div>
						<button class="updateButton" onclick="location.href='UpdateInfoC'">Update</button>
					</div>
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