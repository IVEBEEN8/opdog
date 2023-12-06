$(document).ready(function() {
    $('#sido').on('change', function() {
        var selectedValue = $(this).val();
        $.ajax({
            url: 'SelectConditionC', 
            type: 'GET', 
            data: { value: selectedValue },
            success: function(response) {
				if (selectedValue==5690000) {
					$('#sigun').append('<option value="" id="sigunop">세종특별자치시</option>');
				}else {
					for (var i = 0; i < response.length; i++) {
						$('#sigun').append('<option value="'+selectedValue+'!'+response[i].orgCd+'" id="sigunop">'+response[i].orgdownNm+'</option>');
					}
				}
            },
            error: function(error) {
                console.log('Ajax 요청 에러:', error);
            }
        });
    });

    $('#sigun').on('change', function() {
        var selectedValue = $(this).val();
       	console.log(selectedValue);

        
        $.ajax({
            url: 'SelectConditionC', 
            type: 'POST', 
            data: { value: selectedValue },
            success: function(response) {
            		console.log(response);
					for (var i = 0; i < response.length; i++) {
						$('#center').append('<option value="'+response[i].careRegNo+'" id="sigunop">'+response[i].careNm+'</option>');
					}
            },
            error: function(error) {
                console.log('Ajax 요청 에러:', error);
            }
        });
    });
});