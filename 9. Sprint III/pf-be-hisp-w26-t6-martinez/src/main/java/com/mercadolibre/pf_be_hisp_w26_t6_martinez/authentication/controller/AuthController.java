package com.mercadolibre.pf_be_hisp_w26_t6_martinez.authentication.controller;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.LoginResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.authentication.IAuthService;
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
