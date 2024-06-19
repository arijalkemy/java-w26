package com.mercadolibre.final_project_java_h_w26_t10.controller;

import com.mercadolibre.final_project_java_h_w26_t10.dtos.LoginRequestDto;
import com.mercadolibre.final_project_java_h_w26_t10.service.implementations.AuthServiceImpl;
import com.mercadolibre.final_project_java_h_w26_t10.service.IAuthService;
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
