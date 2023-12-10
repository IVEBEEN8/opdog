document.addEventListener("DOMContentLoaded", function () {
    document.querySelector("#send").addEventListener("click", async function () {
        var template = `<div class="line">
            <span class="chat-box mine">${document.querySelector("#input").value}</span>
        </div>`;
        document.querySelector(".chat-content").insertAdjacentHTML("beforeend", template);

        const apiKey = "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"; // open ai_KEY
        const prompt = document.querySelector("#input").value;

        try {
            const response = await fetch("https://api.openai.com/v1/chat/completions", {
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
            });

            const result = await response.json();
            console.log("API 호출 결과:", result);

            const chatResponse =
                result.choices && result.choices[0]
                ? result.choices[0].message
                : "응답이 없습니다.";

            const chatgptMessage = result.choices[0].message.content;
            console.log("gpt응답", chatgptMessage);

            // 챗봇 응답 출력
            const assistantMessage = result.choices.find(
                (choice) => choice.message.role === "assistant"
            ).message.content;

            var assistantTemplate = `<div class="line">
                <span class="chat-box">${assistantMessage}</span>
            </div>`;
            document.querySelector(".chat-content").insertAdjacentHTML("beforeend", assistantTemplate);
        } catch (error) {
            console.error("API 호출 중 오류:", error);
            // 오류에 대한 추가 처리를 할 수 있습니다.
        }
    });
});


         
    