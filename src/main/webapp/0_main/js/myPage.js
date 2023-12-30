$(document).ready(function(){
	
	
	
	
});

function myPageButton(){
	$('#infoPage').css({"display":"block"})
	$('#likePage').css({"display":"none"})
	$('#pointPage').css({"display":"none"})
	$('#volunteerPage').css({"display":"none"})
}

function likeButton(){
	$('#infoPage').css({"display":"none"})
	$('#likePage').css({"display":"block"})
	$('#pointPage').css({"display":"none"})
	$('#volunteerPage').css({"display":"none"})
}

function pointButton(){
	$('#infoPage').css({"display":"none"})
	$('#likePage').css({"display":"none"})
	$('#pointPage').css({"display":"block"})
	$('#volunteerPage').css({"display":"none"})
}
function volunteerButton(){
	$('#infoPage').css({"display":"none"})
	$('#likePage').css({"display":"none"})
	$('#pointPage').css({"display":"none"})
	$('#volunteerPage').css({"display":"block"})
}