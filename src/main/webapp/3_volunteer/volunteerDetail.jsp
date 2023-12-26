<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="VtDetailC" method="post" enctype="multipart/form-data">
		<main>
			<table id="vTbl">
				<tr>
					<td class="write-td">Status</td>
					<td>${volunteer.v_status }</td>
				</tr>
				<tr>
				<tr>
					<td class="write-td">title</td>
					<td>${volunteer.v_title }</td>
				</tr>
				<tr>
					<td><img src="3_volunteer/newImg/${volunteer.v_img }"></td>
				</tr>
				<tr>
					<td class="write-td">content</td>
					<td>${volunteer.v_txt }</td>
				</tr>
				<tr>
					<td colspan="2" class="write-td">
						<button>Go list</button>
					</td>
				</tr>
			</table>
		</main>
	</form>
</body>
</html>