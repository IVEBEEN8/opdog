<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>volunteerNotice</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,200;9..40,300;9..40,400;9..40,500;9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Kaisei+Decol:wght@400;500;700&family=Poppins:wght@100;200;300;400;800;900&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="3_volunteer/css/volunteerNotice.css" />
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css" />


</head>
<body>
	<main>
		<div class="top">
			<div class="top-title">
				<img src="3_volunteer/img/${param.locate }Icon.png" alt="" /> <a
					href="VPostC?locate=${param.locate }">
					<p id="locate">${param.locate}</p>
				</a>
			</div>
			<div class="top-btn">
					<button name="searchBtn" value="Recruiting" class="Recruiting">Recruiting</button>
					<button name="searchBtn" value="Completed" class="Completed">Completed</button>
			</div>
				<div class="search">
					<img src="3_volunteer/img/SearchIcon.png" alt="돋보기" /> <input
						name="searchTitle"
						placeholder="Is there an article you are looking for?" onfocus="this.placeholder = ''" type="text" />
				</div>
		</div>
		<div id="volList" class="volList"></div>
		<div class="bottom btn">
				<button id="regVol" value="${param.locate }!${account.no}">Write</button>			
		</div>
		<div id="pagination-container" class="pagination-container"></div>
	</main>	
</body>
	<script src="3_volunteer/js/volunteer.js"></script>
</html>
