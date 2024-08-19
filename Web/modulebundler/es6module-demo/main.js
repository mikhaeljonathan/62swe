import {add} from './add.js';
import kurang from './subtract.js';
import multiply, {asdf} from './multiply.js';

let a = add(1, 2);
let b = kurang(a, 7);
let c = multiply(b, 2);

console.log(asdf);

document.getElementById('result').innerHTML = c;