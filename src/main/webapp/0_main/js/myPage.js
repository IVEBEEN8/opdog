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

