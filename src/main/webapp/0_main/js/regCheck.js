
function check() {

	let firstName = document.querySelector("input[name='firstName']");
	let lastName = document.querySelector("input[name='lastName']");
	let id = document.querySelector("input[name='id']");
	let pw = document.querySelector("input[name='pw']");
	let pwCheck = document.querySelector("input[name='pwCheck']");
	let uprCd = document.getElementById("sidoSelect");
	let orgCd = document.getElementById("sigunSelect");
	let checkbox = document.querySelector("input[type='checkbox'][name='agree']");

	if (isEmpty(firstName)) {
		firstName.classList.add('error-placeholder'); 
		firstName.setAttribute('placeholder', 'Enter your First name (required)');
		firstName.focus();
		return false;
	}

	if (isEmpty(lastName)) {
		lastName.classList.add('error-placeholder'); 
		lastName.setAttribute('placeholder', 'Enter your Last name (required)');
		lastName.focus();
		return false;
	}

	if (isEmpty(id)) {
		id.classList.add('error-placeholder'); 
		id.setAttribute('placeholder', 'Enter your e-mail (required)');
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

/*
function check() {
  var form = document.querySelector('form');
  var inputs = form.querySelectorAll('input[placeholder]');
  var firstEmptyInput = null; // 첫 번째 비어 있는 입력 필드

  var isValid = true;

  inputs.forEach(function(input) {
	if (input.value.trim() === '') {
	  isValid = false;
	  input.classList.add('error-placeholder'); // 빈 필드에 대한 클래스 추가
	  input.setAttribute('placeholder', 'Enter your ' + input.name + ' (required)');

	  if (!firstEmptyInput) {
		firstEmptyInput = input;
	  }
	} else {
	  input.classList.remove('error-placeholder'); // 빈 필드가 아닌 경우 클래스 제거
	}
  });

  if (firstEmptyInput) {
	firstEmptyInput.focus(); // 첫 번째 비어 있는 입력 필드에 포커스 주기
  }

  return isValid;
}*/

