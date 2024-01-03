
$(document).ready(function(){
	console.log("hellow world?");
		$("#submit").on("click",function(){
		const API_KEY ="sJG8TCmXj96iwKxnSPRAaGazSqjp8g97CNLXDwtsv7BNaDo%2F6qhQtG3OIp0MAEreldhU5TicAqKPPvCVcrj7cA%3D%3D";
		var inputValueName = document.getElementById('name').value;
		var inputValuePetNm = document.getElementById('petnum').value;
		console.log(inputValueName);
		console.log(inputValuePetNm);
		var xhr = new XMLHttpRequest();
		var url = 'http://apis.data.go.kr/1543061/animalInfoSrvc/animalInfo'; /*URL*/
		var queryParams = '?' + encodeURIComponent('serviceKey') + '='+API_KEY; /*Service Key*/
		queryParams += '&' + encodeURIComponent('dog_reg_no') + '=' + encodeURIComponent(inputValuePetNm); /**/
		queryParams += '&' + encodeURIComponent('rfid_cd') + '=' + encodeURIComponent(inputValuePetNm); /**/
		queryParams += '&' + encodeURIComponent('owner_nm') + '=' + encodeURIComponent(inputValueName); /**/
		queryParams += '&' + encodeURIComponent('owner_birth') + '=' + encodeURIComponent(''); /**/
		queryParams += '&' + encodeURIComponent('_type') + '=' + encodeURIComponent('json'); /**/
		xhr.open('GET', url + queryParams);
		xhr.onreadystatechange = function () {
		console.log('onreadystatechange event triggered');
		$("#printinfo1").show();
	    if (xhr.readyState === XMLHttpRequest.DONE) {
			console.log(xhr.status); //무조건 입력하면 200..
	        if (xhr.status === 200) {
				
	            const response = JSON.parse(xhr.responseText);
				console.log(11);	    
		        console.log(response);
				console.log(22);	    
	            //화면출력 id 가져오기
	            
				const header = response.response.header;
				const resultMsg = header.resultMsg;
	            // 특정 값 액세스!
				$("#modalBody1").empty();
				$("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Result Msg</div><div class="small-content1">:' + resultMsg + '</div></div>');
	            
				const body = response.response.body;
				console.log(body);
	            const item = body.item;
				console.log(item);
				console.log(33)
	            const rfidCd = item.rfidCd;
				console.log(44)
	            const dogNm = item.dogNm;
				console.log(55)
	            const sexNm = item.sexNm;
				console.log(66)
	            const kindNm = item.kindNm;
				console.log(77)
				const orgNm = item.orgNm;
				console.log(88)
	            const officeTel = item.officeTel;
				console.log(99)
	            const aprGbNm = item.aprGbNm;
				console.log(11);
				
				
				$("#modalBody1").empty();
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> ID Number of the dog</div><div class="small-content1">:' + rfidCd + '</div></div>');
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Name of the dog</div><div class="small-content1">:' + dogNm + '</div></div>');
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Gender</div><div class="small-content1">:' + sexNm + '</div></div>');
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Kind</div><div class="small-content1">:' + kindNm+ '</div></div>');
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> OrgNm</div><div class="small-content1">: ' + orgNm + '</div></div>');	
		        $("#modalBody1").append('<div class="box-title1"><div class="small-title1"> Tel</div><div class="small-content1">: ' + officeTel+ '</div></div>');	
				//모달
				}
   			}	$("#closeBtn1").on("click", function () {
            		$("#printinfo1").hide();
        		});
				console.log(13)
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
