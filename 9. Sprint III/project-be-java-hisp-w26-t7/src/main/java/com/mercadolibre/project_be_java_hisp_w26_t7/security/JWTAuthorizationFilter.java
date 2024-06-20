package com.mercadolibre.project_be_java_hisp_w26_t7.security;

import com.mercadolibre.project_be_java_hisp_w26_t7.config.SecurityConfig;
import com.mercadolibre.project_be_java_hisp_w26_t7.exceptions.JwtException;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {
    private final String prefix;
    private final String header;
    private final SecurityConfig securityConfig;

    public JWTAuthorizationFilter(@Autowired SecurityConfig securityConfig, @Autowired JwtService jwtService) {
        this.prefix = "Bearer ";
        this.securityConfig = securityConfig;
        this.header = HttpHeader.AUTHORIZATION.asString();
    }

    private boolean isJWTValid(String authHeader) {
        return authHeader != null && authHeader.startsWith(prefix);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(header);
        if (isJWTValid(authHeader)) {
            authHeader = authHeader.replace(prefix, "");
            try {
                String tokenId = securityConfig.getUsernameFromToken(authHeader);
                String tokenRole = securityConfig.getRole(authHeader);
                UserDetails userDetails = User.builder()
                        .username(tokenId)
                        .password("")
                        .roles(tokenRole)
                        .build();
                UsernamePasswordAuthenticationToken userAuthToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(userAuthToken);
            } catch (ExpiredJwtException | MalformedJwtException e) {
                throw new JwtException("No is possible validate the JWT token");
            }
        }
        filterChain.doFilter(request, response);
    }
}