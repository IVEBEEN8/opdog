var max2 = $('p[id="count"]').text();

$(function() {
	fullset();
	quickClick();
});

function fullset() {
	var pageindex = $("#fullpage > .fullsection").size(); //fullpage 안에 섹션이(.fullsection) 몇개인지 확인하기
	for (var i = 1; i <= pageindex; i++) {
		$("#fullpage > .quick > ul").append("<li></li>");
	}
	$("#fullpage .quick ul :first-child").addClass("on"); //일단 화면이 로드 되었을때는 퀵버튼에 1번째에 불이 들어오게
	//마우스 휠 이벤트
	var totalCount = $('p[id="count"]').text();
	$(window).bind("mousewheel", function(event) {
		var page = $(".quick ul li.on");
		//alert(page.index()+1);  // 현재 on 되어있는 페이지 번호
		if ($("body").find("#fullpage:animated").length >= 1) return false;
		//마우스 휠을 위로
		if (event.originalEvent.wheelDelta >= 0) {
			var before = page.index();
			if (page.index() >= 0)
				page.prev().addClass("on").siblings(".on").removeClass("on"); //퀵버튼옮기기
			var pagelength = 0;
			for (var i = 1; i < before; i++) {
				pagelength += $(".full" + i).height();
			}
			if (page.index() > 0) {
				//첫번째 페이지가 아닐때 (index는 0부터 시작임)
				page = page.index() - 1;
				$("#fullpage").animate({ top: -pagelength + "px" }, 1000, "swing");
				// alert(before);

				//페이지 인덱스에 따라 색상 변경
				if (before === 4) {
					$(".main_header").css("background", "rgba(28, 28, 28, 0.3)");
				} else if (before === 3) {
					$(".main_header").css("background", "rgba(255, 255, 255, 0.1)");
				} else if (before === 2) {
					$(".main_header").css("background", "rgba(28, 28, 28, 0.3)");
				} else {
					$(".main_header").css("background", "rgba(255, 255, 255, 0.1)");
				}

				//스크롤 아래에서 위로 올릴때 카운트 시작
				if (before === 4 || before === 3 || before === 2) {
					// 스크롤로 3번째 페이지로 이동할 때 카운터 시작
					const $counter = document.querySelector(".count");
					const max = totalCount;
					counter($counter, max);
				}
			} else {
				// alert("첫번째페이지 입니다₍ᐢ. ̫.ᐢ₎♡");
			}
		} else {
			// 마우스 휠을 아래로
			var nextPage = parseInt(page.index() + 1); //다음페이지번호
			var lastPageNum = parseInt($(".quick ul li").size()); //마지막 페이지번호
			// alert(page.index());
			//현재페이지번호 <= (마지막 페이지 번호 - 1)
			//이럴때 퀵버튼옮기기
			if (page.index() <= $(".quick ul li").size() - 1) {
				page.next().addClass("on").siblings(".on").removeClass("on");
			}

			if (nextPage < lastPageNum) {
				//마지막 페이지가 아닐때만 animate !
				var pagelength = 0;
				for (var i = 1; i < nextPage + 1; i++) {
					//총 페이지 길이 구하기
					//ex) 현재 1번페이지에서 2번페이지로 내려갈때는 1번페이지 길이 + 2번페이지 길이가 더해짐
					pagelength += $(".full" + i).height();
				}
				$("#fullpage").animate({ top: -pagelength + "px" }, 1000, "swing");
				//페이지 인덱스에 따라 색상 변경 (첫페이지 0부터 시작)
				if (nextPage === 1) {
					$(".main_header").css("background", "rgba(28, 28, 28, 0.3)");
				} else if (nextPage === 2) {
					$(".main_header").css("background", "rgba(255, 255, 255, 0.1)");
				} else if (nextPage === 3) {
					$(".main_header").css("background", "rgba(28, 28, 28, 0.3)");
				}
			} else {
				// 현재 마지막 페이지 일때는
				// alert("마지막 페이지 입니다!₍ᐢ. ̫.ᐢ₎♡");
			}
			if (page.index() === 1 || page.index() === 2 || page.index() === 3) {
				// 스크롤로 3번째 페이지로 이동할 때 카운터 시작
				const $counter = document.querySelector(".count");
				const max = totalCount;
				counter($counter, max);
			}
		}
	});

	$(window).resize(function() {
		//페이지가 100%이기때문에 브라우저가 resize 될때마다 스크롤 위치가 그대로 남아있는것을 방지하기 위해
		var resizeindex = $(".quick ul li.on").index() + 1;

		var pagelength = 0;
		for (var i = 1; i < resizeindex; i++) {
			//총 페이지 길이 구하기
			//ex) 현재 1번페이지에서 2번페이지로 내려갈때는 1번페이지 길이 + 2번페이지 길이가 더해짐
			pagelength += $(".full" + i).height();
		}

		$("#fullpage").animate({ top: -pagelength + "px" }, 0);
	});
}

