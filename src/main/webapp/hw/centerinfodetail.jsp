<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>we are going</h1>
<c:forEach var="c" items="${centers }">
	<table border ="1">
		<tr>
			<td>No</td>
			<td>${c.no }</td>
		</tr>
		<tr>
			<td>센터명</td>
			<td>${c.careNm }</td>
		</tr>
		<tr>
			<td>센터주소</td>
			<td>${c.careAddr }</td>
		</tr>
		<tr>
			<td>위도</td>
			<td>${c.lat	}</td>
		</tr>
		<tr>
			<td>경도</td>
			<td>${c.lng }</td>
		</tr>
		<tr>
			<td>수의사수</td>
			<td>${c.vetPersonCnt }</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${c.careTel }</td>
		</tr>
	</table>
</c:forEach>

</body>
</html>