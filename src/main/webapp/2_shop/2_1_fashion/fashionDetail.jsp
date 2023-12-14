<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fashion Detail</title>
</head>
<body>

		
		<div class="아이템">	
			<div class="아이템 썸네일">
		    	<img class="썸네일 이미지" src="${fashion.fs_img }" >
			</div>
	    	<div class="아이템 정보">	
    			<div class="아이템 제목">${fashion.fs_title }</div>
    			<div class="아이템 가격">${fashion.fs_price } &#8361;</div>
    			<div class="아이템 브랜드">${fashion.fs_brand }</div>
    			<button>결제하기</button> <button>하트</button>
    		</div>
    	</div>	
    	
</body>
</html>