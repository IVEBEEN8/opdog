<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>review register</h1>
	<form action="ReviewRegC" method="post" enctype="multipart/form-data">
	<div>
		<div>
			<div>Image</div>
			<div><input name="img" type="file"> </div>
		</div>
		<div>
			<div>Title</div>
			<div><input name="title"> </div>
		</div>
		<div>
			<div>Text</div>
			<div><textarea name="txt"> </textarea> </div>
		</div>
		<div>
			<div><button class="등록버튼">register</button></div>
		</div>
	</div>
	</form>
</body>
</html>