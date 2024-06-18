package com.mercadolibre.sprint_3_team_12.config;

import com.mercadolibre.sprint_3_team_12.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.ContentSecurityPolicyHeaderWriter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    /**
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated())
                .sessionManagement( sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    } */


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        ContentSecurityPolicyHeaderWriter cspHeaderWriter = new ContentSecurityPolicyHeaderWriter();
        cspHeaderWriter.setPolicyDirectives("frame-ancestors 'self'");

        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers("/h2-console/**", "/auth/**").permitAll()
                                .requestMatchers("/api/v1/demoAdmin").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/demo").hasAuthority("USER")
                                .requestMatchers("/api/v1/fresh-products/inboundorder").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/fresh-products/orders/**").hasAuthority("USER")
                                .requestMatchers("/api/v1/fresh-products/list**").hasAuthority("USER")
                                .requestMatchers("/api/v1/fresh-products/{idProduct}/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/fresh-products/batch/list/due-date/**").hasAuthority("ADMIN")
                                .requestMatchers("/ping", "/v3/api-docs", "/api/v1/index2", "/fake").permitAll()
                        //.anyRequest().authenticated())
                )
                .sessionManagement( sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .headers(headers -> headers.addHeaderWriter(cspHeaderWriter))
                .build();
    }
}
