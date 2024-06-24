package com.mercadolibre.project_java_w26_team13.controller;


import com.mercadolibre.project_java_w26_team13.dtos.LoginRequestDto;
import com.mercadolibre.project_java_w26_team13.dtos.RegisterRequestDto;
import com.mercadolibre.project_java_w26_team13.service.AuthServiceImpl;
import com.mercadolibre.project_java_w26_team13.service.IAuthService;
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

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto registerRequestDto){
        return ResponseEntity.ok(service.register(registerRequestDto));
    }
}
