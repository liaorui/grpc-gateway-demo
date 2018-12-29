package main

import (
  "flag"
  "net/http"

  "github.com/golang/glog"
  "golang.org/x/net/context"
  "github.com/grpc-ecosystem/grpc-gateway/runtime"
  "google.golang.org/grpc"

  gw "./cn_learning"
)

var (
  echoEndpoint = flag.String("echo_endpoint", "localhost:9090", "echo_endpoint")
  dateEndpoint = flag.String("date_endpoint", "localhost:9091", "date_endpoint")
)

func run() error {
  ctx := context.Background()
  ctx, cancel := context.WithCancel(ctx)
  defer cancel()

  mux := runtime.NewServeMux()
  opts := []grpc.DialOption{grpc.WithInsecure()}
  err := gw.RegisterEchoServiceHandlerFromEndpoint(ctx, mux, *echoEndpoint, opts)
  if err != nil {
    return err
  }
  err = gw.RegisterDateServiceHandlerFromEndpoint(ctx, mux, *dateEndpoint, opts)
  if err != nil {
    return err
  }

  return http.ListenAndServe(":8080", mux)
}

func main() {
  flag.Parse()
  defer glog.Flush()

  if err := run(); err != nil {
    glog.Fatal(err)
  }
}
