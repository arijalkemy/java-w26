package com.mercadolibre.sprint3_individual_perez.service;

import com.mercadolibre.sprint3_individual_perez.dto.request.LoginRequestDTO;
import com.mercadolibre.sprint3_individual_perez.dto.request.RegisterRequestDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.AuthResponseDTO;
import com.mercadolibre.sprint3_individual_perez.entity.User;
import com.mercadolibre.sprint3_individual_perez.enums.Rol;
import com.mercadolibre.sprint3_individual_perez.jwt.JwtService;
import com.mercadolibre.sprint3_individual_perez.repository.IUserRepository;
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
    public AuthResponseDTO login(LoginRequestDTO userDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()));
        UserDetails user = repository.findByUsername(userDto.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponseDTO.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponseDTO register(RegisterRequestDTO userToRegisterDto) {
        User user = User.builder()
                .username(userToRegisterDto.getUsername())
                .password(passwordEncoder.encode(userToRegisterDto.getPassword()))
                .firstName(userToRegisterDto.getFirstName())
                .lastName(userToRegisterDto.getLastName())
                .role(Rol.USER)
                .build();

        repository.save(user);

        return AuthResponseDTO.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    @Override
    public AuthResponseDTO registerAdmin(RegisterRequestDTO userToRegisterDto) {
        User user = User.builder()
                .username(userToRegisterDto.getUsername())
                .password(passwordEncoder.encode(userToRegisterDto.getPassword()))
                .firstName(userToRegisterDto.getFirstName())
                .lastName(userToRegisterDto.getLastName())
                .role(Rol.ADMIN)
                .build();

        repository.save(user);

        return AuthResponseDTO.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    @Override
    public AuthResponseDTO registerSeller(RegisterRequestDTO userToRegisterDto) {
        User user = User.builder()
                .username(userToRegisterDto.getUsername())
                .password(passwordEncoder.encode(userToRegisterDto.getPassword()))
                .firstName(userToRegisterDto.getFirstName())
                .lastName(userToRegisterDto.getLastName())
                .role(Rol.SELLER)
                .build();

        repository.save(user);

        return AuthResponseDTO.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
