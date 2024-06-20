package com.mercadolibre.fresh_market.controller;

import com.mercadolibre.fresh_market.config.security.AuthService;
import com.mercadolibre.fresh_market.dtos.AuthDTO;
import com.mercadolibre.fresh_market.dtos.ResponseJWTDTO;
import com.mercadolibre.fresh_market.dtos.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fresh-products/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Register new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User registered successfully",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AuthService.class))
                    }),
            @ApiResponse(responseCode = "403", description = "User could not be registered", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDto) {
        return new ResponseEntity<>(authService.register(userDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Authenticate user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User authenticated successfully",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AuthService.class))
                    }),
            @ApiResponse(responseCode = "403", description = "User could not be authenticated", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("")
    public ResponseEntity<?> authenticate(@RequestBody AuthDTO authDto) {
        return ResponseEntity.ok().body(new ResponseJWTDTO(authService.authenticate(authDto)));
    }
}
