package com.mercadolibre.project_be_java_hisp_w26_team5.service;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.LoginRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.RegisterRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.LoginResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error.RegisterException;
import com.mercadolibre.project_be_java_hisp_w26_team5.jwt.JwtService;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.UserEntity;
import com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces.IUserRepository;
import com.mercadolibre.project_be_java_hisp_w26_team5.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AuthServiceImplTest {

    @InjectMocks
    private AuthServiceImpl authService;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @Test
    @DisplayName("Login with valid credentials returns token")
    public void loginWithValidCredentialsReturnsToken() {
        //Arrange
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setUsername("testUser");
        loginRequestDTO.setPassword("testPassword");

        UserEntity user = new UserEntity();
        user.setUsername("testUser");

        when(userRepository.findByUsername(any(String.class))).thenReturn(Optional.of(user));
        when(jwtService.getToken(any(UserEntity.class))).thenReturn("testToken");

        //Act
        LoginResponseDTO response = authService.login(loginRequestDTO);


        //Assert
        assertEquals("testToken", response.getToken());
    }

    @Test
    @DisplayName("Register with valid details returns token")
    public void registerWithValidDetailsReturnsToken() {
        //Arrange
        RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
        registerRequestDTO.setUsername("testUser");
        registerRequestDTO.setPassword("testPassword");
        registerRequestDTO.setFirstName("Test");
        registerRequestDTO.setLastName("User");
        registerRequestDTO.setRole("BUYER");

        UserEntity user = new UserEntity();
        user.setUsername("testUser");

        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedPassword");
        when(userRepository.save(any(UserEntity.class))).thenReturn(user);
        when(jwtService.getToken(any(UserEntity.class))).thenReturn("testToken");

        //Act
        LoginResponseDTO response = authService.register(registerRequestDTO);


        //Assert
        assertEquals("testToken", response.getToken());
    }


    @Test
    @DisplayName("Register with username that already exists throws exception RegisterException")
    public void registerWithExistingUsernameThrowsException() {
        //Arrange
        RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
        registerRequestDTO.setUsername("testUser");
        registerRequestDTO.setPassword("testPassword");
        registerRequestDTO.setFirstName("Test");
        registerRequestDTO.setLastName("User");
        registerRequestDTO.setRole("BUYER");

        when(userRepository.existsByUsername(any(String.class))).thenReturn(true);

        //Act and Assert
        assertThrows(RegisterException.class, () -> authService.register(registerRequestDTO));
    }
}