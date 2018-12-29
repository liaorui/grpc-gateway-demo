### 安装go和grpc-gateway环境
[grpc-gateway](https://github.com/grpc-ecosystem/grpc-gateway#installation)

### 生成go gRPC stub
```
protoc -I/usr/local/include -I. \
  -I$GOPATH/src \
  -I$GOPATH/src/github.com/grpc-ecosystem/grpc-gateway/third_party/googleapis \
  --go_out=plugins=grpc:src/main/go/cn_learning \
  echo_service.proto
```

### 生成go proxy
```
protoc -I/usr/local/include -I. \
  -I$GOPATH/src \
  -I$GOPATH/src/github.com/grpc-ecosystem/grpc-gateway/third_party/googleapis \
  --grpc-gateway_out=logtostderr=true:src/main/go/cn_learning \
  echo_service.proto
```

### 生成java proto解析类
```
protoc -I. \
  -I$GOPATH/src/github.com/grpc-ecosystem/grpc-gateway/third_party/googleapis \
  echo_service.proto \
  --java_out=src/main/java 
```

### 生成java gRPC具体实现类
```
protoc -I/usr/local/include -I. \
  -I$GOPATH/src \
  -I$GOPATH/src/github.com/grpc-ecosystem/grpc-gateway/third_party/googleapis \
  --plugin=protoc-gen-grpc=grpc_java_plugin \
  --grpc-java_out=src/main/java \
  echo_service.proto
```

### 运行go gateway
```
go run src/main/go/gateway.go
```

### 运行java程序
EchoServer.java

### 测试
```
curl -X POST http://localhost:8080/v1/example/echo -d '{"value": ", World!"}'
```
