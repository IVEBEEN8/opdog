$(document).ready(function(){
    $.get("http://localhost:8080/getData", function(data) {
        console.log(data); // 서버에서 받은 데이터를 출력하거나 활용
    });
});