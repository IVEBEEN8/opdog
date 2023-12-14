<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="1_adopt/js/review.js"></script>
</head>
<body>

<h1>review detail</h1>
	<div>등록날짜</div>
	<div> ${review.r_created}</div>
	<div>수정날짜</div>
	<div> ${review.r_updated }</div>
	<div>Id</div>
	<div> ${review.op_email}</div>
	
	<div>Title</div>
	<div>${review.r_title}	</div>
	<div>
	<img alt="" src="1_adopt/1_4_review/imgFolder/${review.r_img}">
	</div>
	<div>Text</div>
	<div>
	<pre>${review.r_txt}</pre>
	</div>
	<button onclick="location.href='ReviewUpC?id=${review.op_email}'">수정</button>
	<button onclick="reviewDelete('${review.op_email}')">삭제</button>
	<button onclick="location.href='ReviewC'">목록으로</button>

<form action="putCenterInfoC" method="POST">
<button>센터인터인포 db넣기!!</button>
<!-- src/main/webapp/hw/putTheCenterInfo.jsp -->
</form>
</body>
</html>