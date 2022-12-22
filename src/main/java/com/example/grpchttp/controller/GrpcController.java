package com.example.grpchttp.controller;

import com.example.grpchttp.service.PingService;
import com.thinhda.spring.grpc.core.model.CoreServiceGrpc;
import com.thinhda.spring.grpc.core.model.PingRequest;
import com.thinhda.spring.grpc.core.model.PingResponse;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@Slf4j
@GRpcService
@RequiredArgsConstructor
public class GrpcController extends CoreServiceGrpc.CoreServiceImplBase {

    private final PingService pingService;

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {

        responseObserver.onNext(pingService.ping(request));
        responseObserver.onCompleted();
    }
}
