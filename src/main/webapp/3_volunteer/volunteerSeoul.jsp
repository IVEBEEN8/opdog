<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>volunteerNotice</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,200;9..40,300;9..40,400;9..40,500;9..40,600;9..40,700&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Kaisei+Decol:wght@400;500;700&family=Poppins:wght@100;200;300;400;800;900&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="3_volunteer/css/volunteerNotice.css" />
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css" />

<script src="3_volunteer/js/volunteer.js"></script>
</head>
<body>
	<main>
		<div class="top">
			<div class="top-title">
				<img src="3_volunteer/img/SeoulIcon.png" alt="" /> <a
					href="VSeoulC">
					<p>Seoul</p>
				</a>
			</div>
			<div class="top-btn">
				<form action="VolBtnClickC">
					<button name="searchBtn" value="Recruiting" class="Recruiting">Recruiting</button>
					<button name="searchBtn" value="Completed" class="Completed">Completed</button>
				</form>
			</div>
			<form action="VolSearchSC" method="post">
				<div class="search">
					<img src="3_volunteer/img/SearchIcon.png" alt="돋보기" /> <input
						name="searchTitle"
						placeholder="Is there an article you are looking for?" onfocus="this.placeholder = ''" type="text" />
				</div>
			</form>
		</div>
		<div id="volList" class="volList"></div>
		<div class="bottom btn">
				<button id="regVol" value="${account.no}">Write</button>			
		</div>
		<div id="pagination-container" class="pagination-container">
		</div>
	</main>	
	
<script type="text/javascript">

$(document).ready(function (){
	console.log("I am ready!!");
	
	var dataSource = ${jsonVolunteer};
	console.log(dataSource);
	
	$('#pagination-container').pagination({
		dataSource: dataSource,
		pageSize: 5,
		callback: function(data, pagination){
			console.log(data);
			var dataHtml ='';
			$.each(data, function (index, item){
				dataHtml += '<a href="VolunteerDetailC?no=' + item.v_no + '">';
                dataHtml += '<table id="middle">';
                dataHtml += '<tr class="middle-post">';
                dataHtml += '<td class="post-left">';
                dataHtml += '<div class="td-wrapper">';
                dataHtml += '<div class="post-btn">';
                dataHtml += '<div class="Recruiting post-btn-txt">';
                dataHtml += '<p>' + item.v_status + '</p>';
                dataHtml += '</div>';
                dataHtml += '</div>';
                dataHtml += '<div class="post-text">';
                dataHtml += '<div class="bigTxt">' + item.v_title + '</div>';
                dataHtml += '<div class="smallTxt">' + item.v_txt + '</div>'; // 중괄호를 닫아주는 부분 수정
                dataHtml += '</div>';
                dataHtml += '<div class="post-info">';
                dataHtml += '<div class="post-user">';
                dataHtml += '<img src="3_volunteer/img/profileIcon.png" alt="" />' + item.a_email;
                dataHtml += '<div>|' + item.v_created + '</div>';
                dataHtml += '</div>';
                dataHtml += '</div>';
                dataHtml += '</div>';
                dataHtml += '</td>';
                dataHtml += '<td class="post-img">';
                dataHtml += '<img src="3_volunteer/newImg/' + item.v_img + '">';
                dataHtml += '</td>';
                dataHtml += '</tr>';
                dataHtml += '</table>';
                dataHtml += '</a>';
				
			})
			$('#volList').html(dataHtml);
		}
		
	})
	
	   
})
</script>
</body>
</html>
