function changeColor(clickedElement) {
      // 모든 박스에서 원래 색상으로 되돌림
      var allBoxes = document.querySelectorAll('.box');
      allBoxes.forEach(function(box) {
        box.style.backgroundColor = 'white'; // 기본 색상으로 초기화
      });

      // 클릭한 div의 색상을 변경
      clickedElement.style.backgroundColor = 'rgba(250, 234, 177, 0.51)'; // 변경할 색상
      
      // 선택된 박스에 selected 클래스 추가
  		clickedElement.classList.add('selected');
      
    }
    
    
