function login() {
    var referrer = document.referrer;
	if(referrer.indexOf('LoginMainHC') != -1){
		window.location.href = "home.jsp";
	}else{
		window.location.href = referrer;
	}

}