package com.mercadolibre.project_java_w26_team13.util;

import com.mercadolibre.project_java_w26_team13.entity.User;
import com.mercadolibre.project_java_w26_team13.exceptions.ExceptionsFactory;
import com.mercadolibre.project_java_w26_team13.jwt.JwtService;
import com.mercadolibre.project_java_w26_team13.repository.IUserRepository;
import org.springframework.stereotype.Component;

@Component
public class JWTClaims {

    private final JwtService jwtService;
    private final IUserRepository userRepository;

    public JWTClaims(JwtService jwtService, IUserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    public boolean validateRole(String token, String role) {
        String tokenSubstring = token.substring(7);
        String username = jwtService.getUsernameFromToken(tokenSubstring);

        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            return user.getRole().getName().equals(role);
        }
        return false;
    }

    /**
     * valida que el header sea correcto y que el rol sea el correcto, sino tira excepcion
     *
     * @param authorizationHeader
     * @param role
     */
    public void validateHeader(String authorizationHeader, String role) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw ExceptionsFactory.unauthorizedException("Invalid or missing token");
        }

        if (!validateRole(authorizationHeader, role)) {
            throw ExceptionsFactory.unauthorizedException("User is not authorized");
        }
    }

}
