<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy</title>
<link rel="stylesheet" href="2_shop/css/shop.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css" />
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
						onclick="location.href='ToySearchC?search='+document.getElementById('search').value">
				</div>
			</div>
			<div class="search-zero">${message}</div>
			<div class="price-order" align="right">
				<label class="price-label" for="radio-high-price"><input type="radio" name="sort" value="high" id="radio-high-price"
					onclick="location.href='ToySortC?sort=high'"> Highest price
				&nbsp; </label>
				<label class="price-label" for="radio-low-price"><input type="radio" name="sort" value="low" id="radio-low-price"
					onclick="location.href='ToySortC?sort=low'"> Lowest price</label>

			</div>
		</div>
		<div class="items-container">
			<div id="items" class="items">
				<%-- <c:forEach varStatus="" var="t" items="${toys }">
					<a href="ToyDetailC?no=${t.t_no }">
						<div class="item">
							<div class="아이템 썸네일">
								<img class="item-img" src="${t.t_img }">
							</div>
							<div class="item-info">
								<div class="item-brand" align="left">${t.t_brand }</div>
								<div class="item-title" align="left">${t.t_title }</div>
							</div>
							<div class="item-line-price">
								<div class="item-line">
									<div id="item-line"></div>
								</div>
								<div class="item-price" align="left">${t.t_price }&#8361;</div>
							</div>
						</div>
					</a>
				</c:forEach> --%>
				<!-- <div> <button onclick="location.href='FashionRegC'">데이터 입력 </button> </div> -->
			</div>
		</div>
		<div id="pagination-container" class="pagination-container"></div>
		<hr>

		<script type="text/javascript">
			$(document)
					.ready(
							function() {
								var dataSource = ${jsonToys}; // 데이터 소스, 예: 페이지 번호의 배열

								$('#pagination-container')
										.pagination(
												{
													dataSource : dataSource,
													pageSize : 12, // 페이지당 항목 수
													callback : function(data,
															pagination) {
														console.log(data); // 확인을 위한 로그
														var dataHtml = '';
														$
																.each(
																		data,
																		function(
																				index,
																				item) {
																			dataHtml += '<a href="ToyDetailC?no='
																					+ item.t_no
																					+ '">';
																			dataHtml += '<div class="item">';
																			dataHtml += '<div class="아이템 썸네일">';
																			dataHtml += '<img class="item-img" src="' + item.t_img + '">';
																			dataHtml += '</div>';
																			dataHtml += '<div class="item-info">';
																			dataHtml += '<div class="item-brand" align="left">'
																					+ item.t_brand
																					+ '</div>';
																			dataHtml += '<div class="item-title" align="left">'
																					+ item.t_title
																					+ '</div>';
																			dataHtml += '</div>';
																			dataHtml += '<div class="item-line-price">';
																			dataHtml += '<div class="item-line">';
																			dataHtml += '<div id="item-line"></div>';
																			dataHtml += '</div>';
																			dataHtml += '<div class="item-price" align="left">'
																					+ item.t_price
																					+ '₩</div>';
																			dataHtml += '</div>';
																			dataHtml += '</div>';
																			dataHtml += '</a>';
																		});

														$('#items').html(
																dataHtml);
													}
												});
							});
		</script>
		<script>
  // Controller에서 전달된 체크된 radio button 적용
  const checkedRadio = "${checkedRadio}";
  if (checkedRadio === "high") {
    document.getElementById("radio-high-price").checked = true;
  } else if (checkedRadio === "low") {
    document.getElementById("radio-low-price").checked = true;
  }
</script>
<script>
  document.getElementById("search").addEventListener("keydown", function(event) {
    if (event.keyCode === 13) { // Enter key pressed
      event.preventDefault(); // Prevent default form submission
      location.href = 'ToySearchC?search='+document.getElementById('search').value;
    }
  });
</script>



	</div>


	<!-- 푸터 -->
	<footer> </footer>
</body>
</html>