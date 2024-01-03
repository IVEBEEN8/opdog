function goCheckOut() {
	// 서버에서 세션 정보를 가져옴
	var sessionAccount = document.getElementById("goCheckOut").value;

	// 세션 정보가 있는지 확인
	if (!sessionAccount) {
		// 로그인 되어 있지 않으면 로그인 여부를 확인
		var result = confirm('This is a menu that requires login\nWould you like to go to the login page?');
		if (result) {
			// 로그인 페이지로 이동
			location.href = "LoginMainHC";
		}
	} else {
		// 로그인 되어 있으면 checkOut()로 이동
		checkOut();
	}
}





var title;
var price;
var sPrice;
var brand;

function checkOut() {
	title = document.getElementById("itemTitle").innerText;
	price = document.getElementById("itemPrice").value;
	sPrice = document.getElementById("itemSPrice").value;
	sPrice = parseInt(sPrice);
	brand = document.getElementById("itemBrand").innerText;

	// URL에 아이템 정보를 전달
	var checkoutUrl = "2_shop/2_5_checkOut/checkOut.jsp?title="
		+ encodeURIComponent(title)
		+ "&price=" + encodeURIComponent(price)
		+ "&sPrice=" + encodeURIComponent(sPrice)
		+ "&brand=" + encodeURIComponent(brand);

	// 새 창 열기
	var width = 400; // 원하는 폭
	var height = 500; // 원하는 높이
	var left = (window.innerWidth - width) / 2;
	var top = (window.innerHeight - height) / 2;

	window.open(checkoutUrl, "결제하기", "width=" + width + ", height=" + height + ", left=" + left + ", top=" + top);
}

function continueShopping() {
  const inputs = document.querySelectorAll('.input-group input');

  let emptyInputFound = false;
  for (let i = 0; i < inputs.length; i++) {
    const input = inputs[i];
    if (input.value.trim() === '') {
	  //alert('Please enter all required information');
	  swal('Notice','Please enter all required information', 'info')
      input.focus();
      emptyInputFound = true;
      break; // Stop checking after finding the first empty input
    }
  }

  if (!emptyInputFound) {
    // All inputs are filled, proceed with checkout
    title = document.getElementById("itemTitle").value;
    price = document.getElementById("itemPrice").value;
    sPrice = document.getElementById("itemSPrice").value;
    sPrice = parseInt(sPrice);
    brand = document.getElementById("itemBrand").value;

    // Create checkout2 content container
    var checkout2Content = document.createElement("div");
    checkout2Content.id = "checkout2-content";
    document.body.appendChild(checkout2Content);

    // Remove checkout content
    var checkoutContent = document.getElementById("checkout-content");
    checkoutContent.parentNode.removeChild(checkoutContent);

    var checkout2Url = "checkOut2.jsp?title="
      + encodeURIComponent(title)
      + "&price=" + encodeURIComponent(price)
      + "&sPrice=" + encodeURIComponent(sPrice)
      + "&brand=" + encodeURIComponent(brand);

    // Fetch checkout2 content
    fetch(checkout2Url)
      .then(response => response.text())
      .then(text => {
        checkout2Content.innerHTML = text;
      });
  }
}


function payWithCard() {
  const inputs = document.querySelectorAll('.input-line input, .card-info select, .input-cvc'); // Select all relevant inputs and selects

  let emptyFields = [];

  for (let i = 0; i < inputs.length; i++) {
    const input = inputs[i];
    if (input.value.trim() === '') { // Check for empty values after trimming whitespace
      emptyFields.push(input.placeholder || input.name); // Use placeholder or name for descriptive field names
    }
  }

  if (emptyFields.length > 0) {
     swal('Notice','Please enter all required information', 'info');
    return; // Prevent payment processing if there are empty fields
  } else {
    // URL에 변수를 전달
    var checkoutUrl = "/SemiProject/OrderedC?title=" + encodeURIComponent(title)
      + "&price=" + encodeURIComponent(price)
      + "&sPrice=" + encodeURIComponent(sPrice)
      + "&brand=" + encodeURIComponent(brand);

    // 새창을 닫음
    window.close();
    // 기존 창에서 움직임
    window.opener.location.href = checkoutUrl;
  }
}



