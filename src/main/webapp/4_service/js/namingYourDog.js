let gender, color, hairLength, personality;

function selectGender(selectedGender) {
    gender = selectedGender;
    showOptions('colorOptions');
	hid
}

function selectColor(selectedColor) {
    color = selectedColor;
    showOptions('hairLengthOptions');
}

function selectHairLength(selectedHairLength) {
    hairLength = selectedHairLength;
    showOptions('personalityOptions');
}

function selectPersonality(selectedPersonality) {
    personality = selectedPersonality;
    generateName();
}

function showOptions(optionsId) {
    // 선택한 옵션 이후의 옵션을 표시하고 이전 옵션들을 숨김
    document.getElementById(optionsId).style.display = 'block';
    document.getElementById('genderOptions').style.display = 'none';
    document.getElementById('colorOptions').style.display = 'none';
    document.getElementById('hairLengthOptions').style.display = 'none';
}

function generateName() {
    const generatedName = `${gender} ${color} ${hairLength} ${personality}`;
    document.getElementById('generatedName').innerText = `생성된 이름: ${generatedName}`;
}