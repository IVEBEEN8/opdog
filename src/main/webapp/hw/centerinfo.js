$(document).ready(function() {
	
    $('input[type=radio][name="sido"]').on("change",function() {
	/*
		response = 시/군/구 배열
		.orgCd = 도시 코드
		.orgdownNm = 도시 이름
	 */
        var selectedValue = $(this).val();
		if(selectedValue !=""){
        	$.ajax({
            	url: 'SelectConditionC', 
    	        type: 'GET', 
        	    data: { value: selectedValue },
            	success: function(response) {
					$('label').remove('#sigungulabel');
					if (selectedValue==5690000) {
						$('#sigungudiv').append('<label id="sigungulabel"><input type="radio" value="'+selectedValue+'!'+selectedValue+'" name="sigungu" id="sigunguradio">세종특별자치시</label>');
					}else {
						for (var i = 0; i < response.length; i++) {
							$('#sigungudiv').append('<label id="sigungulabel"><input type="radio" value="'+selectedValue+'!'+response[i].orgCd+'" name="sigungu" id="sigunguradio">'+response[i].orgdownNm+'</label>');
						}
					}
        	    },
        	    error: function(error) {
            	    console.log('Ajax 요청 에러:', error);
           		}
        	});
		} else{
			$('label').remove('#sigungulabel');
		};	
    });

    $('input[type=radio][name="sigungu"]').on("change",function() {
	/*
		response = 보호소 배열
		...RegNo = 보호소 코드
		...Nm = 보호소 이름
	 */
		console.log(11);
        var selectedValue = $(this).val();
		if(selectedValue !=""){
        	$.ajax({
            	url: 'SelectConditionC', 
    	        type: 'POST', 
        	    data: { value: selectedValue },
            	success: function(response) {
				console.log(response);
					$('label').remove('#centerlabel');
						for (var i = 0; i < response.length; i++) {
							$('#centerdiv').append('<label id="centerlabel"><input type="radio" value="'+selectedValue+'!'+response[i].orgCd+'" name="sigungu" checked="checked"  id="sigunguradio">'+response[i].orgdownNm+'</label>');
						}
        	    },
        	    error: function(error) {
            	    console.log('Ajax 요청 에러:', error);
           		}
        	});
		};	
    });

    $('#sidoSelect').on('change', function() {
	/*
		response = 시/군/구 배열
		.orgCd = 도시 코드
		.orgdownNm = 도시 이름
		
	 */
        var selectedValue = $(this).val();
		if(selectedValue !=""){
	        $.ajax({
    	        url: 'SelectConditionC', 
        	    type: 'GET', 
            	data: { value: selectedValue },
	            success: function(response) {
					console.log(response);
					$('option').remove('#sigunop');
					$('option').remove('#centerop');
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
			$('option').remove('#centerop');
		};
    });

    $('#sigunSelect').on('change', function() {
	/*
		response = 보호소 배열
		...RegNo = 보호소 코드
		...Nm = 보호소 이름
	 */
        var selectedValue = $(this).val();
        if(selectedValue !=""){
       		$.ajax({
            	url: 'SelectConditionC', 
            	type: 'POST', 
            	data: { value: selectedValue },
            	success: function(response) {
						$('option').remove('#centerop');
						for (var i = 0; i < response.length; i++) {
							$('#centerSelect').append('<option value="'+response[i].careRegNo+'" id="centerop">'+response[i].careNm+'</option>');
						}
            	},
            	error: function(error) {
                	console.log('Ajax 요청 에러:', error);
            	}
        	});
		} else{
			$('option').remove('#centerop');
		};
    });
});