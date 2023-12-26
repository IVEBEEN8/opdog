var title;
var price;
var sPrice;
var brand;


 function checkOut() {
    title = document.getElementById("itemTitle").innerText;
    price = document.getElementById("itemPrice").value;
    sPrice= document.getElementById("itemSPrice").value;
    sPrice = parseInt(sPrice);
    brand = document.getElementById("itemBrand").innerText;

    // URL에 아이템 정보를 전달
    var checkoutUrl = "2_shop/2_5_checkOut/checkOut.jsp?title=" 
    + encodeURIComponent(title) 
    + "&price=" + encodeURIComponent(price)
    + "&sPrice=" +encodeURIComponent(sPrice) 
    + "&brand=" + encodeURIComponent(brand);

    // 새 창 열기
    var width = 900; // 원하는 폭
    var height = 700; // 원하는 높이
    var left = (window.innerWidth - width) / 2;
    var top = (window.innerHeight - height) / 2;

    var checkoutWindow = window.open(checkoutUrl, "결제하기",  "width=" + width + ", height=" + height + ", left=" + left + ", top=" + top);
}

function continueShopping() {
	title = document.getElementById("itemTitle").value;
    price = document.getElementById("itemPrice").value;
    sPrice= document.getElementById("itemSPrice").value;
    sPrice = parseInt(sPrice);
    brand = document.getElementById("itemBrand").value;	
	
  // checkout2.jsp 로드
  var checkout2Content = document.createElement("div");
  checkout2Content.id = "checkout2-content";
  document.body.appendChild(checkout2Content);
  
   // checkout.jsp의 내용 삭제
  var checkoutContent = document.getElementById("checkout-content");
  checkoutContent.parentNode.removeChild(checkoutContent);

	 var checkout2Url = "checkOut2.jsp?title="
    + encodeURIComponent(title)
    + "&price=" + encodeURIComponent(price)
    + "&sPrice=" + encodeURIComponent(sPrice)
    + "&brand=" + encodeURIComponent(brand);

  // checkout2.jsp 내용 불러오기
  fetch(checkout2Url)  // 수정: fetch(checkout2Url)로 변경
    .then(response => response.text())
    .then(text => {
      checkout2Content.innerHTML = text;
    });
    
    


  // checkout2.jsp 내용 불러오기
 /* fetch("checkOut2.jsp")
    .then(response => response.text())
    .then(text => {
      checkout2Content.innerHTML = text;
    });*/
    
}
 function payWithCard() {
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



