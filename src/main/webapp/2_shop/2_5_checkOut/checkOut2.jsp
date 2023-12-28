<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>checkout2</title>
<link rel="stylesheet" href="../css/checkOut.css" />
<link rel="stylesheet" href="../css/checkOut2.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Poppins:wght@100;200;300;400&display=swap"
	rel="stylesheet" />
<script type="text/javascript" src="../js/checkOut.js"></script>
</head>
<body>
	<div class="main">
		<div class="content" id="checkout2-content">
			<div class="main-title">Checkout</div>
			<div class="second-title">
				<div class="second-tit-pay">Address</div>
				<div class="second-tit-line-cover">
					<div class="second-tit-line"></div>
				</div>
				<div class="second-tit-adr">Payment</div>
			</div>
			<div class="paypal-credit">
				<div class="paypal-cover">
					<div class="paypal-img">
						<img alt="" src="../img/PayPal 1.png">
					</div>
				</div>
				<div class="credit-cover">
					<div class="credit-card">Credit Card</div>
				</div>
			</div>
			<div class="third-title">Payment Details</div>

			<div class="input-line">
				<input class="input-box2" type="text" placeholder="Cardholder Name" />
			</div>
			<div class="input-line">
				<input class="input-box2" type="text" placeholder="Card Number" />
			</div>
			<div class="card-info">
				<div>
					<select name="year">
						<option value="">Year</option>
						<c:forEach var="year" begin="2024" end="2030" step="1">
							<option value="${year}">${year}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<select name="month">
						<option value="">Month</option>
						<c:forEach var="month" begin="1" end="12" step="1">
							<option value="${month}">${month}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<input class="input-cvc" type="text" placeholder="CVC">
				</div>
			</div>


			<div class="checkbox">
				<input type="checkbox" /> <label class="check-label"> Save card data for future payments</label>
			</div>
			<div class="pay-btn">
				<button class="continue-btn" onclick="payWithCard()">Pay
					with card</button>
			</div>
		</div>
	</div>

</body>
</html>