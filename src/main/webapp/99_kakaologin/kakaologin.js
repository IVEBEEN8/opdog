	console.log("hi are you ready?");
$(document).ready(function(){

console.log("areyou there? ");
	const API_KEY = "cf95e7fad4ebbf7f5b751c535e5369bf";
	kakao.init(API_KEY);
	function kakaoLogin(){
		kakao.Auth.login({
			success: function(response){
				kaokao.API.request({
				url: 'KakaoLoginC',
				success : function(response){
					alert(JSON.stringify(responhse))	
				},
				fail: function (error){
					alert(JSON.stringify(error))
				},
 			})
		 },
			fail: function(error){
				alert(JSON.stringify(error))	 
			},
	  })
 	}
})
