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
<!-- 
${sido} = 광역시 배열
.orgCd = 도시 코드
.orgdownNm = 도시 이름
 -->
<!-- container div -->
<div class="#">
	<!-- radiobox div -->
	<div class="#">
		<div class="#"><!-- 시/도 radiobox -->
			<div class="#">시/도</div>
			<div class="#">
				<label id="sidolabel"><input type="radio" value="" checked="checked" name="sido" id="sidord">시/도 선택</label>	  
				<c:forEach var="sido" items="${sido }" >
					<label id="sidolabel"><input type="radio" value="${sido.orgCd }" name="sido" id="sidord">${sido.orgdownNm }</label>	
				</c:forEach>
			</div>
		</div>
		<div class="#"><!-- 시/군/구 radiobox -->
			<div class="#">시/군/구</div>
			<div class="#" id="sigungudiv">
				<label id="sigungulable"><input type="radio" value="" name="sigungu" checked="checked" id="sigungurd">시/군/구 선택</label>	
			</div>
		</div>
		<div class="#"><!-- 보호소 radiobox -->
			<div class="#">보호소</div>
			<div class="#" id="centerdiv">
				<label ><input type="radio" value="" name="center" checked="checked" id="centerrd">보호소 선택</label>	
			</div>
		</div>
		<button class="#" id="radiobutton">버튼</button>
	</div>
	<br>
	<!-- selectbox div --> 
	<div class="#">
        <select name="sido" id="sidoSelect">
        		<option value="">시/도 선택</option>
        		<c:forEach var="sido" items="${sido }" >
        			<option value="${sido.orgCd }">${sido.orgdownNm }</option>
        		</c:forEach>
        </select>
        <select name="sigun" id="sigunSelect">
        	<option value="">시/군/구 선택</option>
        </select>
        <select name="center" id="centerSelect">
        	<option value="" >보호소 선택</option>
        </select>
        <button id="selectbutton">버튼</button>
        <button id="length">test</button>
	</div>
	<!-- 애견정보 div -->
	<div class="#">
		<div>강아지 정보</div>
		<div class="#" id="dogs">
			<div class="#" id="dog"> <img alt="" src=""> kind: age: sex: neuter: </div><!-- test div -->
		</div>
		<button >이전</button>
		<button>다음</button>
	</div>
</div>
        
        
       	

        

        
   
</body>
    
</html>