<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkout3</title>

</head>
<body>
	<div>
		<div>
			<div>
				<img alt="" src="">강아지사진
				 ${param.title } <br>
          ${param.brand } <br>
          
          ${param.price} <br>
          ${param.sPrice }
			</div>
			<div><button onclick="location.href='MyPageHC'">My Page</button></div>
			<div><button onclick="location.href='FashionC'">More Shopping</button></div>
		</div>
	</div>
</body>
</html>