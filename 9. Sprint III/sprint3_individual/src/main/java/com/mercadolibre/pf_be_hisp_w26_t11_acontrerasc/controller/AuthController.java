package com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.controller;

import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.auth.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.auth.RegisterRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.service.AuthServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.service.IAuthService;
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