// 사이드 퀵버튼 클릭 이동
function quickClick() {
	$(".quick li").click(function() {
		var totalCount = $('p[id="count"]').text();
		var gnbindex = $(this).index() + 1;
		var length = 0;
		for (var i = 1; i < gnbindex; i++) {
			length += $(".full" + i).height();
		}
		if ($("body").find("#fullpage:animated").length >= 1) return false;
		$(this).addClass("on").siblings("li").removeClass("on");

		$("#fullpage").animate({ top: -length + "px" }, 800, "swing");
		// 세 번째 페이지이면서 카운터 시작
		/*if (gnbindex === 3) {
		const $counter = document.querySelector(".count");
		 const max = totalCount;
			counter($counter, max);
		}*/

		//페이지 인덱스에 따라 색상 변경
		if (gnbindex === 2) {
			$(".main_header").css("background", "rgba(28, 28, 28, 0.3)");
		} else if (gnbindex === 3) {
			$(".main_header").css("background", "rgba(255, 255, 255, 0.1)");
			const $counter = document.querySelector(".count");
			counter($counter, max2);
		} else if (gnbindex === 4) {
			// 마지막 페이지에 대한 처리 추가
			$(".main_header").css("background", "rgba(28, 28, 28, 0.3)");
		} else if (gnbindex === 1) {
			$(".main_header").css("background", "rgba(255, 255, 255, 0.1)");
		}


		return false;
	});
}

//3번째 페이지 카운터 기능

