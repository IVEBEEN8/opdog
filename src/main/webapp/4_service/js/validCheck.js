//validcheck library~

function isEmpty(input){
	return !input.value;
}

function lessThan(input, length){
	return input.value.length < length;
}

function moreThan(input){
	return  input.value.length > 10;
}

function isNotNumber(input){
	return isNaN(input.value)
}

function notEquals(input, inputcheck){
	return input.value != inputcheck.value;
}

function containKR(input){	
	let ok ='QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm_@.';
	for(let i =0; i < input.value.length; i++){
		if(ok.indexOf(input.value[i])==-1){
			return true;
		}
	}return false;
	
}

function notContain (input){
	let ok2 = '';
	for(let i =0; i < input.value.length; i++){
		if(!ok2.indexOf(input.value[i])==-1){
			return true;
		}
	}return false;
	
}
function notContains(input, set) {
    for (let i = 0; i < set.length; i++) {
        if (input.value.indexOf(set[i]) !== -1) {
            return false;
        }
    }
    return true;
}
function notSelect(select){
	return select.selectedIndex <= 0;		
	}
	
function isCheckboxChecked(checkbox) {
    return checkbox.checked;
}


























