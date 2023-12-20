<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="checkout1.css" />
  </head>
  <body>
    <div class="main">
      <div class="content">
        <h1>Checkout</h1>
        <h3>Address - Payment</h3>
        <h2>Shopping Information</h2>
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
            <input class="input-box" type="text" placeholder="Street address" />
          </div>
          <div>
            <input class="input-box" type="text" placeholder="City" />
          </div>
          <div>
            <input class="input-box" type="text" placeholder="Country" />
          </div>
          <div>
            <input class="input-box" type="text" placeholder="Zip Code" />
          </div>
          <div>
            <input class="input-box" type="text" placeholder="Phone number" />
          </div>

          <div><input type="checkbox" /> Save contact information</div>
          <div><button class="continue-btn">Continue to shopping</button></div>
          ${param.price} <br>
         ${param.sPrice }
        </div>
      </div>
    </div>
  </body>
</html>