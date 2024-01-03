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
				<div id="myPageButton" class="button b1" onclick="myPageButton()">
					<div class="buttonImg"> <img alt="" src="0_main/img/contacts.svg" style="width: 100%;"> </div>
					<div class="buttonText">my info</div>
				</div>
				<div id="likeButton" class="button b2" onclick="likeButton()">
					<div class="buttonImg"> <img alt="" src="0_main/img/dashboard.svg" style="width: 100%;"> </div>
					<div class="buttonText">like</div>
				</div>
				<div id="pointButton" class="button b3" onclick="pointButton()">
					<div class="buttonImg"> <img alt="" src="0_main/img/dashboard.svg" style="width: 100%;"> </div>
					<div class="buttonText">point</div>
				</div>
				<div id="volunteerButton" class="button b4" onclick="volunteerButton()">
					<div class="buttonImg"> <img alt="" src="0_main/img/dashboard.svg" style="width: 100%;"> </div>
					<div class="buttonText">volunteer</div>
				</div>
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
				<div id="volunteerPage" class="innerPage p4">
					<div class="vol-wrapper">
						<div class="vol-title"><span>Saved Volunteer List</span></div>
						<table class="vol-table">
								<tr class="vol-semititle">
									<th class="vol-th">Post Number</th>
									<th class="vol-th">Post Title</th>
									<th class="vol-th">Applied Date</th>
									<th class="vol-th">Detail/Cancel</th>
								</tr>
							<c:forEach var="reglist" items="${reglist }" varStatus="status">
								<tr class="vol-semititle">
									<td class="vol-td">${reglist.postNo }</td>
									<td class="vol-td">${reglist.title }</td>
									<td class="vol-td">${reglist.applied }</td>
									<td class="vol-td"><button onclick="location.href='VolunteerDetailC?no=${reglist.postNo}'" class="vol-btn">Detail</button> &nbsp 
									<button onclick="location.href='DeleteFromMyListC?no=${reglist.preivateNo}'" class="vol-btn">Cancel</button></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>







</body>
</html>