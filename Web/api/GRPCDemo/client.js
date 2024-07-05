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

function main() {
  const client = new helloProto.Greeter('localhost:50051', grpc.credentials.createInsecure());

  const userName = 'world';
  client.sayHello({ name: userName }, (error, response) => {
    if (error) {
      console.error('Error:', error);
    } else {
      console.log('Greeting:', response.message);
    }
  });
}

main();

