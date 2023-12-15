function checkForm() {
  // 이미지 파일이 선택되었는지 확인합니다.
  if (document.getElementById("fileInput").files.length === 0&&
    document.getElementById("oldImg").value.trim() === "") {
    alert("Please select an image file");
    document.getElementById("fileInput").focus();
    return false;
  }
  
  // 제목 입력값을 얻어옵니다.
  var titleValue = document.getElementById("title").value;
	
  // 제목이 공백 또는 띄어쓰기로만 이루어져 있는 경우를 확인합니다.
  if (!titleValue.trim()) {
    alert("Please enter a title");
    document.getElementById("title").focus();
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
// 이미지 미리보기 
function previewSelectedImage(input) {
  var preview = document.getElementById('previewImage');
  var file = input.files[0];

  if (file) {
    // 파일이 선택된 경우
    var reader = new FileReader();
    
    reader.onloadend = function () {
      preview.src = reader.result;
    }

    reader.readAsDataURL(file);

    // 선택한 파일의 이름으로 oldImg 업데이트
    document.getElementById("oldImg").value = file.name;
  } else {
    // 파일 선택이 취소된 경우
    preview.src = "1_adopt/1_4_review/imgFolder/" + document.getElementById("oldImg").value;
  }
}

// 글자수제한
function checkLength() {
        var textarea = document.getElementById('txt');
        var charCount = document.getElementById('charCount');
        var maxLength = 1500;

        if (textarea.value.length > maxLength) {
            textarea.value = textarea.value.substring(0, maxLength);
        }

        charCount.innerText = '글자 수: ' + textarea.value.length + ' / ' + maxLength;
    }
