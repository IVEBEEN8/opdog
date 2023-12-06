<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td><a href="GetCenterInfoC">GetCenterInfo</a></td>
		</tr>
		<tr>
			<td colspan="8" align="center">
				<table>
					<tr>
						<td><jsp:include page = "${contentPage }"></jsp:include></td>
					</tr>
				</table>
			 </td>
		</tr>
	</table>


</body>
</html>