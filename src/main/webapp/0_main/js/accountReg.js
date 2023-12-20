$(document).ready(function() {
	
    $('#sidoSelect').on('change', function() {
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

   
	
	
	
	
	
	})