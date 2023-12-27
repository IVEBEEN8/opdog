<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <link rel="stylesheet" href="0_main/css/myPage.css">

</head>
<body>

	<div class="myPageContainer">
		<div class="totalPage">
			<div class="buttonBox">
				<div class="button">my info</div>
				<div class="button">like</div>
				<div class="button">point</div>
			</div>

			<div class="totalInnerPage">
				<div class="innerPage p1">
					<h1>mypageです〜</h1>
					<div>info</div>
					<div>ID: ${account.email }</div>
					<div>First Name: ${account.firstname }</div>
					<div>Last Name: ${account.lastname }</div>
					<div>PW: ********</div>
					<button onclick="location.href='UpdateInfoC'">change</button>
				</div>


				<div class="innerPage p2">
					<div>my booked dog</div>
					<c:forEach var="list" items="${list }" varStatus="status">
						<div>나이: ${list.age } 품종: ${list.kind } 성별: ${list.sex }
							중성화: ${list.neuter }</div>
						<button id="detail" value="${status.count }">상세보기</button>
					</c:forEach>
				</div>

				<div class="innerPage p3">
					<div>point</div>
				</div>
			</div>


		</div>
	</div>







</body>
</html>