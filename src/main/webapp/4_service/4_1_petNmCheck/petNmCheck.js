$(document).ready(function(){

	console.log("hellow world?");
	$('#submit').on("click", function(){

const API_KEY ="sJG8TCmXj96iwKxnSPRAaGazSqjp8g97CNLXDwtsv7BNaDo%2F6qhQtG3OIp0MAEreldhU5TicAqKPPvCVcrj7cA%3D%3D";
var inputValueName = document.getElementById('name').value;
var inputValuePetNm = document.getElementById('petnum').value;

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
};


xhr.onreadystatechange = function () {
	console.log('onreadystatechange event triggered');
    if (xhr.readyState === XMLHttpRequest.DONE) {
        if (xhr.status === 200) {
            const response = JSON.parse(xhr.responseText);
            console.log(response);
            //화면출력 id 가져오
            const resultContainer = document.getElementById('resultContainer');
            // 특정 값 액세스
            const header = response.response.header;
            const reqNo = header.reqNo;
            const resultCode = header.resultCode;
            const resultMsg = header.resultMsg;

            const body = response.response.body;
            const item = body.item;
            const dogRegNo = item.dogRegNo;
            const rfidCd = item.rfidCd;
            const dogNm = item.dogNm;
            const sexNm = item.sexNm;
            const kindNm = item.kindNm;
            const neuterYn =
            	
            	item.neuterYn;
            const orgNm = item.orgNm;
            const officeTel = item.officeTel;
            const aprGbNm = item.aprGbNm;

           	console.log(11);
            // 동적으로 화면에 출력! 
            resultContainer.innerHTML =
                '<p>Dog Name:' +dogNm+'</p>' +
                '<p>Sex:'+ sexNm +'</p>'+
                '<p>Kind:'+ kindNm +'</p>' +
                '<p>orgNm:' + orgNm + '</p>' +
                '<p>officeTel:' +
                officeTel + '</p>'
        }
    }
};
xhr.send('');

	});
	

});