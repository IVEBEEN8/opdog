<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="checkOut.css" />
    <script type="text/javascript" src="../js/shop.js"></script>
  </head>
  <body>
    <div class="main">
      <div class="content" id="checkout2-content">
        <h1>Checkout</h1>
        <h3>Address - Payment</h3>
        <h2>Payment Details</h2>
        <div class="input-group">
          <div class="full-name">
            <div>
              <input class="input-name" type="text" placeholder="First Name" />
            </div>
            <div>
              <input class="input-name" type="text" placeholder="Last Name" />
            </div>
          </div>
          <div>
            <input
              class="input-box"
              type="text"
              placeholder="Apartment,suite,etc(optional)"
            />
          </div>
          <div>
            <input class="input-box" type="text" placeholder="Cardholder Name" />
          </div>
          <div>
            <input class="input-box" type="text" placeholder="Card Number" />
          </div>
         

          <div><input type="checkbox" /> Save contact information</div>
          <div><button class="continue-btn"  onclick="continueShopping()">Pay with card</button></div>
          ${param.price} <br>
         ${param.sPrice }
        </div>
      </div>
    </div>
  </body>
</html>