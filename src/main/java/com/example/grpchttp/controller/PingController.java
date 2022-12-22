package com.example.grpchttp.controller;

import com.example.grpchttp.service.PingService;
import com.thinhda.spring.grpc.core.model.PingRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class PingController {

    private final PingService pingService;

    @PostMapping("/ping")
    public ResponseEntity<?> ping(@RequestBody PingRequest request) {

        return ResponseEntity.ok(pingService.ping(request));
    }
}
