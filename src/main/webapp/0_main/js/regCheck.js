
function check() {

	let firstName = document.querySelector("input[name='firstName']");
	let lastName = document.querySelector("input[name='lastName']");
	let id = document.querySelector("input[name='id']");
	let pw = document.querySelector("input[name='pw']");
	let pwCheck = document.querySelector("input[name='pwCheck']");
	let uprCd = document.getElementById("sidoSelect");
	let orgCd = document.getElementById("sigunSelect");
	let checkbox = document.querySelector("input[type='checkbox'][name='agree']");

	if (isEmpty(firstName)|| !isValidName(firstName.value)) {
		firstName.classList.add('error-placeholder'); 
		firstName.setAttribute('placeholder', 'Enter your First name with no numbers');
		firstName.focus();
		firstName.value = "";
		lastName.value="";
		return false;
	}
	

	if (isEmpty(lastName)|| !isValidName(lastName.value)) {
		lastName.classList.add('error-placeholder'); 
		lastName.setAttribute('placeholder', 'Enter your Last name with no numbers');
		lastName.focus();
		lastName.value ="";
		return false;
	}

	if (isEmpty(id) || !isValidEmail(id.value)) {
		id.classList.add('error-placeholder');
		id.value ="";
		id.setAttribute('placeholder', '[hello@world.com] check the format');
		id.focus();
		return false;
	}

	if (isEmpty(pw)) {
		pw.classList.add('error-placeholder'); 
		pw.setAttribute('placeholder', 'Enter your password (required)');
		pw.focus();
		return false;
	}

	if (notContains(pw, "1234567890") || notContains(pw, "QWERTYUIOPASDFGHJKLZXCVBNM")) {
		pw.classList.add('error-placeholder'); 
		pw.setAttribute('placeholder', 'Password must have capital letter and a number');
		pw.focus();
		pw.value = "";
		return false;
	}


	if (lessThan(pw, 8)) {
		pw.classList.add('error-placeholder');
		pw.setAttribute('placeholder', 'Type more than 8 characters');
		pw.focus();
		pw.value = "";
		return false;
	}

	if (isEmpty(pwCheck)) {
		pwCheck.classList.add('error-placeholder'); 
		pwCheck.setAttribute('placeholder', 'Enter your password check (required)');
		pwCheck.focus();
		return false;
	}


	if (notEquals(pw, pwCheck)) {
		pw.classList.add('error-placeholder'); 
		pwCheck.classList.add('error-placeholder'); 
		pw.setAttribute('placeholder', 'Passwords do not match');
		pwCheck.setAttribute('placeholder', 'Passwords do not match');
		pw.focus();
		pw.value = "";
		pwCheck.value = "";
		return false;
	}
	if (notSelect(uprCd)) {
		
		uprCd.focus();
		return false;
	}
	if (notSelect(orgCd)) {
		orgCd.focus();
		return false;
	}
	if (!isCheckboxChecked(checkbox)) {
		checkbox.focus();
		return false;
	}
}



