package cn.learning;

import io.grpc.stub.StreamObserver;

public class EchoImpl extends EchoServiceGrpc.EchoServiceImplBase {

    @Override
    public void echo(EchoServiceOuterClass.StringMessage request, StreamObserver<EchoServiceOuterClass.StringMessage> responseObserver) {
        EchoServiceOuterClass.StringMessage reply = EchoServiceOuterClass.StringMessage.newBuilder().setValue("Hello " + request.getValue()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}