package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.impl;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.LoginRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.RegisterRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.LoginResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.enums.Role;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error.RegisterException;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.jwt.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.UserEntity;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IUserRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IAuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthServiceImpl implements IAuthService {

    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(IUserRepository repository,
                           JwtService jwtService,
                           PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager) {
        this.userRepository = repository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO userDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(),
                userDto.getPassword()));
        UserDetails user = userRepository
                .findByUsername(userDto.getUsername())
                .orElseThrow();
        String token = jwtService.getToken(user);
        return LoginResponseDTO
                .builder()
                .token(token)
                .build();
    }

    @Override
    public LoginResponseDTO register(RegisterRequestDTO userToRegisterDto) {

        if (userRepository.existsByUsername(userToRegisterDto.getUsername()))
            throw new RegisterException();

        UserEntity user = UserEntity
                .builder()
                .username(userToRegisterDto.getUsername())
                .password(passwordEncoder.encode(userToRegisterDto.getPassword()))
                .role(Role.getRole(userToRegisterDto.getRole()))
                .firstName(userToRegisterDto.getFirstName())
                .lastName(userToRegisterDto.getLastName())
                .registrationDate(Instant.now())
                .build();

        userRepository.save(user);

        return LoginResponseDTO
                .builder()
                .token(jwtService.getToken(user))
                .build();
    }


}
