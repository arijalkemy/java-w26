package com.mercadolibre.sprint_3_team_12.controller;

import com.mercadolibre.sprint_3_team_12.dto.request.LoginRequestDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.RegisterRequestDTO;
import com.mercadolibre.sprint_3_team_12.service.AuthServiceImpl;
import com.mercadolibre.sprint_3_team_12.service.IAuthService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDto){
        return new ResponseEntity<>(service.login(loginRequestDto), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDto){
        return new ResponseEntity<>(service.register(registerRequestDto), HttpStatus.CREATED);
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<?> registerAdmin(@RequestBody RegisterRequestDTO registerRequestDto){
        return new ResponseEntity<>(service.registerAdmin(registerRequestDto), HttpStatus.CREATED);
    }
}
