<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>review</h1>
	<!-- 헤더 -->
	<header></header>
	
	<!-- 메인 -->
	<main></main>
	<c:forEach var="r"  items="${reviews }">
		<div class="입양후기 이미지">
			<a href="reviewDetail.jsp"><img alt="" src="${r.r_img }"></a>
		</div>
	</c:forEach>
	
	
	<!-- 푸터 -->
	<footer></footer>

</body>
</html>