let gender, color, hairLength, personality;

function showLoading() {
  document.getElementById("loading").style.display = "block";
  document.getElementById("loadingwords").style.display = "block";
}

function hideLoading() {
  document.getElementById("loading").style.display = "none";
  document.getElementById("loadingwords").style.display = "none";
}

function selectGender(selectedGender) {
  gender = selectedGender;
  showOptions("colorOptions");
}

function selectColor(selectedColor) {
  color = selectedColor;
  showOptions("hairLengthOptions");
}

function selectHairLength(selectedHairLength) {
  hairLength = selectedHairLength;
  showOptions("personalityOptions");
}

function selectPersonality(selectedPersonality) {
  personality = selectedPersonality;
  const generatedName = generateName();
  const personalityOptions = document.getElementById("personalityOptions");
  personalityOptions.innerHTML = `<h2>성별이 ${gender}, 털 색상이 ${color}, 털 길이가 ${hairLength}, 그리고 성격이 ${personality} 옵션 선택을 완료하셨습니다! 이름 생성하기 버튼을 눌러주세요!</h2>`
  /* updateSelectedText(
    `${generatedName}을(를) 선택했어여!! generate 버튼을 눌러주세용!!`
  ); */
  generateName();
}

function showOptions(optionsId) {
  const optionsElements = [
    "genderOptions",
    "colorOptions",
    "hairLengthOptions",
    "personalityOptions",
  ];

  for (const elementId of optionsElements) {
    document.getElementById(elementId).style.display =
      elementId === optionsId ? "block" : "none";
  }
}

function generateName() {
  return `${gender} ${color} ${hairLength} ${personality}`;
}
/*
function updateSelectedText(text) {
  const selectedTextTemplate = `<div class="line">
        <span class="chat-box">${text}</span>
    </div>`;
  document
    .querySelector(".chat-content")
    .insertAdjacentHTML("beforeend", selectedTextTemplate);
}
*/

document.addEventListener("DOMContentLoaded", function () {
  document.querySelector("#send").addEventListener("click", async function () {
	showLoading();
    // generateName 함수 호출 위치 수정

    var template = `<div class="line">
        <span class="chat-box mine">성별이 ${gender}, 털 색상이 ${color}, 털 길이가 ${hairLength}, 그리고 성격이 ${personality} 강아지의 이름을 지어줄래? 그리고 추천 이유도 설명해줘!</span>
    	</div>`; 
    generateName();

    document
      .querySelector(".chat-content")
      //.insertAdjacentHTML("beforeend", template);

    const apiKey = "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"; // open ai_KEY
    const prompt = template;
    try {
      const response = await fetch(
        "https://api.openai.com/v1/chat/completions",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${apiKey}`,
          },
          body: JSON.stringify({
            model: "gpt-3.5-turbo-0613",
            messages: [
              { role: "system", content: "You are a helpful assistant." },
              { role: "user", content: prompt },
            ],
          }),
        }
      );

      const result = await response.json();
      console.log("API 호출 결과:", result);

	  hideLoading();

      if (result.choices && result.choices.length > 0) {
	
		document.querySelector(".chat-content").innerHTML = "";
		
        const chatgptMessage = result.choices[0].message.content;
        console.log("gpt응답", chatgptMessage);

        const assistantMessage = result.choices.find(
          (choice) => choice.message.role === "assistant"
        ).message.content;

        var assistantTemplate = `<div class="line">
                    <span class="chat-box">${assistantMessage}</span>
                </div>`;
		
        document
          .querySelector(".chat-content")
          .insertAdjacentHTML("beforeend", assistantTemplate);
		   
      } else {
        console.log("API 응답에 choices가 없습니다.");
      }
    } catch (error) {
      console.error("API 호출 중 오류:", error);
    }
  });
});

