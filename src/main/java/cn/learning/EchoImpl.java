package cn.learning;

import io.grpc.stub.StreamObserver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EchoImpl extends EchoServiceGrpc.EchoServiceImplBase {

    @Override
    public void echo(EchoServiceOuterClass.StringMessage request, StreamObserver<EchoServiceOuterClass.StringMessage> responseObserver) {
        EchoServiceOuterClass.StringMessage reply = EchoServiceOuterClass.StringMessage.newBuilder().setValue("Hello " + request.getValue()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getDate(EchoServiceOuterClass.StringMessage request, StreamObserver<EchoServiceOuterClass.StringMessage> responseObserver) {
        EchoServiceOuterClass.StringMessage reply = EchoServiceOuterClass.StringMessage.newBuilder()
                .setValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}