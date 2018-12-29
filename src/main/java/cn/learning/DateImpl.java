package cn.learning;

import io.grpc.stub.StreamObserver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateImpl extends DateServiceGrpc.DateServiceImplBase {

    @Override
    public void getDate(DateServiceOuterClass.DateMessage request, StreamObserver<DateServiceOuterClass.DateMessage> responseObserver) {
        DateServiceOuterClass.DateMessage reply = DateServiceOuterClass.DateMessage.newBuilder()
                .setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}