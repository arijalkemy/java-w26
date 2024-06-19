package com.mercadolibre.fresh_market.config.security;

import com.mercadolibre.fresh_market.dtos.AuthDTO;
import com.mercadolibre.fresh_market.dtos.UserDTO;
import com.mercadolibre.fresh_market.model.User;
import com.mercadolibre.fresh_market.repository.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(IUserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public UserDTO register(UserDTO userDto){
        User user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .address(userDto.getAddress())
                .role(userDto.getRole())
                .build();
        userRepository.save(user);
        return userDto;
    }

    public String authenticate(AuthDTO authDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authDto.getEmail(),
                        authDto.getPassword()
                )
        );
        User user = userRepository.findUserByEmail(authDto.getEmail()).orElseThrow();
        HashMap<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("id", user.getId());
        extraClaims.put("role", user.getRole());
        return jwtService.generateToken(extraClaims, user);
    }

    public Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            if (userDetails instanceof User) {
                return ((User) userDetails).getId();
            }
        }
        return null;
    }
}
