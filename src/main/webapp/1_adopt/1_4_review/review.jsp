<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>review</h1>
	<!-- 헤더 -->
	<header></header>
	
	<!-- 메인 -->
	
	<main>
		<div><a href="ReviewRegC">입양후기 작성하러가기</a></div>
		<c:forEach var="r"  items="${reviews}">
			<div class="입양후기 이미지">
				
				<img alt="" src="1_adopt/1_4_review/imgFolder/${r.r_img}"> <br>
				${r.r_title} <br>
				${r.r_txt}	<br>
				<button onclick="location.href='ReviewDetailC'">디테일창으로 이동</button>
				
			</div>
		</c:forEach>
	</main>
	
	
	<!-- 푸터 -->
	<footer></footer>

</body>
</html>