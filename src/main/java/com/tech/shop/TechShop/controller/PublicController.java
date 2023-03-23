package com.tech.shop.TechShop.controller;

import com.tech.shop.TechShop.configs.AuthenticationResponse;
import com.tech.shop.TechShop.configs.AuthenticationService;
import com.tech.shop.TechShop.entity.AuthenticationRequest;
import com.tech.shop.TechShop.entity.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/auth")
@RequiredArgsConstructor
public class PublicController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/")
    public String Test(){
        return "Hello !!! ";
    }
}
