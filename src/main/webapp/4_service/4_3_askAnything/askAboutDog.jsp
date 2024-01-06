<%@ page import="com.opdoghw.askaboutdog.askAnythingDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<script type="module" src="4_service/js/askAboutDog.js"></script>
<script type="text/javascript" src="4_service/js/getTheDate.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="4_service/css/askAboutDog.css">

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="chat-content-wrap1-2">
    <div class="chat-content1-2">
    	<div class="smartphone-wrap">
    		<div class="chat-box-wrap1-2">
    			<div class="date1-2"  id="date1"></div>	
	      		<div class="line" >
    	     		<span class="chat-box">Let's talk about dogs!</span>
      			</div>
      			<div class="line">
        			<span class="chat-box mine"> sure>_< </span>
      			</div>
    		</div>
    		<div class="chat-bottom-wrap1-2">
  		  		<input class="input-box" name = "please" id="input" value="${askanything}" />
   				<button id="send"><img src="4_service/img/sendbtn.svg" alt="Send Button"></button>
    		</div>
    	</div>
    </div>
</div>

</body>
