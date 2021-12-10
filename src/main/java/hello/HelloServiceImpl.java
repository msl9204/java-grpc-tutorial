package hello;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends hello.HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(hello.HelloRequest request, StreamObserver<hello.HelloResponse> responseObserver) {
        String s = new StringBuffer().append("Hello ").append(request.getFirstName()).append(" ").append(request.getLastName()).toString();

        hello.HelloResponse helloResponse = hello.HelloResponse.newBuilder().setGreeting(s).build();

        System.out.println("response is  = " + helloResponse);

        responseObserver.onNext(helloResponse);
        responseObserver.onCompleted();
    }
}
