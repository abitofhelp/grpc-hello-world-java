package com.abitofhelp.grpcHelloWorld;

import io.grpc.stub.StreamObserver;

class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(HelloRequest request,
                         StreamObserver<HelloResponse> responseObserver) {
        // HelloRequest has toString auto-generated.
        System.out.println(request);

        // You must use a builder to construct a new Protobuffer object
        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting("Hello there, " + request.getName())
                .build();

        // Use responseObserver to send a single response back
        responseObserver.onNext(response);

        // When you are done, you must call onCompleted.
        responseObserver.onCompleted();
    }
}