package com.mercadolibre.pf_be_hisp_w26_t6_martinez.controller;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.UserDto.RegisterUserDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.user.IUsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserController {

    @Autowired
    IUsersService usersService;

    // REQ 6 - ENDPOINT 1
    @PreAuthorize("hasAuthority('SUPERADMIN')")
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserDto registerUserDto){
        usersService.register(registerUserDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
