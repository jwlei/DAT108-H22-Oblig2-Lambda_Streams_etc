"use strict"

let validYear = /^[0-9]{4}$/;

let yearInput = document.getElementById("search_input");

yearInput.addEventListener("change", validateYear);

function validateYear() {
    if (yearInput.value === "") {
        document.getElementById("search_input").style.borderColor = "null";
    } else if (validYear.test(yearInput.value)) {
        document.getElementById("search_input").style.borderColor = "green";
    } else {
        document.getElementById("search_input").style.borderColor = "red";
    }
}