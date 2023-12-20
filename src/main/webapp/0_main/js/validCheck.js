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
	let ok2 = '.';
	for(let i =0; i < input.value.length; i++){
		if(!ok2.indexOf(input.value[i])==-1){
			return true;
		}
	}return false;
	
}

function notContains(input, set){
// input : ASD	
// input : 1qASD
// SET : 1234567890 //반드시 숫자를 포함시키고 싶다. 라는 의미와 같은것!
// SET : QWERTYUIOPASDFGHJKLZXCVBNM // 대문자를 반드시 포함해라.

// 포함에 대한 여부 -> 하나라도 포함되어있으면 문제가 없는거! 
// 위에는 사용자가 입력한것의 length만을, 아래는 set의 length를 본다
	// let set ='1234567890';
	// let set2 = 'QWERTYUIOPASDFGHJKLZXCVBNM';
	for(let i = 0; i< set.length; i++){
		if(input.value.indexOf(set[i]!== -1)){
			return false;		
		}
	}
	return true;
}


























