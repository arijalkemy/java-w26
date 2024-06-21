package com.mercadolibre.project_be_java_hisp_w26_team5.config;

import com.mercadolibre.project_be_java_hisp_w26_team5.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Profile("!prod")
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf-> csrf.disable())
                .headers(header -> header.frameOptions().disable())
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers(HttpMethod.POST, "/auth/**").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/ping").permitAll()
                        .requestMatchers("/v3/api-docs").permitAll()
                        .requestMatchers("/api/v1/products/{idProduct}/batch/list").hasRole("MANAGER")
                        .requestMatchers("/api/v1/products/{idProduct}/warehouse/list").hasRole("MANAGER")
                        .requestMatchers("/api/v1/batches/batch/list/due-date/{cantDays}").hasRole("MANAGER")
                        .requestMatchers("/api/v1/products/").hasRole("BUYER")
                        .requestMatchers("/api/v1/products/list").hasRole("BUYER")
                        .requestMatchers("/api/v1/purchase-orders").hasRole("BUYER")
                        .requestMatchers("/api/v1/purchase-orders/*").hasRole("BUYER")
                        .requestMatchers("/api/v1/batches/inboundorder").hasRole("MANAGER")
                        .anyRequest().authenticated())
                .sessionManagement( sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}

