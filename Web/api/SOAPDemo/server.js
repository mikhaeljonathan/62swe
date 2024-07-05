const express = require('express');
const soap = require('soap');
const fs = require('fs');
const path = require('path');

const app = express();
const port = 3000;

// Define the service
const service = {
  MyService: {
    MyPort: {
      MyFunction: function (args) {
        return { message: `Hello, ${args.name}` };
      },
    },
  },
};

// Load the WSDL file
const wsdlPath = path.join(__dirname, 'service.wsdl');
const wsdl = fs.readFileSync(wsdlPath, 'utf8');

// Create the SOAP server
app.listen(port, () => {
  console.log(`SOAP service listening on port ${port}`);
  soap.listen(app, '/wsdl', service, wsdl);
});

