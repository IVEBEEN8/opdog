
import config from "./config.js";
const {API_KEY} = config;

console.log("api hello ?")

document.addEventListener("DOMContentLoaded", function () {
  document.querySelector("#send").addEventListener("click", async function () {
	showLoading();
    // generateName 함수 호출 위치 수정
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
            Authorization: `Bearer ${API_KEY}`,
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
	  hideButtom();
	  showRetry();
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
		
		
      } 
		else {
        console.log("API 응답에 choices가 없습니다.");
      }
    } catch (error) {
      console.error("API 호출 중 오류:", error);
    }
  });
});

