package com.mercadolibre.pf_be_hisp_w26_t11_perez.service;

import com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.auth.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.auth.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.auth.RegisterRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t11_perez.jwt.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t11_perez.model.User;
import com.mercadolibre.pf_be_hisp_w26_t11_perez.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService{

    private final IUserRepository repository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDto login(LoginRequestDto userDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()));
        UserDetails user = repository.findByUsername(userDto.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponseDto.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto userToRegisterDto) {
        User user = User.builder()
                .username(userToRegisterDto.getUsername())
                .password(passwordEncoder.encode(userToRegisterDto.getPassword()))
                .firstName(userToRegisterDto.getFirstName())
                .lastName(userToRegisterDto.getLastName())
                .role(userToRegisterDto.getRole())
                .build();

        repository.save(user);

        return AuthResponseDto.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
