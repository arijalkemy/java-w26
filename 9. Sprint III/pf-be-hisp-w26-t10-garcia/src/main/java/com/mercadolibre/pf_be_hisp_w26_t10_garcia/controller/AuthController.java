package com.mercadolibre.pf_be_hisp_w26_t10_garcia.controller;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.IAuthService;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.implementations.AuthServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    IAuthService service;

    public AuthController(AuthServiceImpl service){
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(service.login(loginRequestDto));
    }

}
