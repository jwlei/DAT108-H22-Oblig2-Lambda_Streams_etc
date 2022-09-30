"use strict"

// Simple regEx to check if the input is a number 0-9999
let validYear = /^[0-9]{4}$/;

// Event listener for the input field
let yearInput = document.getElementById("search_input");
// On keyup, call the validateYear function
yearInput.addEventListener("change", validateYear);


function validateYear() {
    // Check if the input is valid year and give the user feedback by coloring the border
    // of the input field
    if (yearInput.value === "") {
        document.getElementById("search_input").style.borderColor = "null";
    } else if (validYear.test(yearInput.value) && (yearInput.value >= 1426 && yearInput.value <= 1648)) {
        document.getElementById("search_input").style.borderColor = "green";
    } else {
        document.getElementById("search_input").style.borderColor = "red";
    }
}