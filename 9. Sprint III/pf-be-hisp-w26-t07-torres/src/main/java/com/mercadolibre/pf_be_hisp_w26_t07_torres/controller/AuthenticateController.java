package com.mercadolibre.pf_be_hisp_w26_t07_torres.controller;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others.TokenResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.RoleEnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateController {
    private final JwtService jwtService;

    public AuthenticateController(@Autowired JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/seller/{id}")
    public ResponseEntity<TokenResponseDto> authenticateSeller(@PathVariable Long id) {
        return new ResponseEntity<>(jwtService.generateToken(RoleEnumUtil.SELLER, id), HttpStatus.OK);
    }

    @GetMapping("/buyer/{id}")
    public ResponseEntity<TokenResponseDto> authenticateBuyer(@PathVariable Long id) {
        return new ResponseEntity<>(jwtService.generateToken(RoleEnumUtil.BUYER, id), HttpStatus.OK);
    }

    @GetMapping("/representative/{id}")
    public ResponseEntity<TokenResponseDto> authenticateRepresentative(@PathVariable Long id) {
        return new ResponseEntity<>(jwtService.generateToken(RoleEnumUtil.REPRESENTATIVE, id), HttpStatus.OK);
    }

    @PostMapping("/token/refresh")
    public ResponseEntity<TokenResponseDto> refreshToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
        return ResponseEntity.ok(jwtService.refreshToken(authorization));
    }
}
