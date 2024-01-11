import config from "./config.js";
const { API_KEY } = config;

window.onload = function send() {
  document.getElementById("send").click();
	var audiosend = new Audio('4_service/audio/send.m4a')
  if (document.getElementById("input").value.trim() !== "") {
    document.getElementById("input").value = "";
	audiosend.playbackRate =1.2;
	audiosend.play();
  }


 console.log("imhere~")
document.getElementById("input").addEventListener("keyup", function (event) {
   	var inputValue = document.getElementById("input").value;
	if(inputValue.trim() != ""){
	if (event.keyCode === 13) {
		
     document.getElementById("send").click();
			document.getElementById("input").value = "";
			audiosend.playbackRate = 1.2;
			audiosend.play();
        }
	 }
    });
  };


document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("input").focus();
  document.querySelector("#send").addEventListener("click", async function () {
    document.getElementById("input").focus();
    var template = `<div class="line"><span class="chat-box mine">
	${document.querySelector("#input").value}</span></div>`;
    console.log(template);
    document
      .querySelector(".chat-box-wrap1-2")
      .insertAdjacentHTML("beforeend", template);
    const chatBoxWrap = document.querySelector(".chat-box-wrap1-2");
    chatBoxWrap.scrollTop = chatBoxWrap.scrollHeight;
    const prompt = document.querySelector("#input").value;
    console.log(prompt);
    if (prompt == null) {
      prompt = document.querySelector("#input").value;
    }
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
	  

      if (result.choices && result.choices.length > 0) {
        const chatgptMessage = result.choices[0].message.content;
        console.log("gpt응답", chatgptMessage);
        const assistantMessage = result.choices.find(
          (choice) => choice.message.role === "assistant"
        ).message.content;

        var assistantTemplate = `<div class="line"><span class="chat-box">${assistantMessage}</span></div>`;
        document
          .querySelector(".chat-box-wrap1-2")
          .insertAdjacentHTML("beforeend", assistantTemplate);
		var audioreceive = new Audio('4_service/audio/receive.m4a');
		audioreceive.playbackRate = 1.2;
		audioreceive.play();

        const chatBoxWrap = document.querySelector(".chat-box-wrap1-2");
        chatBoxWrap.scrollTop = chatBoxWrap.scrollHeight;
      } else {
        console.log("API 응답에 choices가 없습니다.");
      }
    } catch (error) {
      console.error("API 호출 중 오류:", error);
    }
  });
});
