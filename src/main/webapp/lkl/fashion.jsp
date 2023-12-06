<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
</head>
<body>
	<!-- 헤더 -->
	<header></header>
	
	<!-- 메인 -->
	
	<div class="쇼핑 카테고리">
		<div class="패션 카테고리">
			<div class="패션 카테고리 썸네일">
				<img alt="" src="">
			</div>
			<div class="패션 카테고리 텍스트">fashion</div>
		</div>
		<div class="사료 카테고리">
			<div class="사료 카테고리 썸네일">
				<img alt="" src="">
			</div>
			<div class="사료 카테고리 텍스트">feed</div>
		</div>
		<div class="간식 카테고리">
			<div class="간식 카테고리 썸네일">
				<img alt="" src="">
			</div>
			<div class="간식 카테고리 텍스트">snack</div>
		</div>
		<div class="장난감 카테고리">
			<div class="장난감 카테고리 썸네일">
				<img alt="" src="">
			</div>
			<div class="장난감 카테고리 텍스트">toy</div>
		</div>
	</div>
	
	
	
	<div class="아이템들">
		<c:forEach  varStatus="" var="fs" items="${fashions }">
		<div class="아이템">	
			<div class="아이템 썸네일">
		    	<img class="썸네일 이미지" src="${fs.fs_img }" >
			</div>
	    	<div class="아이템 정보">	
    			<div class="아이템 제목">${fs.fs_title }</div>
    			<div class="아이템 가격">${fs.fs_price }</div>
    			<div class="아이템 브랜드">${fs.fs_brand }</div>
    		</div>
    	</div>	
		</c:forEach>
	</div>
	
	<!-- 푸터 -->
	<footer>
	</footer>
</body>
</html>