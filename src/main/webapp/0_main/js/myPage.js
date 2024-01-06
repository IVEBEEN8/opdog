$(document).ready(function(){




});

function myPageButton(){
    innerPageOff()
    $('#infoPage').css({"display":"block"})
    buttonCss()
    $('.b1').css({"background-color":"rgba(67, 49, 28, 0.1)"})

}

function likeButton(){
    innerPageOff()
    $('#likePage').css({"display":"block"})
    buttonCss()
    $('.b2').css({"background-color":"rgba(67, 49, 28, 0.1)"})
}

function pointButton(){
    innerPageOff()
    $('#pointPage').css({"display":"block"})
    buttonCss()
    $('.b3').css({"background-color":"rgba(67, 49, 28, 0.1)"})
}
function volunteerButton(){
    innerPageOff()
    $('#volunteerPage').css({"display":"block"})
    buttonCss()
    $('.b4').css({"background-color":"rgba(67, 49, 28, 0.1)"})
}
function innerPageOff(){
    $('#infoPage').css({"display":"none"})
    $('#likePage').css({"display":"none"})
    $('#pointPage').css({"display":"none"})
    $('#volunteerPage').css({"display":"none"})
}

function buttonCss(){
    $('.button').css({"background-color":"transparent"})

}
