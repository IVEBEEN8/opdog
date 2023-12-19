<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="1_adopt/js/reviewUpdate.js"></script>

</head>
<body>

<h1>review update</h1>

<form action="ReviewUpC?id=${review.op_email }" method="post" enctype="multipart/form-data" onsubmit="return checkForm();">
	<div>등록날짜</div>
	<div> ${review.r_created}</div>
	<div>수정날짜</div>
	<div> ${review.r_updated}</div>
	<div>Id</div>
	<div> ${review.op_email}</div>
	
	<div>
		<div>
			<div>Title</div>
			<div><input id="title" name="title" value="${review.r_title}"> </div>
		</div>
		<div>
			<div>Image</div>
			<div>
				<img id="previewImage" src="1_adopt/1_4_review/imgFolder/${review.r_img}">
				<input id="oldImg" name="oldImg" value="${review.r_img}" style="display: none">
				<input id="fileInput" name="newImg" type="file" value="Select File" style="display: none" onchange="previewSelectedImage(this)">
				<button type="button"  onclick="document.getElementById('fileInput').click();">Select File</button>
			</div>
		</div>
		<div>
			<div>Text</div>
			<textarea id="txt" name="txt" cols="50" rows="10" oninput="checkLength()">${review.r_txt}</textarea>
             <div id="charCount"></div>
			
		</div>
		<div>
			<div><button name="id" value="${review.op_email}" class="수정완료버튼">수정완료</button></div>
		</div>
	</div>
	</form>
	
	
	

</body>
</html>