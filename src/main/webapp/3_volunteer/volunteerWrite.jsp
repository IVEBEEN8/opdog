<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="3_volunteer/css/volunteerWrite.css" />
<script src="3_volunteer/js/volunteerReg.js"></script>
</head>
<body>
	<form action="VtWriteC" method="post" enctype="multipart/form-data"
		onsubmit="return checkForm();">
		<main>
			<div class="main">
				<!-- 제목 삭제 -->
				<!-- <div class="main-title">Recruiting Volunteer</div> -->
				<div class="container">
					<div class="sub-container">
						<div>
							<div class="review-title">Status</div>
							<select class="chooseStatus" name="chooseStatus">
								<option class="" value="Recruiting">Recruiting</option>
							</select>
						</div>


						<div class="review-title-cover">
							<div class="review-title">Title</div>
							<div>
								<input class="input-title" id="title" name="title"
									placeholder="Please enter the title">
							</div>
						</div>

						<div>
							<div class="review-title">Text</div>
							<textarea class="input-story" id="txt" name="content" cols="30"
								rows="10" placeholder="Please enter your details"
								oninput="checkLength()"></textarea>
							<div id="charCount"></div>
						</div>
						<div>
							<div class="review-img-cover">
								<div class="review-title">Photo</div>
								<div class="select-btn-cover">
									<input id="fileInput" type="file" name="file"
										value="Select File" style="display: none"
										oninput="previewSelectedImage(this)">
									<button class="select-btn" type="button"
										onclick="document.getElementById('fileInput').click();">Select
										File</button>
								</div>
								<div class="preview-img-cover" style="display: none;">
									<img class="preview-img" id="previewImage" src="#"
										alt="Preview">
								</div>
							</div>
						</div>



						<div class="review-btn">
							<button class="review-reg-btn" type='submit'>add</button>
						</div>
					</div>
				</div>
			</div>

			<!-- 혜진 -->
			<!-- <table id="vTbl">
				<tr>
					<td class="write-td">Status</td>
					<td><select name="chooseStatus">
							<option value="Recruiting">Recruiting</option>
					</select></td>
				</tr>
				<tr>
				<tr>
					<td class="write-td">title</td>
					<td><input class="input-style" name="title"
						placeholder="Please enter the subject" /></td>
				</tr>
				<tr>
					<td class="write-td">img</td>
					<td><input class="input-style" name="file" type="file" /></td>
				</tr>
				<tr>
					<td class="write-td">content</td>
					<td><textarea class="textarea-style" name="content"
							placeholder="Please enter your details"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" class="write-td">
						<button type='submit'>add</button>
					</td>
				</tr>
			</table> -->
		</main>
	</form>
</body>
</html>