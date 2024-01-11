$(document).ready(function(){
	$('button[id="change"]').on("click",function(){
		console.log("btn clicked");
		var oldpw = $('input[name="oldPW"]').val();		
		var oldpwch = $('input[name="oldPWCheck"]').val();
		var newpw = $('input[name="newPW"]').val();
		var newpwch = $('input[name="newPWCheck"]').val();
		var id = $('input[name="email"]').val();
		console.log(id);
		var fn = $('input[name="firstName"]').val();
		console.log(fn);
		var ln = $('input[name="lastName"]').val();
		console.log(ln);
		var uprCd = $('input[id="sido"]').val();
		var orgCd = $('input[id="sigun"]').val();
		if(id==""||fn==""||ln==""||oldpwch==""||uprCd==""||orgCd==""){
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
							url: 'UpdateInfoC',
							type: 'POST',
							data: { newpw, id, fn, ln, uprCd, orgCd},
							success: function(){
								alert('회원정보 변경이 완료되었습니다');
								location.href="LoginMainHC";
							},
							error: function(error) {
                				console.log('Ajax 요청 에러:', error);
            				}
						});
					}
				} else{
					$.ajax({
						url: 'UpdateInfoC',
						type: 'POST',
						data: {id, fn, ln, uprCd, orgCd},
						success: function(){
							alert('회원정보 변경이 완료되었습니다.');
							location.href="MyPageHC"
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
        var selectedValue = $(this).val();
		console.log(selectedValue)
		
		if(selectedValue !=""){
			console.log(11);
	        $.ajax({
    	        url: 'SelectConditionC' ,
        	    type: 'GET',
            	data: { value: selectedValue },
	            success: function(response) {
					console.log(response);
					$('option').remove('#sigunop');
					if (selectedValue==5690000) {
						$('#sigunSelect').append('<option value="'+selectedValue+'!'+selectedValue+'" id="sigunop">세종특별자치시</option>');
					}else {
						for (var i = 0; i < response.length; i++) {
							$('#sigunSelect').append('<option value="'+selectedValue+'!'+response[i].orgCd+'" id="sigunop">'+response[i].orgdownNm+'</option>');
						}
					}
            	},
            	error: function(error) {
	                console.log('Ajax 요청 에러:', error);
    	        }
        	});
		} else{
			$('option').remove('#sigunop');
		};
    });
	
	
	
});
$(window).on('load',function(){
	var uprCd = $('#defaultUpr').val();
	var orgCd = $('#defaultOrg').val();

	
	console.log(uprCd);
	//$('input[name="sigungu"][value="'+ orgCd+'"]').click();
	$('#sidoSelect').val(''+uprCd+'').trigger('change');
	if(uprCd !=""){
			console.log(22);
	        $.ajax({
    	        url: 'SelectConditionC' ,
        	    type: 'GET',
            	data: { value: uprCd },
	            success: function(response) {
					console.log(response);
					$('option').remove('#sigunop');
					if (uprCd==5690000) {
						$('#sigunSelect').append('<option value="'+uprCd+'!'+uprCd+'" id="sigunop">세종특별자치시</option>');
					}else {
						for (var i = 0; i < response.length; i++) {
							$('#sigunSelect').append('<option value="'+uprCd+'!'+response[i].orgCd+'" id="sigunop">'+response[i].orgdownNm+'</option>');
						}
					}
					$('#sigunSelect').val(''+orgCd+'')
            	},
            	error: function(error) {
	                console.log('Ajax 요청 에러:', error);
    	        }
        	});
		} else{
			$('option').remove('#sigunop');
		};
});

function openModal() {
  document.getElementById('myModal').style.display = 'block';
}
function closeModal() {
  document.getElementById('myModal').style.display = 'none';
}

window.addEventListener('click', function (event) {
  if (event.target === document.getElementById('myModal')) {
    document.getElementById('myModal').style.display = 'none';
  }
});


