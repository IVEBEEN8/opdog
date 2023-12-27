//import config from "./config.js";
//const {API_KEY} = config;



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
  personalityOptions.innerHTML = `<h2>You've just selected ${gender}, ${color} hair color, ${hairLength} style, and ${personality} personality! Can you push the generate button?!</h2>`
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


document.addEventListener("DOMContentLoaded", function () {
  document.querySelector("#send").addEventListener("click", async function () {
	showLoading();
    // generateName 함수 호출 위치 수정
	const apiKey = "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";
    var template = `<div class="line">
        <span class="chat-box mine">Can you name a dog that gender is ${gender},has ${color} hair color, ${hairLength} style and ${personality} personality? Also explain the reason why you recommand the name!</span>
    	</div>`; 
    generateName();

    document
      .querySelector(".chat-content")
      //.insertAdjacentHTML("beforeend", template);

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

