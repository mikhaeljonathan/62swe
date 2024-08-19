require('./style.scss');
const add = require('./add.js');
const subtract = require('./subtract.js');
const multiply = require('./multiply.js');

let a = add(1, 2);
let b = subtract(a, 7);
let c = multiply(b, 3);

document.getElementById('result').innerHTML = c;