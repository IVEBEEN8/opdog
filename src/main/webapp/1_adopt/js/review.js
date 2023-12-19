function checkForm() {
  // 이미지 파일이 선택되었는지 확인합니다.
  if (document.getElementById("previousFileName").value.length === 0) {
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
// 등록 이미지 미리보기 
 function previewSelectedImage(input) {
            var preview = document.getElementById('previewImage');
            var file = input.files[0];
            var reader = new FileReader();

            reader.onload = function (e) {
                preview.src = e.target.result;
            };

            if (file) {
                // 이미지를 선택한 경우에만 미리보기 영역을 보이도록 변경
                preview.parentNode.style.display = 'block';
                reader.readAsDataURL(file);

                // 이미지를 선택한 경우, 그 이름을 저장
                document.getElementById("previousFileName").value = file.name;
            } else {
    // 이미지를 선택하지 않은 경우에는 이전 이미지를 보여줌
    var previousFileName = document.getElementById("previousFileName").value;

    if (!previousFileName) {
        // 이전 파일 이름이 없는 경우
        preview.parentNode.style.display = 'none';  // 미리보기 영역을 숨김
    } else {
        // 이전 파일 이름이 있는 경우
        preview.parentNode.style.display = 'block';  // 미리보기 영역을 보이도록 변경
        // 초기 이미지의 경로를 이전 파일 이름을 사용하여 설정
        preview.src = "1_adopt/1_4_review/imgFolder/" + previousFileName;
    }
			
			
			}
            
            
            	
            // 파일 선택 값 초기화는 선택한 파일을 다시 선택할 수 있게 하기 위한 것
            // fileInput.value = ''; // 이 부분을 주석 처리하거나 삭제하면 사용자가 같은 파일을 여러 번 선택할 수 있습니다.
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


