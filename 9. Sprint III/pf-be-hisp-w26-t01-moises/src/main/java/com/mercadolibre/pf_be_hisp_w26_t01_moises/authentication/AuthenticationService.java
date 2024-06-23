package com.mercadolibre.pf_be_hisp_w26_t01_moises.authentication;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.Role;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.User;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.repository.IUserRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.security.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces.IRoleServiceInternal;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final HttpServletRequest request;
    private final IRoleServiceInternal roleServiceInternal;
    public AuthenticationResponse register(RegisterRequest request) {

        Role role = roleServiceInternal.searchById(request.getIdRole());
        User user = User.builder()
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .email(request.getEmail())
                        .role(role)
                        .build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    public String getLogMail() {
        String jwt = request.getHeader("Authorization").replace("Bearer ", "");
        return jwtService.extractUsername(jwt);
    }
}
