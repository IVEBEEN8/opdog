function modifyPost(accountNo, aNo, vNo) {
  if (accountNo != aNo) {
    alert("you can't modify the article");
  } else {
    location.href = "VolunteerModiC?no=" + vNo;
  }
}
function deletePost(accountNo, aNo, n, locate) {
  if (accountNo != aNo) {
    alert("you can't delete the article");
  } else {
    let ok = confirm("Are you sure you want to delete?");
    if (ok) {
      location.href = "VolunteerDelC?no=" + n + "&locate=" + locate;
    }
  }
}

console.log("ready to call");
document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("btn").addEventListener("click", function () {
    var selectedValue = $(this).val();
    var san = selectedValue.split("!");
    var accountNo1 = san[0];
    var vNo = san[1];
    var vStatus = san[2];
    var vTitle = san[3];
    var vCreated = san[4];
    var vImg = san[5];
    var vTxt = san[6];
    var aEmail = san[7];
    vTxt = vTxt.replaceAll("\r\n", "<br>");
    var formData = new FormData();
    formData.append("accountNo1", accountNo1);
    formData.append("vNo", vNo);
    formData.append("vStatus", vStatus);
    formData.append("vTitle", vTitle);
    formData.append("vCreated", vCreated);
    formData.append("vImg", vImg);
    formData.append("vTxt", vTxt);
    formData.append("aEmail", aEmail);
    console.log(san);
    // Check if the user is logged in
    if (accountNo1 !== "") {
      Swal.fire({
        icon: "success",
        title:
          "Application Success - The shelter will contact you individually",
        showConfirmButton: false,
        timer: 1500,
        didClose: () => {
          var goMypage = confirm("Do you want to check MyPage?");
          if (goMypage) {
            console.log("gotomypage!!");
            location.href = "MyPageHC";
          } else {
            location.href = "VolunteerDetailC?no=" + vNo;
          }
        },
      });
      $.ajax({
        type: "POST",
        url: "ApplyVolC",
        data: formData,
        contentType: false,
        processData: false,
        success: function () {
          console.log("FormData contents:");
          for (var pair of formData.entries()) {
            console.log(pair[0] + ": " + pair[1]);
          }
          console.log("데이터 전송 성공!");
        },
        error: function () {
          console.log("데이터 전송 실패!");
        },
      });
    } else {
      // User is not logged in, redirect to "LoginMainHC"
      var goLogin1 = confirm("You must login first.\nDo you want to login?");
      if (goLogin1) {
        window.location.href = "LoginMainHC";
      } else {
        location.href = "VolunteerDetailC?no=" + vNo;
      }
    }
  });
});

document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("regVol").addEventListener("click", function () {
        var selectedValue = this.value;
        var dsv = selectedValue.split("!");
        var locate = dsv[0];
        var accountNo = dsv[1];

        // 사용자가 로그인했는지 확인
        if (accountNo !== "") {
           window.location.href= 'VtWriteC?locate=' + locate
            
        } else {
            // 사용자가 로그인하지 않았을 경우 "LoginMainHC"로 리디렉션
            var goLogin = confirm('먼저 로그인해야 합니다.\n로그인하시겠습니까?');
            if (goLogin) {
                window.location.href = 'LoginMainHC';
            }
        }
    });
});

function getPost(status) {
  let search = $('input[name="searchTitle"]').val();
  let locate = $("#locate").text();
  $.ajax({
    url: "VolunteerAPI",
    data: { search, status, locate },
    datatype: "json",
  }).done(function (json) {
    console.log(json);
    paging(json);
  });
}
function paging(json){
	$('#pagination-container').pagination({
		dataSource: json,
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
}

$(document).ready(function () {
  console.log("I am ready!!");
  getPost("");

  $("input[name='searchTitle']").keyup(function (e) {
    getPost("");
  });

  $("button[name='searchBtn']").click(function () {
    let status = $(this).val();
    console.log(status);
    getPost(status);
  });
});
