
function deleteMovie(n){
	let ok = confirm ('Are you sure you want to delete?');
	if(ok){
		location.href='VolunteerDelC?no=' + n;
	}
}
console.log("ready to call");
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("btn").addEventListener("click", function () {
        var selectedValue = $(this).val();
        var san = selectedValue.split("!");
        var accountNo1 = san[0];
        var vNo = san[1];
        var vStatus = san[2];
        var vTitle = san[3];
        var vCreated = san[4];
        var vImg = san[5];
        var vTxt = san[6];
        var aEmail = san[7];
        console.log(san);
        vTxt = vTxt.replaceAll("\r\n", "<br>");

        // Check if the user is logged in
        if (accountNo1 !== "") {
            Swal.fire({
                icon: "success",
                title: "Application Success - The shelter will contact you individually",
                showConfirmButton: false,
                timer: 1500,
                didClose: () => {
                    var goMypage = confirm('Do you want to check MyPage?');
                    if (goMypage) {
                        console.log("gotomypage!!");
                        location.href = 'MyPageHC';
                    } else {
                        // Move the AJAX request here
                        var formData = new FormData();
                        formData.append("accountNo1", accountNo1);
                        formData.append("vNo", vNo);
                        formData.append("vStatus", vStatus);
                        formData.append("vTitle", vTitle);
                        formData.append("vCreated", vCreated);
                        formData.append("vImg", vImg);
                        formData.append("vTxt", vTxt);
                        formData.append("aEmail", aEmail);

                        $.ajax({
                            type: "POST",
                            url: "ApplyVolC",
                            data: formData,
                            contentType: false,
                            processData: false,
                            success: function () {
                                console.log("데이터 전송 성공!");
                                console.log(formData); // 이 부분으로 이동
                            },
                            error: function () {
                                console.log("데이터 전송 실패!");
                            }
                        });
                        location.href = 'VolunteerDetailC?no=' + vNo;
                    }
                }
            });
        } else {
            // User is not logged in, redirect to "LoginMainHC"
            var goLogin1 = confirm('You must login first.\nDo you want to login?');
            if (goLogin1) {
                window.location.href = 'LoginMainHC';
            } else {
                location.href = 'VolunteerDetailC?no=' + vNo;
            }
        }
    });
});
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("regVol").addEventListener("click", function () {
        var accountNo = this.value;
        console.log(accountNo);
        // Check if the user is logged in
        if (accountNo !== "") {
            // User is logged in, proceed to "VtWriteC"
            location.href = 'VtWriteC';
        } else {
            // User is not logged in, redirect to "LoginMainHC"
            var goLogin = confirm('You must login first.\nDo you want to login?');
            if (goLogin) {
                window.location.href = 'LoginMainHC';
            }
        }
    });
});
