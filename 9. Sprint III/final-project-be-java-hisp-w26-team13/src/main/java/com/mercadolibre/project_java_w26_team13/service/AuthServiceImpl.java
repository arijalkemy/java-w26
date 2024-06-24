package com.mercadolibre.project_java_w26_team13.service;


import com.mercadolibre.project_java_w26_team13.dtos.AuthResponseDto;
import com.mercadolibre.project_java_w26_team13.dtos.LoginRequestDto;
import com.mercadolibre.project_java_w26_team13.dtos.RegisterRequestDto;
import com.mercadolibre.project_java_w26_team13.entity.Role;
import com.mercadolibre.project_java_w26_team13.entity.User;
import com.mercadolibre.project_java_w26_team13.jwt.JwtService;
import com.mercadolibre.project_java_w26_team13.repository.IUserRepository;
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
        User user = repository.findByUsername(userDto.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponseDto.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto userToRegisterDto) {
        User user = new User();
        user.setUsername(userToRegisterDto.getUsername());
        user.setPassword(passwordEncoder.encode(userToRegisterDto.getPassword()));
        user.setRole(new Role(1L,"representante"));

        repository.save(user);

        return AuthResponseDto.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
