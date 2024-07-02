function changeColor() {
    document.getElementById("paragraph").style.color = "red";
}

// const buttonElement = document.getElementById("changeButton");
// buttonElement.addEventListener("click", changeColor);

const buttonElement = document.getElementsByClassName("changeButton")[0];
buttonElement.addEventListener("click", changeColor);

let pElement = buttonElement.previousElementSibling.nodeValue;

const para = document.createElement("p");
const node = document.createTextNode("This is new.");
para.appendChild(node);

const element = document.getElementById("div1");
element.appendChild(para);


// setInterval(myFunction, 2000);

// function myFunction () {
//     console.log("hello");
// }

// window.alert("halo");