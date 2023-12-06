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
<script type="text/javascript">
$(document).ready(function() {
    $('#sido').on('change', function() {
        var selectedValue = $(this).val();
        $.ajax({
            url: 'SelectConditionC', 
            type: 'GET', 
            data: { value: selectedValue },
            success: function(response) {
				if (selectedValue==5690000) {
					$('#sigun').append('<option value="" id="sigunop">세종특별자치시</option>');
				}else {
					for (var i = 0; i < response.length; i++) {
						$('#sigun').append('<option value="'+selectedValue+'!'+response[i].orgCd+'" id="sigunop">'+response[i].orgdownNm+'</option>');
					}
				}
            },
            error: function(error) {
                console.log('Ajax 요청 에러:', error);
            }
        });
    });

    $('#sigun').on('change', function() {
        var selectedValue = $(this).val();
       	console.log(selectedValue);

        
        $.ajax({
            url: 'SelectConditionC', 
            type: 'POST', 
            data: { value: selectedValue },
            success: function(response) {
            		console.log(response);
					for (var i = 0; i < response.length; i++) {
						$('#center').append('<option value="'+response[i].careRegNo+'" id="sigunop">'+response[i].careNm+'</option>');
					}
            },
            error: function(error) {
                console.log('Ajax 요청 에러:', error);
            }
        });
    });
});

</script>
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