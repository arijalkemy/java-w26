package com.mercadolibre.final_project_java_hisp_w26_t6.authentication.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.ExceptionDto;
import com.mercadolibre.restclient.http.HttpHeaders;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthFilter extends OncePerRequestFilter {

    private final SecretKey secretKey;

    public JwtAuthFilter(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {

            String token = extractJwtFromRequest(request);

            if (token != null) {
                Claims claims = getClaimsFromToken(token);
                String username = claims.getSubject();
                List<GrantedAuthority> authorities = extractRoleFromToken(claims);

                if (username != null) {

                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            username, null, authorities);
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
            filterChain.doFilter(request, response);

        } catch (JwtException e){
            SecurityContextHolder.clearContext();
            ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
            // Devuelve una respuesta de error 401 con el mensaje de la excepción
            String json = new ObjectMapper().writeValueAsString(exceptionDto);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.getWriter().write(json);
        }

    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }

    private String extractJwtFromRequest(HttpServletRequest request) {

        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }

    private List<GrantedAuthority> extractRoleFromToken(Claims claims) {
        String rol = claims.get("rol", String.class);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(rol));

        return authorities;
    }

}








