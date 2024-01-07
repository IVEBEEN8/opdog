<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="3_volunteer/css/volunteerDetail.css" />
<script src="3_volunteer/js/volunteer.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

</head>
<body>
	<form class="container" action="VolunteerDetailC" method="post"
		enctype="multipart/form-data">
		<main>
			<div class="vol-main">
				<div class="vol-container">
					<div>
						<div class="review-title">${vol.v_title }</div>
						<div class="review-info">
							<div class="review-id">ID : ${vol.a_email}</div>
							<div class="review-vertical"></div>
							<div class="review-created">${vol.v_created }</div>
						</div>
					</div>
					<div class="statusWrap">
						<div class="post-status">
							<div class="recruiting"> ${vol.v_status }</div>
						</div>
					</div>
					<div>
						<img class="review-img" alt=""
							src="3_volunteer/newImg/${vol.v_img }">
					</div>
					<div>
						<textarea class="review-txt" rows="10" cols="50"
							readonly="readonly">${vol.v_txt }</textarea>
					</div>
					<div class="review-btn">
						<button type="button" class="review-edit-btn"
							onclick="modifyPost('${account.no}','${vol.a_no }','${vol.v_no }')">Modify</button>
						<button type="button" class="reiview-list-btn" onclick="location.href='VPostC?locate=${vol.v_locate}'">Go
							list</button>
						<button type="button" class="review-edit-btn"
							onclick="deletePost('${account.no }','${vol.a_no }','${vol.v_no}','${vol.v_locate }')">Delete</button>
					</div>
					<div class="apply-btn">
						<button type="button" id="btn"
							value="${account.no }!${vol.v_no}!${vol.v_status}!${vol.v_title }!${vol.v_created }!${vol.v_img }!${vol.v_txt }!${account.email }">Apply
							for volunteer</button>
					</div>
					<div class="img-wrap">
						<img alt="" id="btnlogo" src="3_volunteer/img/click.png">
					</div>
				</div>
			</div>

			<!-- 기존 volunteerDetail.jsp -->
			<%-- <div id="DetailTbl">
				<div class="statusWrap">
					<div class="post-status">
						<p>${vol.v_status }</p>
					</div>
				</div>
				<div class="post-title">${vol.v_title }</div>
				<div class="post-date">${vol.v_created }</div>
				<div class="imgWrapper">
					<img src="3_volunteer/newImg/${vol.v_img }" />
				</div>
				<div class="post-txt">
					<p>${vol.v_txt }</p>
				</div>
				<div class="btnWrap">
					<button type="button" onclick="location.href='VPostC?locate=${vol.v_locate}'">Go
						list</button>
					<button type="button"
						onclick="modifyPost('${account.no}','${vol.a_no }','${vol.v_no }')">
						Modify</button>
<<<<<<< HEAD
					<button type="button" onclick="deletePost('${account.no }','${vol.a_no }','${vol.v_no}','${vol.v_locate }')">
=======
					<button type="button"
						onclick="deletePost('${account.no }','${vol.a_no }','${vol.v_no}')">
>>>>>>> e1a90c4d46711dfa664ba3bfa73373c312be66fd
						Delete</button>
				</div>
			</div>
			<div class="apply-btn">
				<button type="button" id="btn"
					value="${account.no }!${vol.v_no}!${vol.v_status}!${vol.v_title }!${vol.v_created }!${vol.v_img }!${vol.v_txt }!${account.email }">Apply
					for volunteer</button>
			</div>
			<div class="img-wrap">
				<img alt="" id="btnlogo" src="3_volunteer/img/click.png">
			</div> --%>
		</main>
	</form>
	<script>
		document.addEventListener('DOMContentLoaded', function() {
			var statusValue = "${vol.v_status}";
			console.log(statusValue);
			var applyButton = document.getElementById('btn');
			var buttonLogo = document.getElementById('btnlogo');
			// Check the value of ${vol.v_status} and decide whether to show or hide the button
			if (statusValue === 'Recruiting') { // replace 'some_condition' with the actual condition you want to check
				applyButton.style.display = 'block'; // or 'inline' or 'inline-block' depending on your layout
				buttonLogo.style.display = 'block';
			} else {
				applyButton.style.display = 'none';
				buttonLogo.style.display = 'none';
			}
		});
	</script>

</body>
</html>
