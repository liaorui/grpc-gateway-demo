package cn.learning;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class DateServer {

    private Server server;

    private void start() throws IOException {
        int port = 9091;
        server = ServerBuilder.forPort(port)
                .addService(new DateImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                DateServer.this.stop();
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
        final DateServer server = new DateServer();
        server.start();
        server.blockUntilShutdown();
    }

}
