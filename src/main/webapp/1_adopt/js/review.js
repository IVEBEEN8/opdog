function checkForm() {
  // 제목 입력값을 얻어옵니다.
  var titleValue = document.getElementById("title").value;
	
  // 제목이 공백 또는 띄어쓰기로만 이루어져 있는 경우를 확인합니다.
  if (!titleValue.trim()) {
    alert("Please enter a title");
    document.getElementById("title").focus();
    return false;
  }
  
  
  // 이미지 파일이 선택되었는지 확인합니다.
  if (document.getElementById("fileInput").value.length === 0) {
    alert("Please select an image file");
    return false;
  }
  

  // 내용 입력값을 얻어옵니다.
  var txtValue = document.getElementById("txt").value;

  // 내용이 공백 또는 띄어쓰기로만 이루어져 있는 경우를 확인합니다.
  if (!txtValue.trim()) {
    alert("Please enter text");
    document.getElementById("txt").focus();
    return false;
  }

  // 모든 입력이 정상이면 등록 페이지로 이동합니다.
 
  	return true;
}

// 등록 이미지 미리보기 
function previewSelectedImage(input) {
    var preview = document.getElementById('previewImage');
    var file = input.files[0];
    var reader = new FileReader();

    reader.onload = function (e) {
        // 이미지를 선택한 경우에만 미리보기 영역을 보이도록 변경
        preview.parentNode.style.display = 'block';
        preview.src = e.target.result;

    };

    if (file) {
        // 이미지를 선택한 경우에만 미리보기 영역을 보이도록 변경
        preview.parentNode.style.display = 'block';
        reader.readAsDataURL(file);
    } else {
        preview.parentNode.style.display = 'none';  // 미리보기 영역을 숨김
        }
    
}


function checkLength() {
        var textarea = document.getElementById('txt');
        var charCount = document.getElementById('charCount');
        var maxLength = 1500;

        if (textarea.value.length > maxLength) {
            textarea.value = textarea.value.substring(0, maxLength);
        }

        charCount.innerText = '글자 수: ' + textarea.value.length + ' / ' + maxLength;
    }



// 리뷰 삭제
function reviewDelete(n){
	let ok = confirm('Are you sure you want to delete?');
	if(ok){
		location.href = 'ReviewDelC?id=' + n
	}
	
}


