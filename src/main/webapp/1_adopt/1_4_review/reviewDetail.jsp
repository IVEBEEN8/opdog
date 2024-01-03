<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review detail</title>
<script type="text/javascript" src="1_adopt/js/review.js?ver=1"></script>
<link rel="stylesheet" href="1_adopt/css/reviewDetail.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
	rel="stylesheet" />
</head>
<body>
	<div class="main">
		<div class="container">
			<div>
				<div class="review-title">${review.r_title}</div>
				<div class="review-info">
					<div class="review-id">ID : ${review.a_no}</div>
					<div class="review-vertical"></div>
					<div class="review-created">${review.r_created}</div>
				</div>
			</div>
			<div>
				<img class="review-img" alt=""
					src="1_adopt/1_4_review/imgFolder/${review.r_img}">
			</div>
			<div>
				<textarea class="review-txt" rows="10" cols="50" readonly="readonly">${review.r_txt}</textarea>
			</div>
			<div class="review-btn">
				<button class="review-edit-btn" onclick="location.href='ReviewUpC?no=${review.r_no}'">Edit</button>
				<button class="reiview-list-btn" onclick="location.href='ReviewC'">Review List</button>
				<button class="review-edit-btn" onclick="reviewDelete('${review.r_no}')">Delete</button>
			</div>
		</div>
	</div>
</body>
</html>
				<!-- <form action="putCenterInfoC" method="POST">
					<button>센터인터인포 db넣기!!</button>
					src/main/webapp/hw/putTheCenterInfo.jsp
				</form> -->