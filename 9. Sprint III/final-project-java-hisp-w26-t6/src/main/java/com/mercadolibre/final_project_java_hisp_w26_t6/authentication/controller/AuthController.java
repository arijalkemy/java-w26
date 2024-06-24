package com.mercadolibre.final_project_java_hisp_w26_t6.authentication.controller;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.LoginRequestDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.LoginResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.services.authentication.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginDto){

        LoginResponseDto loginResponse = authService.login(loginDto);

        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
