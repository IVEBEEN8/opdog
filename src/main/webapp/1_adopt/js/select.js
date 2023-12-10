$(document).ready(function() {
	
    $('input[type=radio][name="sido"]').on("change",function() {
	/*
		response = 시/군/구 배열
		.orgCd = 도시 코드
		.orgdownNm = 도시 이름
	 */
		
        var selectedValue = $(this).val();
		$('#sidoSelect').val(selectedValue);
		if(selectedValue !=""){
        	$.ajax({
            	url: 'SelectConditionC', 
    	        type: 'GET', 
        	    data: { value: selectedValue },
            	success: function(response) {
				console.log(response);
					$('label').remove('#sigungulabel');
					$('label').remove('#centerlabel');
					$('option').remove('#sigunop');
					$('option').remove('#centerop');
					if (selectedValue==5690000) {
						$('#sigungudiv').append('<label id="sigungulabel"><input type="radio" value="'+selectedValue+'!'+selectedValue+'" name="sigungu" id="sigungurd">세종특별자치시</label>');
						$('#sigunSelect').append('<option value="'+selectedValue+'!'+selectedValue+'" id="sigunop">세종특별자치시</option>');
					}else {
						for (var i = 0; i < response.length; i++) {
							$('#sigungudiv').append('<label id="sigungulabel"><input type="radio" value="'+selectedValue+'!'+response[i].orgCd+'" name="sigungu" id="sigungurd">'+response[i].orgdownNm+'</label>');
							$('#sigunSelect').append('<option value="'+selectedValue+'!'+response[i].orgCd+'" id="sigunop">'+response[i].orgdownNm+'</option>');
						}
					}
        	    },
        	    error: function(error) {
            	    console.log('Ajax 요청 에러:', error);
           		}
        	});
		} else{
			$('label').remove('#sigungulabel');
			$('label').remove('#centerlabel');
			$('option').remove('#sigunop');
			$('option').remove('#centerop');
		};	
    });
	
    $(document).on("change", 'input[type=radio][name="sigungu"]' ,function() {
	/*
		response = 보호소 배열
		...RegNo = 보호소 코드
		...Nm = 보호소 이름
	 */
        var selectedValue = $(this).val();
		$('#sigunSelect').val(selectedValue);
		if(selectedValue !=""){
        	$.ajax({
            	url: 'SelectConditionC', 
    	        type: 'POST', 
        	    data: { value: selectedValue },
            	success: function(response) {
					$('label').remove('#centerlabel');
					$('option').remove('#centerop');
						for (var i = 0; i < response.length; i++) {
							$('#centerdiv').append('<label id="centerlabel"><input type="radio" value="'+response[i].careRegNo+'" name="center" id="centerrd">'+response[i].careNm+'</label>');
							$('#centerSelect').append('<option value="'+response[i].careRegNo+'" id="centerop">'+response[i].careNm+'</option>');
						}
        	    },
        	    error: function(error) {
            	    console.log('Ajax 요청 에러:', error);
           		}
        	});
		} else{
			$('label').remove('#centerlabel'); 
			$('option').remove('#centerop');
		};	
    });
    $(document).on("change", 'input[type=radio][name="center"]' ,function() {
        var selectedValue = $(this).val();
		$('#centerSelect').val(selectedValue);


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
					$('label').remove('#sigungulabel');
					$('label').remove('#centerlabel');
					$('option').remove('#sigunop');
					$('option').remove('#centerop');
					if (selectedValue==5690000) {
						$('#sigungudiv').append('<label id="sigungulabel"><input type="radio" value="'+selectedValue+'!'+selectedValue+'" name="sigungu" id="sigungurd">세종특별자치시</label>');
						$('#sigunSelect').append('<option value="'+selectedValue+'!'+selectedValue+'" id="sigunop">세종특별자치시</option>');
					}else {
						for (var i = 0; i < response.length; i++) {
							$('#sigungudiv').append('<label id="sigungulabel"><input type="radio" value="'+selectedValue+'!'+response[i].orgCd+'" name="sigungu" id="sigungurd">'+response[i].orgdownNm+'</label>')
							$('#sigunSelect').append('<option value="'+selectedValue+'!'+response[i].orgCd+'" id="sigunop">'+response[i].orgdownNm+'</option>');
						}
					}
            	},
            	error: function(error) {
	                console.log('Ajax 요청 에러:', error);
    	        }
        	});
		} else{
			$('label').remove('#sigungulabel');
			$('label').remove('#centerlabel');
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
		console.log(selectedValue);
        if(selectedValue !=""){
       		$.ajax({
            	url: 'SelectConditionC', 
            	type: 'POST', 
            	data: { value: selectedValue },
            	success: function(response) {
						$('label').remove('#centerlabel');
						$('option').remove('#centerop');
						for (var i = 0; i < response.length; i++) {
							$('#centerdiv').append('<label id="centerlabel"><input type="radio" value="'+response[i].careRegNo+'" name="center" >'+response[i].careNm+'</label>');
							$('#centerSelect').append('<option value="'+response[i].careRegNo+'" id="centerop">'+response[i].careNm+'</option>');
						}
            	},
            	error: function(error) {
                	console.log('Ajax 요청 에러:', error);
            	}
        	});
		} else{
			$('label').remove('#centerlabel'); 
			$('option').remove('#centerop');
		};
    });
	

	
	$(document).on('click','button[id=radiobutton]',function(){
		var sidoVal = $("input[name='sido']:checked").val();
		var gunguVal = $("input[name='sigungu']:checked").val();
		var centerVal = $("input[name='center']:checked").val();
		console.log(sidoVal);
		console.log(gunguVal);
		console.log(centerVal);
		
		$.ajax({
			url: 'SearchDoginfo',
			type: 'GET',
			data: { value1 : sidoVal, value2: gunguVal, value3 : centerVal},
			success: function(response){
				console.log(response);
				$('div').remove('#dog');
				for (var i = 0; i < response.length; i++){
					$('#dogs').append('<div class="#" id="dog"> <img alt="" src="'+ response[i].filename+'"> kind: '+ response[i].kindCd+' age:'+ response[i].age+' sex:'+ response[i].sexCd+' neuter:'+ response[i].neuterYn+'<button id="detail" value="'+response[i]+'">상세정보</button> </div>');
					console.log(response[i]);
				}
			}
		})
		
	});

	$(document).on('click','button[id=selectbutton]',function(){
		var sidoVal = $("#sidoSelect").val();
		var gunguVal = $("#sigunSelect").val();
		var centerVal = $("#centerSelect").val();
		console.log(sidoVal);
		console.log(gunguVal);
		console.log(centerVal);
		
		$.ajax({
			url: 'SearchDoginfo',
			type: 'GET',
			data: { value1 : sidoVal, value2: gunguVal, value3 : centerVal},
			success: function(response){
				console.log(response);
				$('div').remove('#dog');
				for (var i = 0; i < response.length; i++){
					$('#dogs').append('<div class="#" id="dog"> <img alt="" src="'+ response[i].filename+'"> kind: '+ response[i].kindCd+' age:'+ response[i].age+' sex:'+ response[i].sexCd+' neuter:'+ response[i].neuterYn+'<button id="detail" value="'+response[i]+'">상세정보</button> </div>');
					console.log(response[i]);
				}
			}
		})
		
	});
	$(document).on('click','button[id=detail]',function(){
		doginfo = JSON.stringify($(this).val());
		console.log(doginfo);
		
	/*
		localStorage.setItem('data', JSON.stringify(doginfo));
		window.open('1_adopt/1_1_info/infoDetail.jsp','_blank','width=500,height=400');
	*/	
	});	
});
