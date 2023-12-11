<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	window.onload = function(){
		console.log(11);
		const data = JSON.parse(localStorage.getItem(JSON.stringify('data')))
		
		console.log(data);
	}
</script>
<body>
	
</body>
</html>