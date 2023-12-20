<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Main</title>
</head>
<body>
<!-- 내가한거 -->
    <!-- <div class="fullsection full4" pageNum="4">
      <div class="review-box-wrap">
        <div class="review-box">
          <img src="../img/포인핸드1.jpg" alt="후기예시1" />
          <span>
            <button>Read more</button>
          </span>
        </div>
        <div class="review-box">
          <img class="review-img" src="../img/포인핸드2.png" />
          <span>
            <button>Read more</button>
          </span>
        </div>
        <div class="review-box">
          <img class="review-img" src="../img/포인핸드9.png" />
          <span>
            <button>Read more</button>
          </span>
        </div>
        <div class="review-box">
          <img class="review-img" src="../img/포인핸드4.jpeg" />
          <span>
            <button>Read more</button>
          </span>
        </div>
        <div class="review-box">
          <img class="review-img" src="../img/포인핸드5.png" />
          <span>
            <button>Read more</button>
          </span>
        </div>
        <div class="review-box">
          <img class="review-img" src="../img/포인핸드6.jpeg" />
          <span>
            <button>Read more</button>
          </span>
        </div>
        <div class="review-box">
          <img class="review-img" src="../img/포인핸드7.png" />
          <span>
            <button>Read more</button>
          </span>
        </div>
        <div class="review-box">
          <img class="review-img" src="../img/포인핸드8.jpeg" />
          <span>
            <button>Read more</button>
          </span>
        </div>
      </div>
    </div> -->
	
	<!-- 메인 -->
	
	<main>
		<div><a href="ReviewRegC">입양후기 작성하러가기</a></div>
		<c:forEach var="r"  items="${reviews}">
			<div class="입양후기">
				
				${r.r_title} <br>
				<img alt="" src="1_adopt/1_4_review/imgFolder/${r.r_img}"> <br>
				${r.r_img}
				<pre style="white-space: pre-wrap; width: 300px; height: 200px; overflow: auto;">${r.r_txt}</pre>
 				<%-- <textarea rows="10" cols="50" readonly="readonly">${r.r_txt}</textarea> --%>
				
				<br>
				<button onclick="location.href='ReviewDetailC?id=${r.op_email}'">디테일창으로 이동</button>
				
			</div>
		</c:forEach>
	</main>
	
	

</body>
</html>