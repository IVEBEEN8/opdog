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
		$('input[type=radio][name="sido"][value="'+selectedValue+'"]').prop('checked',true);
		
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
		$('input[type=radio][name="sigungu"][value="'+selectedValue+'"]').prop('checked',true);
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
	$('#centerSelect').on('change',function(){
		var selectedvalue = $(this).val();
		$('input[type=radio][name="center"][value="'+selectedvalue+'"]').prop('checked',true);
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
				pagination(response);
					
			}
		})
		
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
//				console.log(response);
				pagination(response);
				
			}
		})
		
	});
	$(document).on('click','button[id=detail]',function(){
		var values = $(this).children().text();
		var items = JSON.parse(values);
		$('div').remove('#detailinfo');
		$('#modalBody').append('<div class="#" id="detailinfo"><img src="'+items.popfile+'" style="width:300px;"></div>');
		$('#modalBody').append('<div class="#" id="detailinfo">나이:'+items.age+'</div>');
		$('#modalBody').append('<div class="#" id="detailinfo">유기번호:'+items.desertionNo+'</div>');
		$('#modalBody').append('<div class="#" id="detailinfo">품종:'+items.kindCd+'</div>');
		$('#modalBody').append('<div class="#" id="detailinfo">색상:'+items.colorCd+'</div>');
		$('#modalBody').append('<div class="#" id="detailinfo">나이:'+items.age+'</div>');
		$('#modalBody').append('<div class="#" id="detailinfo">성별:'+items.sexCd+'</div>');
		$('#modalBody').append('<div class="#" id="detailinfo">중성화:'+items.neuterYn+'</div>');
		$('#modalBody').append('<div class="#" id="detailinfo">특징: '+items.specialMark+'</div>');
		$('#modalBody').append('<div class="#" id="detailinfo">보호소: '+items.careNm+'연락처 '+items.careTel+'주소 '+items.careAddr+'<button>지도로 보기</button></div>');
		$('#modalBody').append('<div class="#" id="detailinfo">관할기관: '+items.orgNm+'담당부서 '+items.chargeNm +'연락처 '+items.officetel+'</div>');
		$('#modalBody').append('<div class="#" id="detailinfo"><button>장바구니</button></div>');
		$('#modalWrap').css({
			"display":"block"
		});
	});
	$(document).on('click','span[id=closeBtn]',function(){
		$('#modalWrap').css({
			"display":"none"
		});
	});
	$(window).on('click',function(event){
		if($(event.target).is('#modalWrap')){
			$('#modalWrap').css({
				"display":"none"
			});
		};
	});
});

function pagination(json){
	console.log(json)
	console.log('---------')
		let container = $('#pagination');
		container.pagination({
			dataSource: json,
			callback: function(data, pagination){
				var dataHtml = '<ul>';
				$.each(data, function (index,item){
					dataHtml += '<li><div class="#" id="dog"> <img alt="" src="'+ item.filename+'"> kind: '+ item.kindCd+' age:'+ item.age+' sex:'+ item.sexCd+' neuter:'+ item.neuterYn+'<button id="detail"><p style="display:none;">'+JSON.stringify(item)+'</p>상세정보</button> </div></li>';
					console.log(item)
					});
				dataHtml += '</ul>';
				$("#data-container").html(dataHtml);
			}
	});
}
