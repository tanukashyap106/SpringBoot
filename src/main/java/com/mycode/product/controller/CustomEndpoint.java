package com.mycode.product.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="custom")
public class CustomEndpoint {
    @ReadOperation
    public String getCustome() {
        return "This is a custom endpoint";
    }
}
