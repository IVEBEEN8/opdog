<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feed</title>
<link rel="stylesheet" href="2_shop/css/shop.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
	rel="stylesheet" />
</head>
<body>
	<!-- 헤더 -->
	<header></header>

	<!-- 메인 -->
	<div class="shop-main">
		<div class="shop-header">
			<div>
				<div class="shop-title-cover">
					<div class="shop-title">SHOP</div>
				</div>
			</div>
		</div>


		<div class="shop-cate">

			<div class="item-cate">
				<div class="cate-thumb">
					<a class="cate-link" onclick="location.href='FashionC'"> <img
						class="cate-img" alt="" src="2_shop/img/fashion_icon.png">
						<div class="cate-txt">Fashion</div>
					</a>
				</div>
			</div>

			<div class="item-cate">
				<div class="cate-thumb">
					<a class="cate-link" onclick="location.href='FeedC'"> <img
						class="cate-img" alt="" src="2_shop/img/feed_icon.png">
						<div class="cate-txt">Feed</div>
					</a>
				</div>
			</div>

			<div class="item-cate">
				<div class="cate-thumb">
					<a class="cate-link" onclick="location.href='SnackC'"> <img
						class="cate-img" alt="" src="2_shop/img/snack_icon.png">
						<div class="cate-txt">Snack</div>
					</a>
				</div>
			</div>

			<div class="item-cate">
				<div class="cate-thumb">
					<a class="cate-link" onclick="location.href='ToyC'"> <img
						class="cate-img" alt="" src="2_shop/img/toy_icon.png">
						<div class="cate-txt">Toy</div>
					</a>
				</div>
			</div>
		</div>
		<div class="search-price">
			<div class="search">
				<div>
					<input type="text" id="search" placeholder="Search">
				</div>
				<div class="search-img">
					<img alt="" src="2_shop/img/Search.png"
						onclick="location.href='FeedSearchC?search='+document.getElementById('search').value">
				</div>
			</div>
			<div class="search-zero">${message}</div>
			<div class="price-order" align="right">
				<input type="radio" name="sort" value="low"
					onclick="location.href='FeedSortC?sort=low'"> Highest price
				 &nbsp; <input type="radio" name="sort" value="high"
					onclick="location.href='FeedSortC?sort=high'"> Lowest price
				
			</div>
		</div>
		<div class="items-container">
			<div class="items">
				<c:forEach varStatus="" var="f" items="${feeds }">
					<a href="FeedDetailC?no=${f.f_no }">
						<div class="item">
							<div class="아이템 썸네일">
								<img class="item-img" src="${f.f_img }">
							</div>
							<div class="item-info">
								<div class="item-brand" align="left">${f.f_brand }</div>
								<div class="item-title" align="left">${f.f_title }</div>
							</div>
							<div class="item-line-price">
								<div class="item-line">
									<div id="item-line"></div>
								</div>
								<div class="item-price" align="left">${f.f_price }
									&#8361;</div>
							</div>
						</div>
					</a>
				</c:forEach>
				<!-- <div> <button onclick="location.href='FashionRegC'">데이터 입력 </button> </div> -->
			</div>
		</div>

		<hr>

		<div class="page-controller">
			<!-- 페이지 처리 -->
			<a href="FashionPageC?p=1">[맨처음]</a>
			<c:choose>
				<c:when test="${curPageNo != 1 }">
					<a href="FashionPageC?p=${curPageNo -1 }"><button>◀</button></a>
				</c:when>
				<c:otherwise>
					<button class="이전버튼">◀</button>
				</c:otherwise>
			</c:choose>

			<c:forEach begin="1" end="${pageCount }" var="n">
				<a href="FashionPageC?p=${n }"> [${n }] </a>
			</c:forEach>

			<c:choose>
				<c:when test="${pageCount != curPageNo }">
					<a href="FashionPageC?p=${curPageNo +1 }"><button>▶</button></a>
				</c:when>
				<c:otherwise>
					<button class="다음버튼">▶</button>
				</c:otherwise>
			</c:choose>
			<a href="FashionPageC?p=${pageCount }">[맨끝]</a>
		</div>



	</div>


	<!-- 푸터 -->
	<footer> </footer>
</body>
</html>