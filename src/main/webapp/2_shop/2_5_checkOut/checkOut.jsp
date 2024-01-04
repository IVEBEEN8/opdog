<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>checkout</title>
<link rel="stylesheet" href="../css/checkOut.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
	rel="stylesheet" />
<script type="text/javascript" src="../js/checkOut.js?ver=6"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body>
	<div class="main">
		<div class="content" id="checkout-content">
			<div class="main-title">Checkout</div>
			<div class="second-title">
				<div class="second-tit-adr">Address</div>
				<div class="second-tit-line-cover">
					<div class="second-tit-line"></div>
				</div>
				<div class="second-tit-pay">Payment</div>
			</div>
			<div class="third-title">Shopping Information</div>
			<div class="input-group">
				<div class="full-name">
					<div>
						<input class="input-name" id="firstName" type="text" placeholder="First Name" />
					</div>
					<div>
						<input class="input-name" id="lastName" type="text" placeholder="Last Name" />
					</div>
				</div>
				<div>
					<input class="input-box" id="optional" type="text"
						placeholder="Apartment,suite,etc(optional)" />
				</div>
				<div>
					<input class="input-box" id="adress" type="text" placeholder="Street address" />
				</div>
				<div>
					<input class="input-box" id="city" type="text" placeholder="City" />
				</div>
				<div>
					<input class="input-box" id="country" type="text" placeholder="Country" />
				</div>
				<div>
					<input class="input-box" id="zipCode" type="text" placeholder="Zip Code" />
				</div>
				<div>
					<input class="input-box" id="phoneNumber" type="text" placeholder="Phone number" />
				</div>
				<input id="itemTitle" type="hidden" value="${param.title}">
				<input id="itemPrice" type="hidden" value="${param.price}">
				<input id="itemBrand" type="hidden" value="${param.brand}">
				<input id="itemSPrice" type="hidden" value="${param.sPrice}">


				<div class="checkbox">
					<input type="checkbox" /> <label class="check-label"> Save
						contact information</label>
				</div>
				<div>
					<button class="continue-btn" onclick="continueShopping()">Continue
						to shopping</button>
				</div>
				<%--  ${param.title } <br>
          ${param.brand } <br>
          
          ${param.price} <br>
          ${param.sPrice } --%>
			</div>
		</div>
	</div>
</body>
</html>