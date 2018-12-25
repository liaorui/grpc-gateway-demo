package cn.learning;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class EchoServer {

    private Server server;

    private void start() throws IOException {
        int port = 9090;
        server = ServerBuilder.forPort(port)
                .addService(new EchoImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                EchoServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final EchoServer server = new EchoServer();
        server.start();
        server.blockUntilShutdown();
    }

}
