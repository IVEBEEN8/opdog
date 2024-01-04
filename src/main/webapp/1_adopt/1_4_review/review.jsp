<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Main</title>
<script type="text/javascript" src="1_adopt/js/review.js?ver=16"></script>
<link rel="stylesheet" href="1_adopt/css/adoptReview.css" />
</head>
<body>
	<div class="fullsection full4">
		
		<div class="review-box-wrap">
			<c:forEach var="r" items="${reviews}">
				<div class="review-box">
					<img class="review-img"
						src="1_adopt/1_4_review/imgFolder/${r.r_img}"> <span>
						<button onclick="location.href='ReviewDetailC?no=${r.r_no}'">Read
							more</button>
					</span>
				</div>
			</c:forEach>
		</div>
		
		<!-- 페이지 처리 왼쪽 -->
		<div class="page-controller">
			<c:forEach begin="1" end="${pageCount}" var="n">
			</c:forEach>
			<c:choose>
				<c:when test="${curPageNo != 1 }">
					<a href="ReviewPageC?p=${curPageNo -1 }"><button class="left">◀</button></a>
				</c:when>
				<c:otherwise>
					<button onclick="dontMove()" class="left">◀</button>
				</c:otherwise>
			</c:choose>
		</div>
		<!-- 페이지 처리 오른쪽 -->
		<div class="page-controller">
			<c:choose>
				<c:when test="${pageCount != curPageNo }">
					<a href="ReviewPageC?p=${curPageNo +1 }"><button class="right">▶</button></a>
				</c:when>
				<c:otherwise>
					<button onclick="dontMove()" class="right">▶</button>
				</c:otherwise>
			</c:choose>
		</div>

	</div>
	<div class="adopt-btn">
		<button id="goReviewReg" value="${sessionScope.account}"
			onclick="goReviewReg()">Write</button>
	</div>










	<%-- 
		<c:forEach var="r" items="${reviews}">
			<div class="review-box">

				${r.r_title} <br> <img class="review-img" alt=""
					src="1_adopt/1_4_review/imgFolder/${r.r_img}"> <br>
				${r.r_img}
				<pre
					style="white-space: pre-wrap; width: 300px; height: 200px; overflow: auto;">${r.r_txt}</pre>
				<textarea rows="10" cols="50" readonly="readonly">${r.r_txt}</textarea>

				<br>
				<button onclick="location.href='ReviewDetailC?id=${r.op_email}'">디테일창으로
					이동</button>
			</div>
		</c:forEach> --%>


</body>
</html>