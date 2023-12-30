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
  <script src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script>
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css"/>
	<style type="text/css">
	ul{
	list-style: none;}
	</style>
   <link rel="stylesheet" href="1_adopt/css/modal.css"/>
   <link rel="stylesheet" href="1_adopt/css/select.css">
</head>
<body>
<!-- 동적으로 추가될 div, optioin, radiobox, button 등의 태그는 js에서 .html,.append로 태그 채로 생성되기 때문에 js에서 class부여 가능 -->
<!-- 
${sido} = 광역시 배열
.orgCd = 도시 코드
.orgdownNm = 도시 이름
 -->
<!-- container div -->
<div class="infocontainer">
	<!-- radiobox div -->
	<div class="radiocontainer">
		<div class="titlebox"> <p>stary dog</p></div>
		<div class="sidoradiobox"><!-- 시/도 radiobox -->
			<!-- <div class="#">시/도</div> -->
			<input type="hidden" value="${uprCd }" id="defaultUpr">
			<input type="hidden" value="${orgCd }" id="defaultOrg">
			<div class="#">
				<label id="sidolabel"><input type="radio" value="" checked="checked" name="sido" id="sidord">state</label>	  
				<c:forEach var="sido" items="${sido }" >
					<label id="sidolabel"><input type="radio" value="${sido.orgCd }" name="sido" id="sidord">${sido.orgdownNm }</label>	
				</c:forEach>
			</div>
		</div>
		<div class="sigunradiobox"><!-- 시/군/구 radiobox -->
			<div class="#">시/군/구</div>
			<div class="#" id="sigungudiv">
				<label id="sigungulable"><input type="radio" value="" name="sigungu" checked="checked" id="sigungurd">city</label>	
			</div>
		</div>
		<div class="shelterradiobox"><!-- 보호소 radiobox -->
			<div class="#">보호소</div>
			<div class="#" id="centerdiv">
				<label ><input type="radio" value="" name="center" checked="checked" id="centerrd">shelter</label>	
			</div>
		</div>
		<button class="#" id="radiobutton">버튼</button>
	</div>
	<br>
	<!-- selectbox div --> 
	<div class="selectcontainer">
        <select name="sido" id="sidoSelect">
        		<option value="">state</option>
        		<c:forEach var="sido" items="${sido }" >
        			<option value="${sido.orgCd }">${sido.orgdownNm }</option>
        		</c:forEach>
        </select>
        <select name="sigun" id="sigunSelect">
        	<option value="">city</option>
        </select>
        <select name="center" id="centerSelect">
        	<option value="" >shelter</option>
        </select>
        <button id="selectbutton">버튼</button>
	</div>
	<!-- 애견정보 div -->
	<div class="infoouter">
		<div> <p style="display:none;" id="account">${account.no }</p></div>			
		<div id="data-container" class="datacontainer"></div><!-- 강아지 정보 리스트 -->
		<div id="pagination" class="pagination"></div><!-- 페이지 -->	
		
	</div>
</div>

 <div id="modalWrap">
    <div id="modalBody">
      <span id="closeBtn">&times;</span>
    </div>
</div>       
<p style="">
        
       	

        

        
   
</body>
    
</html>