const footerYear = document.querySelector(".footer-year");

const handleCurrentYear = () => {
    footerYear.innerText = (new Date()).getFullYear();
}
console.log(new Date().getFullYear())
handleCurrentYear();