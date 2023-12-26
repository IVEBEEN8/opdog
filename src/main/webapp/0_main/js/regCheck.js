function check(){
	
	let firstName = document.querySelector("input[name='firstName']");
	let lastName = document.querySelector("input[name='lastName']");
	let id = document.querySelector("input[name='id']");
	let pw = document.querySelector("input[name='pw']");
	let pwCheck = document.querySelector("input[name='pwCheck']");
	let uprCd = document.getElementById("sidoSelect");
	let orgCd = document.getElementById("sigunSelect");
 	//let checkbox = document.querySelector(" <input type="checkbox" name="agree" value="mail" />")
  

	
	console.log(firstName);
	console.log(lastName);
	console.log(id);
	console.log(pw);
	console.log(pwCheck);
	console.log(uprCd);
	console.log(orgCd);
	
	
	
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
	
	if (notContains(pw, "1234567890") ||notContains(pw,"QWERTYUIOPASDFGHJKLZXCVBNM")) {
    alert('Password must have at least a capital letter and a number. Please re-enter pasword.');
    pw.focus();
    pw.value = "";
	return false;
	}
	
	
	if(lessThan(pw,8)){
		alert('Type more than 8 characters');
		pw.focus();
		pw.value="";
		return false;
	}

	if (isEmpty(pwCheck)){
		alert('Check your password');
		pwCheck.focus();
		return false;
	}
	
	
	if(notEquals(pw, pwCheck)){
		alert("Passwords do not match");
		pw.focus();
		pw.value="";
		pwCehck.value="";
		return false;
	}
	
	if(notSelect(uprCd)){
		alert("check your state");
		return false;
	}
	if(notSelect(orgCd)){
		alert("check your city");
		return false;
	}
	if(!isCheckboxChecked){
		alert("agree to the terms");
	}
	
}
	
	