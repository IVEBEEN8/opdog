$(document).ready(function() {
	$(document).on("click", "button[id=cancel]", function() {
		var desertionNo = $(this).val();
		var button = $(this);
		console.log(desertionNo);
		if (confirm("취소하시겠습니까?")) {
			$.ajax({
				url: "DelLikeC",
				type: "GET",
				data: { value: desertionNo },
				success: function(response) {
					$("button[value=" + desertionNo + "]").parent().parent().remove();
				},
			});
		} else {
			return false;
		}
	});
});


/*function paging(json){
	console.log("hello?");
	$('#pagination-container').pagination({
		dataSource: json,
		pageSize: 4,
		callback: function(data, pagination){
			console.log("hs:"+data);
			console.log(data[0]);
			var dataHtml ='';
			$.each(data, function (index, list){
				dataHtml += '<div class="likecontent-wrapper">' + list.d_thunbnail + '">';
                dataHtml += '<div class="likecontent">';
				dataHtml += '<div><p>Age</p>'+list.d_age +'</div>'; 
				dataHtml += '<div><p>Kind</p>'+list.d_kind + '</div>';
				dataHtml += '<div><p>Gender</p>'+list.d_sex+ '</div>';
				dataHtml += '<div><p>Neuter</p>'+list.d_neuter+ '</div>';
				dataHtml += '</div><div class="btn-wrapper">';
				dataHtml += '<button class="like-btn" id="cancel" value="'+list.d_no+'">Cancel</button></div></div>';
			})
			$('#likeList').html(dataHtml);
		}	
	})

}
$(document).ready(function(){
	paging(json);
}); */





function myPageButton() {
	innerPageOff();
	$("#infoPage").css({ display: "block" });
	buttonCss();
	$(".b1").css({ "background-color": "rgba(67, 49, 28, 0.1)" });
}

function likeButton() {
	innerPageOff();
	$("#likePage").css({ display: "block" });
	buttonCss();
	$(".b2").css({ "background-color": "rgba(67, 49, 28, 0.1)" });
}

function pointButton() {
	innerPageOff();
	$("#pointPage").css({ display: "block" });
	buttonCss();
	$(".b3").css({ "background-color": "rgba(67, 49, 28, 0.1)" });

	// 카운트를 표시할 요소
	const $counter = document.querySelector(".nowPoint");

	// 목표수치
	const max = $("#max").val();
	const gageMax = max / 50000 * 100
	$(".pointMove").css({ "width": gageMax + "%" })
	let animation = document.styleSheets[5].cssRules[56];
	console.log(animation);
	animation.appendRule('to{width:'+gageMax+'%}')

	counter($counter, max);
}
function volunteerButton() {
	innerPageOff();
	$("#volunteerPage").css({ display: "block" });
	buttonCss();
	$(".b4").css({ "background-color": "rgba(67, 49, 28, 0.1)" });
}
function innerPageOff() {
	$("#infoPage").css({ display: "none" });
	$("#likePage").css({ display: "none" });
	$("#pointPage").css({ display: "none" });
	$("#volunteerPage").css({ display: "none" });
}

function buttonCss() {
	$(".button").css({ "background-color": "transparent" });
}

function counter($counter, max) {
	let now = max;

	const handle = setInterval(() => {
		$counter.innerHTML = Math.ceil(max - now);

		// 목표에 도달하면 정지
		if (now < 1) {
			clearInterval(handle);
		}

		// 적용될 수치, 점점 줄어듬
		const step = now / 10;

		now -= step;
	}, 50);
}

