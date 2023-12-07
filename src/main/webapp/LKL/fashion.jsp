<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Fashion</title>
</head>
<body>
	<!-- 헤더 -->
	<header></header>
	
	<!-- 메인 -->
	
	<div class="쇼핑 카테고리">
	
		<a class="패션 카테고리 링크" onclick="location.href='FashionC'">
			<div class="패션 카테고리">
				<div class="패션 카테고리 썸네일">
					<img alt="" src="https://shop-phinf.pstatic.net/20220704_292/16569175721794ENar_PNG/icon_14.png">
				</div>
				<div class="패션 카테고리 텍스트">fashion</div>
			</div>
		</a>
		
		<a class="사료 카테고리 링크" onclick="location.href='FeedC'">
			<div class="사료 카테고리">
				<div class="사료 카테고리 썸네일">
					<img alt="" src="https://shop-phinf.pstatic.net/20230119_57/1674087418600eO0eX_PNG/icon_04.png">
				</div>
				<div class="사료 카테고리 텍스트">feed</div>
			</div>
		</a>
		
		<a class="사료 카테고리 링크" onclick="location.href='SnackC'">
		<div class="간식 카테고리">
			<div class="간식 카테고리 썸네일">
				<img alt="" src="https://shop-phinf.pstatic.net/20220616_30/1655365227214qAvGJ_PNG/icon_05.png">
			</div>
			<div class="간식 카테고리 텍스트">snack</div>
		</div>
		</a>
		
		<a class="사료 카테고리 링크" onclick="location.href='ToyC'">
		<div class="장난감 카테고리">
			<div class="장난감 카테고리 썸네일">
				<img alt="" src="https://shop-phinf.pstatic.net/20220616_176/1655365272658tuiIW_PNG/icon_13.png">
			</div>
			<div class="장난감 카테고리 텍스트">toy</div>
		</div>
		</a>
		
		
	</div>
	
	
	
	<div class="아이템들">
		<c:forEach  varStatus="" var="fs" items="${fashions }">
		<div class="아이템">	
			<div class="아이템 썸네일">
		    	<img class="썸네일 이미지" src="${fs.fs_img }" >
			</div>
	    	<div class="아이템 정보">	
    			<div class="아이템 제목">${fs.fs_title }</div>
    			<div class="아이템 가격">${fs.fs_price } &#8361;</div>
    			<div class="아이템 브랜드">${fs.fs_brand }</div>
    		</div>
    	</div>	
		</c:forEach>
	</div>
	
	<hr>
	
	<!-- 페이지 처리 -->
	<a href="FashionPageC?p=1">[맨처음]</a>
	<c:choose>
		<c:when test="${curPageNo != 1 }">
		<a href = "FashionPageC?p=${curPageNo -1 }"><button>◀ 이전 </button></a>
		</c:when>
			<c:otherwise>
				<button class="이전버튼">◀</button>
			</c:otherwise>
	</c:choose>
	
	<c:forEach begin="1" end="${pageCount }" var = "n">
			<a href = "FashionPageC?p=${n }"> [${n }] </a>
	</c:forEach>
	
	<c:choose>
		<c:when test="${pageCount != curPageNo }">
		<a href = "FashionPageC?p=${curPageNo +1 }"><button>다음 ▶</button></a>
		</c:when>
			<c:otherwise>
				<button class="다음버튼">▶</button>
			</c:otherwise>
	</c:choose>
	<a href="FashionPageC?p=${pageCount }">[맨끝]</a>
	
	
	<!-- 푸터 -->
	<footer>
	</footer>
</body>
</html>