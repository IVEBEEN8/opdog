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
    var checkoutWindow = window.open(checkoutUrl, "결제하기", "width=500, height=500");
}

