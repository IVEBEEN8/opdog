<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review register</title>
<script type="text/javascript" src="1_adopt/js/review.js?ver=14"></script>
<link rel="stylesheet" href="1_adopt/css/reviewReg.css">
</head>



<body>
	<form action="ReviewRegC" method="post" enctype="multipart/form-data"
		accept-charset="UTF-8" onsubmit="return checkForm();">
		<div class="main">
			<div class="main-title">Write a review</div>
			<div class="container">
				<div class="sub-container">
					<div>
						<div class="review-title">Title</div>
						<div>
							<input class="input-title" id="title" name="title"
								placeholder="Please enter the title">
						</div>
					</div>

					<div>
						<div class="review-title">Story</div>
						<textarea class="input-story" id="txt" name="txt" cols="30"
							rows="10" placeholder="Please write your story"
							oninput="checkLength()"></textarea>
						<div id="charCount"></div>
					</div>
					<div>
						<div class="review-img-cover">
							<div class="review-title">Photo</div>
							<div class="select-btn-cover">
								<input id="fileInput" type="file" name="fileInput"
									value="Select File" style="display: none"
									oninput="previewSelectedImage(this)">
								<button class="select-btn" type="button"
									onclick="document.getElementById('fileInput').click();">Select
									File</button>
							</div>
							<div class="preview-img-cover" style="display: none;">
								<img class="preview-img" id="previewImage" src="#" alt="Preview">
							</div>
						</div>
					</div>



					<div class="review-btn">
						<button class="review-reg-btn">register</button>
					</div>

				</div>
			</div>
		</div>
	</form>


</body>
</html>