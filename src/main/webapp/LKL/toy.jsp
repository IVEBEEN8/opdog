<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="item-container">
		<c:forEach  varStatus="" var="t" items="${toys }">
			${fs }
			
		    <img class="item-image" src="${t.t_img }" alt="아이템 이미지">
    		
    		<div class="item-title">${t.t_title }</div>
    		
    		<div class="item-price">${t.t_price }</div>
    		<div class="item-brand">${t.t_brand }</div>
    		<button onclick="addToCart()">장바구니에 추가</button>
		</c:forEach>
	</div>

</body>
</html>