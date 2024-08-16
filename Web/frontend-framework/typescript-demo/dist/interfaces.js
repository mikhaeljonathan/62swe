"use strict";
function greeter(person) {
    return `Hello, ${person.firstName} ${person.lastName}`;
}
let user = { firstName: 'Jane', lastName: 'Doe' };
console.log(greeter(user));
