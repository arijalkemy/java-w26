package com.mercadolibre.project_be_java_hisp_w26_t7.controller;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others.TokenResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.JwtService;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.enums.RoleEnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
