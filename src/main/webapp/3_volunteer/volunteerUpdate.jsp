<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="3_volunteer/css/volunteerWrite.css" />
</head>
<body>
	<form action="VolunteerModiC" method="post"
		enctype="multipart/form-data">
		<main>
			<table id="vTbl">
				<tr>
					<td class="write-td">Status</td>
					<td><select name="chooseStatus">
							<option value="Recruiting">Recruiting</option>
							<option value="Completed">Completed</option>
					</select></td>
				</tr>
				<tr>
				<tr>
					<td class="write-td">title</td>
					<td><input class="input-style" name="title"
						value="${vol.v_title }"
						placeholder="Please enter the title to be modified" /></td>
				</tr>
				<tr>
					<td class="write-td">img</td>
					<td>-Current file-<input name="oldFile" value="${vol.v_img }" />
						<br> -Edit file-<input name="newFile" value="${vol.v_img }"
						type="file" />
					</td>
				</tr>
				<tr>
					<td class="write-td">content</td>
					<td><textarea class="textarea-style" name="content"
							placeholder="Please enter the information to be modified">${vol.v_txt }</textarea></td>
				</tr>
				<tr>
					<td colspan="2" class="write-td">
						<button name="no" value="${vol.v_no }">Modify</button>
					</td>
				</tr>
			</table>
		</main>
	</form>
</body>
</html>