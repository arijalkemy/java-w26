package com.mercadolibre.project_be_java_hisp_w26_team4.controller;

import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request.LoginRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request.RegisterRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.service.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Validated
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO loginRequestDto){
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDTO registerRequestDto){
        return ResponseEntity.ok(authService.register(registerRequestDto));
    }
}
