package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.controller;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.LoginRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.RegisterRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDto){
        return ResponseEntity.ok(service.login(loginRequestDto));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDto){
        return ResponseEntity.ok(service.register(registerRequestDto));
    }
}
