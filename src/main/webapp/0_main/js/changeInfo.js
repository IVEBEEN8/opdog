$(document).ready(function(){

	
	$('button[id="change"]').on("click",function(){
		var oldpw = $('input[name="oldPW"]').val();		
		var oldpwch = $('input[name="oldPWCheck"]').val();
		var newpw = $('input[name="newPW"]').val();
		var newpwch = $('input[name="newPWCheck"]').val();
		var id = $('input[name="email"]').val();
		var fn = $('input[name="firstName"]').val();
		var ln = $('input[name="lastName"]').val();
		var uprCd = $('input[id="sido"]').val();
		var orgCd = $('input[id="sigun"]').val();
		if(id==""||fn==""||ln==""||oldpwch==""||uperCd==""||orgCd==""){
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
							data: { newpw, id, fn, ln, uprCd, orgCd},
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
						data: {id, fn, ln, uprCd, orgCd},
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
	
	$('select[id="sidoSelect"]').on('change', function() {
	/*
		response = 시/군/구 배열
		.orgCd = 도시 코드
		.orgdownNm = 도시 이름
		
	 */
        var selectedValue = $(this).val();
		console.log(selectedValue)
	//	$('input[type=radio][name="sido"][value="'+selectedValue+'"]').prop('checked',true);
		
		if(selectedValue !=""){
			console.log(11);
	        $.ajax({
    	        url: 'SelectConditionC' ,
        	    type: 'GET',
            	data: { value: selectedValue },
	            success: function(response) {
		alert(11);
					console.log(response);
					//$('label').remove('#sigungulabel');
					//$('label').remove('#centerlabel');
					$('option').remove('#sigunop');
					//$('option').remove('#centerop');
					if (selectedValue==5690000) {
						//$('#sigungudiv').append('<label id="sigungulabel"><input type="radio" value="'+selectedValue+'!'+selectedValue+'" name="sigungu" id="sigungurd">세종특별자치시</label>');
						$('#sigunSelect').append('<option value="'+selectedValue+'!'+selectedValue+'" id="sigunop">세종특별자치시</option>');
					}else {
						for (var i = 0; i < response.length; i++) {
							//$('#sigungudiv').append('<label id="sigungulabel"><input type="radio" value="'+selectedValue+'!'+response[i].orgCd+'" name="sigungu" id="sigungurd">'+response[i].orgdownNm+'</label>')
							$('#sigunSelect').append('<option value="'+selectedValue+'!'+response[i].orgCd+'" id="sigunop">'+response[i].orgdownNm+'</option>');
						}
					}
            	},
            	error: function(error) {
	                console.log('Ajax 요청 에러:', error);
    	        }
        	});
		} else{
			//$('label').remove('#sigungulabel');
			//$('label').remove('#centerlabel');
			$('option').remove('#sigunop');
			//$('option').remove('#centerop');
		};
    });
	
	
	
});
$(window).on('load',function(){
	var uprCd = $('#defaultUpr').val();
	var orgCd = $('#defaultOrg').val();
	console.log(uprCd);
	//$('input[name="sigungu"][value="'+ orgCd+'"]').click();
	$('#sidoSelect').val(''+uprCd+'').trigger('change');
	$('#sigunSelect').val(''+orgCd+'');
});

