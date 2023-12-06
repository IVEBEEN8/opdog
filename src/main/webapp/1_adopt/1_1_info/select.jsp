<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script src="1_adopt/js/select.js"></script>
</head>
<body>
	<form action="selectC">
        <select name="sido" id="sido">
        		<option value="">시/도 선택</option>
        		<c:forEach var="sido" items="${sido }" >
        			<option value="${sido.orgCd }">${sido.orgdownNm }</option>
        		</c:forEach>
        </select>
        <select name="sigun" id="sigun">
        	<option value="">시/군/구 선택</option>
        </select>
        <select name="center" id="center">
        	<option value="" >보호소 선택</option>
        </select>
        <select>
        	<option>품종 선택</option>
        	<c:forEach var="kind" items=""></c:forEach>
        </select>
        
       	

        

        
    </form>
</body>
    
</html>