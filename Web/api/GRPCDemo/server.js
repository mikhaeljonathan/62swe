const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');
const packageDefinition = protoLoader.loadSync(
  './helloworld.proto',
  {
    keepCase: true,
    longs: String,
    enums: String,
    defaults: true,
    oneofs: true
  }
);
const helloProto = grpc.loadPackageDefinition(packageDefinition).helloworld;

// Implement the SayHello RPC method
function sayHello(call, callback) {
  callback(null, { message: 'Hello ' + call.request.name });
}

// Create and start the gRPC server
function main() {
  const server = new grpc.Server();
  server.addService(helloProto.Greeter.service, { sayHello: sayHello });
  server.bindAsync('0.0.0.0:50051', grpc.ServerCredentials.createInsecure(), () => {
    server.start();
    console.log('Server running at http://0.0.0.0:50051');
  });
}

main();

