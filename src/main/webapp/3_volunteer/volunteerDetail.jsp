<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="3_volunteer/css/volunteerDetail.css" />
</head>
<body>
	<form action="VolunteerDetailC" method="post" enctype="multipart/form-data">
		<main>
			<table id="DetailTbl">
				<tr>
					<td class="write-td">Status</td>
					<td>${vol.v_status }</td>
				</tr>
				<tr>
				<tr>
					<td class="write-td">title</td>
					<td>${vol.v_title }</td>
				</tr>
				<tr>
					<td><img src="3_volunteer/newImg/${vol.v_img }"></td>
				</tr>
				<tr>
					<td class="write-td">content</td>
					<td>${vol.v_txt }</td>
				</tr>
				<tr>
					<td colspan="2" class="write-td">
						<button>Go list</button>
					</td>
				</tr>
			</table>
		</main>
	</form>


<%-- <h1>this is detail page~</h1>
<p>${vol.v_title }</p>
<p>${vol.v_img }</p>
<p>${vol.v_created }</p>
<p>${vol.v_updated }</p>
<p>${vol.v_status }</p>
--%>

</body>
</html>