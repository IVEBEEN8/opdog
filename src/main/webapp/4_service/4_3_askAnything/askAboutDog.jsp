<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="4_service/js/askAboutDog.js"></script>
<link rel="stylesheet" href="4_service/css/askAboutDog.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="chat-content">
      <div class="line">
        <span class="chat-box"></span>
      </div>
      <div class="line">
        <span class="chat-box mine"></span>
      </div>
    </div>
    <input class="chat-box" id="input" />
    <button id="send">전송</button>  
</body>
</html>