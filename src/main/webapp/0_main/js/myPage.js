$(document).ready(function() {
	$(document).on("click", "button[id=cancel]", function() {
		var desertionNo = $(this).val();
		var button = $(this)
		console.log(desertionNo);
		if (confirm("취소하시겠습니까?")) {
			$.ajax({
				url: "DelLikeC",
				type: "GET",
				data: { value: desertionNo },
				success: function(response) {
					$('button[value=' + desertionNo + ']').parent().remove();
				},
			})
		} else {
			return false;
		}

	});
});

function myPageButton() {
	innerPageOff()
	$('#infoPage').css({ "display": "block" })
	buttonCss()
	$('.b1').css({ "background-color": "rgba(67, 49, 28, 0.1)" })

}

function likeButton() {
	innerPageOff()
	$('#likePage').css({ "display": "block" })
	buttonCss()
	$('.b2').css({ "background-color": "rgba(67, 49, 28, 0.1)" })
}

function pointButton() {
	innerPageOff()
	$('#pointPage').css({ "display": "block" })
	buttonCss()
	$('.b3').css({ "background-color": "rgba(67, 49, 28, 0.1)" })
}
function volunteerButton() {
	innerPageOff()
	$('#volunteerPage').css({ "display": "block" })
	buttonCss()
	$('.b4').css({ "background-color": "rgba(67, 49, 28, 0.1)" })
}
function innerPageOff() {
	$('#infoPage').css({ "display": "none" })
	$('#likePage').css({ "display": "none" })
	$('#pointPage').css({ "display": "none" })
	$('#volunteerPage').css({ "display": "none" })
}

function buttonCss() {
	$('.button').css({ "background-color": "transparent" })

}
console.log("hello?");

