package com.studentms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "HELLO-SERVICE", url = "http://localhost:8081")
public interface APIClient {
    @GetMapping("/hello")
    public String helloWorld();
}