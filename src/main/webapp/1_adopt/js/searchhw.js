
$(document).ready(function performSearch(){
	//검색버튼 클릭이벤트처리!
	$("#searchButton").on("click", function(){
		var searchField = $("select[name='searchField']").val();
		var searchText = $("input[name='searchText']").val();

		console.log(searchField);
		console.log(searchText);
		$("#printinfo1").show();
	
	//Ajax 요청!
	$.ajax({
		type: "POST",
		url : "SearchC",
		data : {
			searchField : searchField, 
			searchText: searchText
			},
		success : function(data){
			
			console.log(data);
				$("#modalBody1").empty();
			for(var i = 0; i < data.length; i++){
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Center Name</div><div class="small-content1">:' + data[i].careNm + '</div></div>');
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Address</div><div class="small-content1">:' + data[i].careAddr + '</div></div>');
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Operation Time</div><div class="small-content1">:' + data[i].oprtime+'~'+data[i].closetime +'('+data[i].closeday+')'+ '</div></div>');
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Tel</div><div class="small-content1">: ' + data[i].tel + '</div></div>');	
				$("#modalBody1").append('<hr>')}
				//모달
		   	  $("#closeBtn1").on("click", function () {
            		$("#printinfo1").hide();
        		});		
		},
		error: function(){
			console.log("검색에 실패했습니다.");
		}	
	
	  });
		// 닫기 버튼 클릭 이벤트 핸들러
		const printinfobox = document.getElementById('printinfo1');
		
		// 창 외부 클릭 시 모달 닫기
		$(document).on("click", function(event) {
		    if (event.target === printinfobox) {
		        printinfobox.style.display = 'none';
		    }
		});
		
	});
		
})