function counter($counter, max) {
	let now = max;

	const handle = setInterval(() => {
		// 숫자를 3단위로 콤마로 끊어진 문자열로 변환하여 적용
		$counter.innerHTML = Math.ceil(max - now).toLocaleString();

		// 목표수치에 도달하면 정지
		if (now < 1) {
			clearInterval(handle);
		}

		// 증가되는 값이 계속하여 작아짐
		const step = now / 10;

		// 값을 적용시키면서 다음 차례에 영향을 끼침
		now -= step;
	}, 50);
};
$(document).ready(function() {
	$(".img-box").on("click", function() {
		var desertionNo = $(this).children('input').val();
		console.log(desertionNo);
		$.ajax({
			url: "MainDetailC",
			type: "GET",
			data: { desertionNo },
			success: function(items) {
				console.log(11)
				$("div").remove("#detailinfo");
				$("#modalBody").append(
					'<div class="modalWrap" id="detailinfo">' +
					'<div class="modalImg" id="detailinfo"><img src="' +
					items.popfile +
					'" style="width:300px;"></div>' +
					'<div class="modalInfoWrap" id="detailinfo">' +
					'<div class="modal-list" id="detailinfo"><p>Age</p>' +
					'<span class="spandesign">' +
					items.age +
					"</span>" +
					"</div>" +
					'<div class="modal-list" id="detailinfo"><p>Number</p>' +
					'<span class="spandesign">' +
					items.desertionNo +
					"</span>" +
					"</div>" +
					'<div class="modal-list" id="detailinfo"><p>Kind</p>' +
					'<span class="spandesign">' +
					items.kindCd +
					"</span>" +
					"</div>" +
					'<div class="modal-list" id="detailinfo"><p>Gender</p>' +
					'<span class="spandesign">' +
					items.sexCd +
					"</span>" +
					"</div>" +
					'<div class="modal-list" id="detailinfo"><p>Neutering</p>' +
					'<span class="spandesign">' +
					items.neuterYn +
					"</span>" +
					"</div>" +
					'<div class="Shelter" id="detailinfo"><p>Shelter</p>' +
					'<span class="spandesign2">' +
					items.careNm +
					"(" +
					items.careTel +
					")" +
					items.careAddr +
					"</span>" +
					"</div>" +
					'<div class="agency" id="detailinfo"><p>agency</p>' +
					'<span class="spandesign2">' +
					items.orgNm +
					"&nbsp;" +
					items.chargeNm +
					"(" +
					items.officeTel +
					")" +
					"</span>" +
					"</div>" +
					'<div class="mainLikebtn" id="detailinfo"><button id="like" ><p style="display:none;">' +
					JSON.stringify(items) +
					'</p>Like</button><button id="liketrigger">spon</button>' +
					"</div>" +
					"</div>" +
					"<input id='detailinfo' name='desertionNo' type='hidden' value='" + items.desertionNo + "'>"
				);
				$("#modalWrap").css({ display: "block" });
			}
		})
	})

	$(document).on("click", "span[id=closeBtn]", function() {
		$("#modalWrap").css({
			display: "none",
		});
	});
	$(window).on("click", function(event) {
		if ($(event.target).is("#modalWrap")) {
			$("#modalWrap").css({
				display: "none",
			});
		}
	});
	$(document).on("click", "button[id=like]", function() {
		var selectedValue = $(this).children().text();
		var id = $("#account").text();

		if (id != "") {
			$.ajax({
				url: "MyPageLikeC",
				type: "GET",
				data: { value: selectedValue },
				success: function(response) {
					alert(response);
				},
				error: function(error) {
					console.log("Ajax 요청 에러:", error);
				},
			});
		} else {
			let goLogin = confirm(
				"로그인이 필요한 메뉴입니다.\n로그인하러 가시겠습니까?"
			);
			if (goLogin) {
				location.href = "LoginMainHC";
			}
		}
	});

	$(document).on("click", "button[id=liketrigger]", function() {
		var id = $("#account").text();
		if (id != "") {
			$.ajax({
				url: "SupportPetC",
				type: "GET",
				success: function(response) {
					$("div[id=totalPoint]").html("My point: " + response + " point");
					$("#pointWrap").css({ display: "block" });
				}
			})
		} else {
			let goLogin = confirm(
				"로그인이 필요한 메뉴입니다.\n로그인하러 가시겠습니까?"
			);
			if (goLogin) {
				location.href = "LoginMainHC";
			}
		}
	})

	$(document).on("click", "button[id=doSupport]", function() {
		var desertionNo = $("input[name=desertionNo]").val();
		var point = $("input[name=point]").val();
		console.log(point)
		$.ajax({
			url: "SupportPetC",
			type: "POST",
			data: { value: desertionNo, value2: point },
			success: function(response) {
				alert(point + "포인트가 기부 완료되었습니다.");
				$("input[name=point]").val(0);
				$("#pointWrap").css({ display: "none" });
			}
		})

	})

	$(document).on("click", "span[id=pointClose]", function() {
		$("#pointWrap").css({
			display: "none",
		});
	});

	$(window).on("click", function(event) {
		if ($(event.target).is("#pointWrap")) {
			$("#pointWrap").css({
				display: "none",
			});
		}
	});
})