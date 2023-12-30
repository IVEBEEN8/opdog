
function deleteMovie(n){
	let ok = confirm ('Are you sure you want to delete?');
	if(ok){
		location.href='VolunteerDelC?no=' + n;
	}
}
console.log("ready to call");
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