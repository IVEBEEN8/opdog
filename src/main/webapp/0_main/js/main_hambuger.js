const toggleBtn = document.querySelector(".navbar_toogleBtn");
const menu = document.querySelector(".nav-var");
const icons = document.querySelector(".header-r");
const background = document.querySelector(".main_header");

toggleBtn.addEventListener("click", () => {
  menu.classList.toggle("active");
  icons.classList.toggle("active");
  background.classList.toggle("active");
});
