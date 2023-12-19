$(document).ready(function(){
	$('button[id="change"]').on("click",function(){
		var oldpw = $('input[name="oldPW"]').val();		
		var oldpwch = $('input[name="oldPWCheck"]').val();
		var newpw = $('input[name="newPW"]').val();
		var newpwch = $('input[name="newPWCheck"]').val();
		var id = $('input[name="email"]').val();
		var fn = $('input[name="firstName"]').val();
		var ln = $('input[name="lastName"]').val();
		if(id==""||fn==""||ln==""||oldpwch==""){
			alert('essential element is unfilled');
		} else {
			if(oldpw != oldpwch){
				alert('check your password');
			} else{
				if(newpw != ""){
					if(newpw != newpwch){
						alert('check your new password');
					} else{
						$.ajax({
							url: '../../UpdateInfoC',
							type: 'POST',
							data: { newpw, id, fn, ln},
							success: function(){
								alert('회원정보 변경이 완료되었습니다.');
								location.href="../../LoginMainHC";
							},
							error: function(error) {
                				console.log('Ajax 요청 에러:', error);
            				}
						});
					}
				} else{
					$.ajax({
						url: '../../UpdateInfoC',
						type: 'POST',
						data: {id, fn, ln},
						success: function(){
							alert('회원정보 변경이 완료되었습니다.');
							location.href="../../MyPageHC"
						},
						error: function(error) {
                			console.log('Ajax 요청 에러:', error);
            			}
					});
				}
			}
		}
	});
	
	
	
	
});