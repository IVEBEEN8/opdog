<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<div id="DetailTbl">
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
					<button type="button" onclick="location.href='VSeoulC'">Go
						list</button>
					<button type="button"
						onclick="location.href='VolunteerModiC?no=${vol.v_no}'">
						Modify</button>
					<button type="button" onclick="deleteMovie('${vol.v_no}')">
						Delete</button>
				</div>
			</div>
			<div class="apply-btn">
				<button type="button" id="btn" value="${account.no }!${vol.v_no}!${vol.v_status}!${vol.v_title }!${vol.v_created }!${vol.v_img }!${vol.v_txt }!${account.email }">Apply for volunteer</button>
			</div>
			<div class="img-wrap">
				<img alt="" src="3_volunteer/img/click.png">
			</div>
		</main>
	</form>

</body>
</html>
