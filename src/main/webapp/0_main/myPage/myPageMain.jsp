<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>mypageです〜</h1>
<div>info</div>
<div>ID: ${account.email }</div>
<div>First Name: ${account.firstname }</div>
<div>Last Name: ${account.lastname }</div>
<div>PW: ********</div>
<button onclick="location.href='0_main/myPage/changeInfo.jsp'">change</button>

<div>my booked dog</div>
<c:forEach var="list" items="${list }" varStatus="status">
	<div>나이: ${list.age } 품종: ${list.kind } 성별: ${list.sex } 중성화: ${list.neuter }</div> <button id="detail" value="${status.count }">상세보기</button>
</c:forEach>






<%-- <c:forEach var="list" items="${list }">
 <div id="modalWrap">
    <div id="modalBody">
      <span id="closeBtn">&times;</span>
    </div>
</div> 
</c:forEach> --%>

</body>
</html>