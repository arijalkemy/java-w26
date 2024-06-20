package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.AuthResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.LoginRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.RegisterRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Rol;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.jwt.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.IUserRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

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
        UserAccount user = UserAccount.builder()
                .username(userToRegisterDto.getUsername())
                .password(passwordEncoder.encode(userToRegisterDto.getPassword()))
                .firstName(userToRegisterDto.getFirstName())
                .lastName(userToRegisterDto.getLastName())
                .userRole(Rol.BUYER)
                .build();

        repository.save(user);

        return AuthResponseDto.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
