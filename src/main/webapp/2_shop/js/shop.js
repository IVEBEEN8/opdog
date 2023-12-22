function checkOut() {
    var title = document.getElementById("itemTitle").innerText;
    var price = document.getElementById("itemPrice").innerText;
    var sPrice= document.getElementById("checkOutBtn").value;
    var brand = document.getElementById("itemBrand").innerText;

    // URL에 카테고리와 아이템 정보를 전달
    var checkoutUrl = "2_shop/2_5_checkOut/checkOut.jsp?category=fashion&title=" 
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
  // checkout2.jsp 로드
  var checkout2Content = document.createElement("div");
  checkout2Content.id = "checkout2-content";
  document.body.appendChild(checkout2Content);
  
   // checkout.jsp의 내용 삭제
  var checkoutContent = document.getElementById("checkout-content");
  checkoutContent.parentNode.removeChild(checkoutContent);


  // checkout2.jsp 내용 불러오기
  fetch("checkOut2.jsp")
    .then(response => response.text())
    .then(text => {
      checkout2Content.innerHTML = text;
    });
}
