function getDateTime() {
    // 현재 날짜 객체 생성
    var currentDate = new Date();

    // 요일을 가져오기
    var daysOfWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    var dayOfWeek = daysOfWeek[currentDate.getDay()];

    // 시간을 가져오기
    var hours = currentDate.getHours();
    var minutes = currentDate.getMinutes();

	// 오전 오후!
 	var ampm = hours >= 12 ? 'PM' : 'AM';

    // 24 - > 12시간제로 변경
    hours = hours % 12;
    hours = hours ? hours : 12; // 0시는 12시로 표시

    // Monday 12:01 AM 
    var formattedDateTime = dayOfWeek + ' ' + (hours < 10 ? '0' : '') + hours + ':' + (minutes < 10 ? '0' : '') + minutes + ' ' + ampm;
    return formattedDateTime;
}

// 함수 호출해서 날짜 및 시간 가져오기
var currentDateTime = getDateTime();
console.log(currentDateTime);
 document.addEventListener('DOMContentLoaded', function() {
        document.getElementById('date1').innerHTML = currentDateTime
});