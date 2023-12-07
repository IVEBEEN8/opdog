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
		<c:forEach  varStatus="" var="s" items="${snacks }">
			${fs }
			
		    <img class="item-image" src="${s.s_img }" alt="아이템 이미지">
    		
    		<div class="item-title">${s.s_title }</div>
    		
    		<div class="item-price">${s.s_price }</div>
    		<div class="item-brand">${s.s_brand }</div>
    		<button onclick="addToCart()">장바구니에 추가</button>
		</c:forEach>
	</div>

</body>
</html>