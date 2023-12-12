<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript" src="../js/review.js"></script>


<body>
<h1>review register</h1>
	
	 <form action="ReviewRegC" method="post" enctype="multipart/form-data" onsubmit="return checkForm();">
	<div>
		<div>
			<div>Image</div>
			<div>
				<input id="fileInput" name="img" type="file" value="Select File" style="display: none">
				<button type="button"  onclick="document.getElementById('fileInput').click();">Select File</button>
			</div>
		</div>
		<div>
			<div>Title</div>
			<div><input id="title" name="title"> </div>
		</div>
		<div>
			<div>Text</div>
			<div><textarea id="txt" name="txt"> </textarea> </div>
		</div>
		<div>
			<div><button class="등록버튼">register</button></div>
		</div>
	</div>
</form>


</body>
</html>