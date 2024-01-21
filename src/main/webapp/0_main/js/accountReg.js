$(document).ready(function() {
	$('#idcheck').on('click', function() {
		var checkingValue = $("input[name='id']").val();

		var inputbox = $("input[name='id']");
		console.log(checkingValue);
		var result = '';
		$.ajax({
			url: 'IdCheckC',
			type: 'POST',
			data: { checkingValue, result },
			success: function(data) {
				console.log(data);
				console.log(data[0].result);
				console.log(data[0].checkingValue);
				if (checkingValue === "") {
					alert("Please type email^^")
				} else {
					if (data[0].result === "email o") {
						alert(data[0].checkingValue + " is already in use. Please register with a different email.")
						inputbox.focus();
						inputbox.val("");
						return false;
					} else if (data[0].result === "email x") {
						alert("You can register with " + data[0].checkingValue + "")
					}
				}
			}
		})
	});


	$('#sidoSelect').on('change', function() {
		/*
			response = 시/군/구 배열
			.orgCd = 도시 코드
			.orgdownNm = 도시 이름
			
		 */
		var selectedValue = $(this).val();
		console.log(selectedValue)
		//	$('input[type=radio][name="sido"][value="'+selectedValue+'"]').prop('checked',true);

		if (selectedValue != "") {
			console.log(11);
			$.ajax({
				url: 'SelectConditionC',
				type: 'GET',
				data: { value: selectedValue },
				success: function(response) {
					console.log(response);
					//$('label').remove('#sigungulabel');
					//$('label').remove('#centerlabel');
					$('option').remove('#sigunop');
					//$('option').remove('#centerop');
					if (selectedValue == 5690000) {
						//$('#sigungudiv').append('<label id="sigungulabel"><input type="radio" value="'+selectedValue+'!'+selectedValue+'" name="sigungu" id="sigungurd">세종특별자치시</label>');
						$('#sigunSelect').append('<option value="' + selectedValue + '!' + selectedValue + '" id="sigunop">세종특별자치시</option>');
					} else {
						for (var i = 0; i < response.length; i++) {
							//$('#sigungudiv').append('<label id="sigungulabel"><input type="radio" value="'+selectedValue+'!'+response[i].orgCd+'" name="sigungu" id="sigungurd">'+response[i].orgdownNm+'</label>')
							$('#sigunSelect').append('<option value="' + selectedValue + '!' + response[i].orgCd + '" id="sigunop">' + response[i].orgdownNm + '</option>');
						}
					}
				},
				error: function(error) {
					console.log('Ajax 요청 에러:', error);
				}
			});
		} else {
			//$('label').remove('#sigungulabel');
			//$('label').remove('#centerlabel');
			$('option').remove('#sigunop');
			//$('option').remove('#centerop');
		};
	});

	$('#sidoSelect').change(function() {
		$('input[name="sidotext"]').remove();
		var sidotext = $('#sidoSelect option:checked').text();
		$('.selectBox').append('<input type="hidden" name="sidotext" value="' + sidotext + '"></input>')
	})
	$('#sigunSelect').change(function() {
		$('input[name="siguntext"]').remove();
		var siguntext = $('#sigunSelect option:checked').text();
		$('.selectBox').append('<input type="hidden" name="siguntext" value="' + siguntext + '"></input>')
	})






})