package cn.learning;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.6.1)",
    comments = "Source: date_service.proto")
public final class DateServiceGrpc {

  private DateServiceGrpc() {}

  public static final String SERVICE_NAME = "cn.learning.DateService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cn.learning.DateServiceOuterClass.DateMessage,
      cn.learning.DateServiceOuterClass.DateMessage> METHOD_GET_DATE =
      io.grpc.MethodDescriptor.<cn.learning.DateServiceOuterClass.DateMessage, cn.learning.DateServiceOuterClass.DateMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "cn.learning.DateService", "getDate"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.learning.DateServiceOuterClass.DateMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.learning.DateServiceOuterClass.DateMessage.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DateServiceStub newStub(io.grpc.Channel channel) {
    return new DateServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DateServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DateServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DateServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDate(cn.learning.DateServiceOuterClass.DateMessage request,
        io.grpc.stub.StreamObserver<cn.learning.DateServiceOuterClass.DateMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DATE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_DATE,
            asyncUnaryCall(
              new MethodHandlers<
                cn.learning.DateServiceOuterClass.DateMessage,
                cn.learning.DateServiceOuterClass.DateMessage>(
                  this, METHODID_GET_DATE)))
          .build();
    }
  }

  /**
   */
  public static final class DateServiceStub extends io.grpc.stub.AbstractStub<DateServiceStub> {
    private DateServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DateServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DateServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DateServiceStub(channel, callOptions);
    }

    /**
     */
    public void getDate(cn.learning.DateServiceOuterClass.DateMessage request,
        io.grpc.stub.StreamObserver<cn.learning.DateServiceOuterClass.DateMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DATE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DateServiceBlockingStub extends io.grpc.stub.AbstractStub<DateServiceBlockingStub> {
    private DateServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DateServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DateServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DateServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.learning.DateServiceOuterClass.DateMessage getDate(cn.learning.DateServiceOuterClass.DateMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DATE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DateServiceFutureStub extends io.grpc.stub.AbstractStub<DateServiceFutureStub> {
    private DateServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DateServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DateServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DateServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.learning.DateServiceOuterClass.DateMessage> getDate(
        cn.learning.DateServiceOuterClass.DateMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DATE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DateServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DateServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DATE:
          serviceImpl.getDate((cn.learning.DateServiceOuterClass.DateMessage) request,
              (io.grpc.stub.StreamObserver<cn.learning.DateServiceOuterClass.DateMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class DateServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.learning.DateServiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DateServiceDescriptorSupplier())
              .addMethod(METHOD_GET_DATE)
              .build();
        }
      }
    }
    return result;
  }
}
