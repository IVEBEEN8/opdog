<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>

 </head>
<body>
<h1>hello kakao</h1>
<a id="test" href="javascropt:kakaoLogin()"><img src="kakao_login.png"></a>
</body>
<script>
console.log("hi are you ready?");
console.log("areyou there? ");
	function kakaoLogin(){
		console.log("33");
		const key = "cf95e7fad4ebbf7f5b751c535e5369bf"
		console.log(key);
		kakao.init(key);
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

</script>

</html>