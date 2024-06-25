package com.mercadolibre.pf_be_hisp_w26_t07_torres.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.config.SecurityConfig;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others.DecodedJwt;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others.TokenResponseDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Configuration
public class JWTAuthenticationConfig {
    private final SecurityConfig securityConfig;

    public JWTAuthenticationConfig(@Autowired SecurityConfig securityConfig) {
        this.securityConfig = securityConfig;
    }

    public TokenResponseDto getJWTToken(String username, Map<String, Object> claims) {
        String token = Jwts
                .builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 30))
                .signWith(securityConfig.getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
        return new TokenResponseDto(token);
    }

    public DecodedJwt decodeToken(String token) throws JsonProcessingException {
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payload = new String(decoder.decode(chunks[1]));
        ObjectMapper mapper = new ObjectMapper();
        DecodedJwt decodedJwt = mapper.readValue(payload, DecodedJwt.class);
        return decodedJwt;
    }
}
