const soap = require('soap');

const url = 'http://localhost:3000/wsdl?wsdl';
const args = { name: 'John' };

soap.createClient(url, function (err, client) {
  if (err) throw err;
  client.MyFunction(args, function (err, result) {
    if (err) throw err;
    console.log(result);
  });
});

