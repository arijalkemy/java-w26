package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.service;


import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request.LoginRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request.RegisterRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.AuthResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.jwt.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.Role;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.User;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @Mock
    IUserRepository userRepository;

    @Mock
    JwtService jwtService;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    AuthenticationManager authenticationManager;

    @InjectMocks
    AuthServiceImpl authService;

    @Test
    @DisplayName("Tesitng Login")
    void loginTest() {
        new LoginRequestDTO();
        LoginRequestDTO userDTO = LoginRequestDTO.builder()
                .username("username")
                .password("password")
                .build();

        User user = User.builder()
                .id(1L)
                .role(Role.MANAGER)
                .username("username")
                .password("password")
                .build();

        when(
                userRepository.findByUsername(userDTO.getUsername())
        ).thenReturn(Optional.ofNullable(user));

        when(jwtService.getToken(user)).thenReturn("token");

        new AuthResponseDTO();
        AuthResponseDTO expected = AuthResponseDTO.builder()
                .token("token")
                .build();

        AuthResponseDTO result = authService.login(userDTO);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("testing user register")
    void registerTest() {
        String token = "token";
        RegisterRequestDTO userDTO = new RegisterRequestDTO();
        User user = new User();
        when(jwtService.getToken(user)).thenReturn(token);

        new AuthResponseDTO();
        AuthResponseDTO expected = AuthResponseDTO.builder()
                .token(token)
                .build();

        AuthResponseDTO result = authService.register(userDTO);

        Assertions.assertEquals(expected, result);
    }
}
