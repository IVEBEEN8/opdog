
$(document).ready(function(){
		$("#submit").on("click",function(){
		const API_KEY ="sJG8TCmXj96iwKxnSPRAaGazSqjp8g97CNLXDwtsv7BNaDo%2F6qhQtG3OIp0MAEreldhU5TicAqKPPvCVcrj7cA%3D%3D";
		var inputValueName = document.getElementById('name').value;
		var inputValuePetNm = document.getElementById('petnum').value;
		var xhr = new XMLHttpRequest();
		var url = 'http://apis.data.go.kr/1543061/animalInfoSrvc/animalInfo';
		var queryParams = '?' + encodeURIComponent('serviceKey') + '='+API_KEY; 
		queryParams += '&' + encodeURIComponent('dog_reg_no') + '=' + encodeURIComponent(inputValuePetNm);
		queryParams += '&' + encodeURIComponent('rfid_cd') + '=' + encodeURIComponent(inputValuePetNm);
		queryParams += '&' + encodeURIComponent('owner_nm') + '=' + encodeURIComponent(inputValueName);
		queryParams += '&' + encodeURIComponent('owner_birth') + '=' + encodeURIComponent('');
		queryParams += '&' + encodeURIComponent('_type') + '=' + encodeURIComponent('json');
		xhr.open('GET', url + queryParams);
		xhr.onreadystatechange = function () {
		console.log('onreadystatechange event triggered');
		
	    if (xhr.readyState === XMLHttpRequest.DONE) {
			console.log(xhr.status); //무조건 입력하면 200..
	        if (xhr.status === 200) {
				
	            const response = JSON.parse(xhr.responseText);
		        console.log(response);
				const header = response.response.header;
				const resultMsg = header.resultMsg;
				console.log(resultMsg)
				if(resultMsg != "NORMAL SERVICE."){
					$("#printinfo1").show();
					$("#modalBody1").empty();
					$("#span-title").empty();
					$("#span-title").append('OOPS!');
					$("#modalBody1").append('<div class="box-title1"><div class="small-title2">You mistype the information.'+
					'\nPlease check it again.</div><div class="small-content2"></div></div>');
	            }
				const body = response.response.body;
	            const item = body.item;
	            const rfidCd = item.rfidCd;
	            const dogNm = item.dogNm;
	            const sexNm = item.sexNm;
	            const kindNm = item.kindNm;
				const orgNm = item.orgNm;
	            const officeTel = item.officeTel;
				
				$.ajax({
                url: "TranslateInfoC",
                data: {
                   dogNm, sexNm, kindNm, orgNm
                },
                success: function (data) {
			
				const translatedDogNm = data[0].dogNm;
				const translatedSexNm = data[0].sexNm;	
				const translatedKindNm = data[0].kindNm;	
				const translatedOrgNm = data[0].orgNm;	
				
            	$("#printinfo1").show();  
				$("#modalBody1").empty();
				$("#span-title").empty();
				$("#span-title").append('MY  PET INFO');
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> ID Number</div><div class="small-content1">' + rfidCd + '</div></div>');
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Name</div><div class="small-content1">' + translatedDogNm  + '</div></div>');
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Gender</div><div class="small-content1">' + translatedSexNm + '</div></div>');
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Kind</div><div class="small-content1">' + translatedKindNm+ '</div></div>');
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> OrgNm</div><div class="small-content1"> ' + translatedOrgNm + '</div></div>');	
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Tel</div><div class="small-content1"> ' + officeTel+ '</div></div>');	
					}
				});
			
				}
				
   				}	$("#closeBtn1").on("click", function () {
            		$("#printinfo1").hide();
        		});

				const printinfobox = document.getElementById('printinfo1');

				$(document).on("click", function(event) {
		   			 if (event.target === printinfobox) {
		       		 printinfobox.style.display = 'none';
					 inputValueName=null;
					 inputValuePetNm=null;
					console.log(inputValueName);
					console.log(inputValuePetNm);
		    		}
				});

};
xhr.send('');

		});
});
