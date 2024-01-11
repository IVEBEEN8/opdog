<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="0_main/css/myPage.css">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
	rel="stylesheet" />
</head>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css" />
<script src="0_main/js/myPage.js"></script>
<script src="0_main/js/changeInfo.js"></script>

</head>
<body>

	<div class="myPageContainer">
		<div class="totalPage">
			<div class="infoTag">
				<div class="tagImg">
					<img alt="" src="0_main/img/profileIcon.png" style="width: 100%;">
				</div>
				<div class="tagText">
					<div class="tagText-name">ID:&nbsp;${account.email }</div>
					<div class="tagText-op">Open The Dog</div>
				</div>
			</div>
			<div class="buttonBox">
				<div id="myPageButton" class="button b1" onclick="myPageButton()">
					<div class="buttonImg">
						<img alt="" src="0_main/img/myInfo.png" style="width: 100%;">
					</div>
					<div class="buttonText">my info</div>
				</div>
				<div id="likeButton" class="button b2" onclick="likeButton()">
					<div class="buttonImg">
						<img alt="" src="0_main/img/heart.png" style="width: 100%;">
					</div>
					<div class="buttonText">like</div>
				</div>
				<div id="pointButton" class="button b3" onclick="pointButton()">
					<div class="buttonImg">
						<img alt="" src="0_main/img/myPoint.png" style="width: 100%;">
					</div>
					<div class="buttonText">point</div>
				</div>
				<div id="volunteerButton" class="button b4"
					onclick="volunteerButton()">
					<div class="buttonImg">
						<img alt="" src="0_main/img/volunteerIcon.png"
							style="width: 100%;">
					</div>
					<div class="buttonText">volunteer</div>
				</div>
			</div>

			<div class="totalInnerPage">
				<div id="infoPage" class="innerPage p1">
					<div class="p1Inner">
						<div>
							<p class="title">My info
							<p>
						</div>
						<div class="itemBoxP1">
							<div class="columnBoxP1">
								<div class="columnP1">ID</div>
								<div class="textP1">
									&nbsp;&nbsp;<span class="columnP1css">${account.email }</span>
								</div>
							</div>
							<div class="columnBoxP1">
								<div class="columnP1">First Name</div>
								<div class="textP1">
									&nbsp;&nbsp;<span class="columnP1css">${account.firstname }</span>
								</div>
							</div>
							<div class="columnBoxP1">
								<div class="columnP1">Last Name</div>
								<div class="textP1">
									&nbsp;&nbsp;<span class="columnP1css">${account.lastname }</span>
								</div>
							</div>
							<div class="columnBoxP1">
								<div class="columnP1">address</div>
								<div class="textP1">
									&nbsp;&nbsp;<span class="columnP1css">${account.uprText}&nbsp;${account.orgText}</span>
								</div>
								<!-- <div class="columnBoxP2">s
								<div class="columnP1">Password</div>
								<div class="textP1">
									<input class="password">
								</div>
							</div>
							<div class="columnBoxP2">
								<div class="columnP1">new Password</div>
								<div class="textP1">
									<input class="password">
								</div>
							</div>
							<div class="columnBoxP2">
								<div class="columnP1">Password check</div>
								<div class="textP1">
									<input class="password">
								</div>
							</div> -->
							</div>
							<button class="updateButton" onclick="openModal();">Change
								Info</button>
						</div>
					</div>
					<div id="likePage" class="innerPage p2">
						<div class="like-wrapper">
							<div class="like-title">my booked dog</div>
							<div id="data-container" class="foreach-size">
								<c:forEach var="list" items="${list }" varStatus="status">
									<div class="likecontent-wrapper">
										<img alt="" src="${list.img }">
										<div class="likecontent">
											<div>
												<p>Age</p>${list.age }</div>
											<div>
												<p>Kind</p>${list.kind }</div>
											<div>
												<p>Gender</p>${list.sex }</div>
											<div>
												<p>Neuter</p>${list.neuter }</div>
										</div>
										<div class="btn-wrapper">
											<button class="like-btn" id="cancel" value="${list.no }">Cancel</button>
										</div>
									</div>
								</c:forEach>
							</div>
							<div id="pagination-container" class="pagination"></div>

						</div>
					</div>
					<div id="pointPage" class="innerPage p3">
						<div class="point-wrapper">
							<div class="point-title">
								<span>My Point</span>
							</div>
							<div class="pointMoveWrap">
								<div class="pointMove">
									<div class="nowPoint">34,000 point</div>
								</div>
							</div>

							<div class="search-wrap">
								<img class="searchIcon" src="0_main/img/SearchIcon.png"> <input
									class="search-content">

								<div class="dateRadio1 ">
									<input type="radio" id="" name="Date" value="" checked /> <label
										for="lowDate">low Date</label>
								</div>
								<div class="dateRadio2">
									<input type="radio" id="" name="Date" value="" /> <label
										for="highDate">high Date</label>
								</div>


								<table class="point-table">
									<tr class="point-semititle">
										<th class="point-th date">Date</th>
										<th class="point-th history">History</th>
										<th class="point-th point">Point</th>
									</tr>

									<tr class="point-list">
										<td class="point-td">날짜</td>
										<td class="point-td">사용처</td>
										<td class="point-td">+/- 포인</td>
									</tr>

								</table>
							</div>
						</div>
					</div>

				</div>
				<div id="volunteerPage" class="innerPage p4">
					<div class="vol-wrapper">
						<div class="vol-title">
							<span>Saved Volunteer List</span>
						</div>
						<table class="vol-table">
							<tr class="vol-semititle">
								<th class="vol-th">Post Number</th>
								<th class="vol-th">Post Title</th>
								<th class="vol-th">Applied Date</th>
								<th class="vol-th">Detail/Cancel</th>
							</tr>
							<c:forEach var="reglist" items="${reglist }" varStatus="status">
								<tr class="vol-list">
									<td class="vol-td">${reglist.postNo }</td>
									<td class="vol-td">${reglist.title }</td>
									<td class="vol-td">${reglist.applied }</td>
									<td class="vol-td"><button
											onclick="location.href='VolunteerDetailC?no=${reglist.postNo}'"
											class="vol-btn">
											<span>Detail</span>
										</button>
										<button
											onclick="location.href='DeleteFromMyListC?no=${reglist.preivateNo}'"
											class="vol-btn">
											<span class="cancle">Cancel</span>
										</button></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>

		<!--모달작업-->
		<div id="myModal" class="modal">
			<div class="modal-content">
				<span class="close" onclick="closeModal();">&times;</span>
				<div class="container">
					<p class="title">ChangeInfo</p>
					<div class="columnBoxP1">
						<div class="columnP1">ID</div>
						<div class="textP1">&nbsp;&nbsp;&nbsp;&nbsp;${account.email }</div>
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
							<input name="oldPW" value="${account.pw }" disabled="disabled"
								class="yellowBox" type="password">
						</div>
					</div>
					<div class="columnBoxP2">
						<div class="columnP1">Password check</div>
						<div class="textP1">
							<input name="oldPWCheck" class="yellowBox" type="password">
						</div>
					</div>
					<div class="selectBox-wrap">
						<input type="hidden" value="${uprCd }" id="defaultUpr"> <input
							type="hidden" value="${orgCd }" id="defaultOrg"> <select
							class="selectBox" name="sido" id="sidoSelect">
							<option value="">state</option>
							<c:forEach var="sido" items="${sido }">
								<option value="${sido.orgCd }">${sido.orgdownNm }</option>
							</c:forEach>
						</select> <select class="selectBox" name="sigun" id="sigunSelect">
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
					<span class="notice">marked elements are essential</span>
					<button class="changeBtn" id="change">change</button>
				</div>
			</div>
		</div>
</body>
</html>