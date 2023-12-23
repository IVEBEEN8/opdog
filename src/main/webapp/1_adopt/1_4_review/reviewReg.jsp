<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review register</title>
<script type="text/javascript" src="1_adopt/js/review.js?ver=13"></script>
</head>



<body>
<h1>review register</h1>
	
	 <form action="ReviewRegC" method="post" enctype="multipart/form-data" onsubmit="return checkForm();">
	<div>
		<div>
		<div>
			<div>Title</div>
			<div><input id="title" name="title"> </div>
		</div>
			<div>Image</div>
			 <div style="display: none;">
                <img id="previewImage" style="max-width: 300px; max-height: 300px;" src="#" alt="Preview">
            </div>
			<div>
				<input id="fileInput" type="file" name="fileInput" value="Select File" style="display: none" oninput="previewSelectedImage(this)">
				<button type="button"  onclick="document.getElementById('fileInput').click();">Select File</button>
				<div style="display: none;">
				</div>
			</div>
		</div>
		<div>
			<div>Text</div>
			 <textarea id="txt" name="txt" cols="30" rows="5" oninput="checkLength()"></textarea>
             <div id="charCount"></div>
		</div>
		<div>
			<div><button class="등록버튼">register</button></div>
		</div>
	</div>
</form>


</body>
</html>