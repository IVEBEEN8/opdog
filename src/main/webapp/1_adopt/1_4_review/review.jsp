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
	<!-- 내가한거 -->
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