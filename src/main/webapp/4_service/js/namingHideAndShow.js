console.log("hide and show");

let gender, color, hairLength, personality;



function showLoading() {
  document.getElementById("loading").style.display = "block";
  document.getElementById("loadingwords").style.display = "block";
}

function hideLoading() {
  document.getElementById("loading").style.display = "none";
  document.getElementById("loadingwords").style.display = "none";
}

function showButtom(){
	document.getElementById("send").style.display = "block";
}
function hideButtom(){
	document.getElementById("send").style.display = "none";
}
function showRetry(){
	document.getElementById("resend").style.display = "block";
}
function hideTitle(){
	document.getElementById("title").style.display = "none";
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
  showButtom();
  const generatedName = generateName();
  const personalityOptions = document.getElementById("personalityOptions");
  hideTitle();
  personalityOptions.innerHTML = `<div style="display:block;" class="resultImg">
			<img src="4_service/img/naming1.png">
		</div><h2>You've just selected ${gender}, ${color} hair color, ${hairLength} style, and ${personality} personality! Can you push the generate button?!</h2>`  
/* updateSelectedText(
    `${generatedName}을(를) 선택했어여!! generate 버튼을 눌러주세용!!`
  ); */
  generateName();
}

function showOptions(optionsId) {
  const optionsElements = [
	"send",
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
