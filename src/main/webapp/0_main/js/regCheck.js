function check(){
	
	let firstName = document.querySelector("input[name='firstName']");
	let lastName = document.querySelector("input[name='lastName']");
	let id = document.querySelector("input[name='id']");
	let pw = document.querySelector("input[name='pw']");
	let pwCheck = document.querySelector("input[name='pwCheck']");
	
	
	if (isEmpty(firstName)){
		alert('Type your firstname');
		firstName.focus();
		return false;
	}
	if (isEmpty(lastName)){
		alert('Type your lastname');
		lastName.focus();
		return false;
	}
	if (isEmpty(id)){
		alert('Type your email address');
		id.focus();
		return false;
	}
	if (isEmpty(pw)){
		alert('Type your password');
		pw.focus();
		return false;
	}
	if (isEmpty(pwCheck)){
		alert('Check your password');
		pwCheck.focus();
		return false;
	}
	
	if (lessThan(pw,8) || notContains(pw,"1234567890") || notContains(pw,"QWERTYUIOPASDFGHJKLZXCVBNM")){
		alert("Password must be set over 8 characters including at least one number and one CAPITAL letter")
		pw.focus();
		pw.value="";
		return false;
	}
	
	if(notEquals(pw, pwCheck)){
		alert("Passwords do not match")
		pw.focus();
		pw.value="";
		pwCehck.value="";
		return false;
	}
	
}