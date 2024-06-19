package com.mercadolibre.pf_be_hisp_w26_t11_perez.config;

import com.mercadolibre.pf_be_hisp_w26_t11_perez.jwt.JwtAuthenticationFilter;
import com.mercadolibre.pf_be_hisp_w26_t11_perez.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf-> csrf
                        .ignoringRequestMatchers(toH2Console())
                        .disable())
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers("/api/v1/fresh-products/inboundorder/**").hasAuthority(Role.WAREHOUSE.name())
                        .requestMatchers("/api/v1/fresh-products/{idProduct}/warehouse/list").hasAuthority(Role.WAREHOUSE.name())
                        .requestMatchers(HttpMethod.POST,"/api/v1/fresh-products/orders").hasAuthority(Role.BUYER.name())
                        .requestMatchers(HttpMethod.PUT,"/api/v1/fresh-products/orders").hasAuthority(Role.BUYER.name())
                        .requestMatchers("/api/v1/products/list").hasAuthority(Role.BUYER.name())
                        .requestMatchers("/api/v1/fresh-products/orders/{orderId}").hasAuthority(Role.BUYER.name())
                        .requestMatchers("/api/v1/fresh-products/{idProduct}/batch/list").hasAuthority(Role.WAREHOUSE.name())
                        .requestMatchers("/api/v1/fresh-products/batch/list/due-date/{cantDays}").hasAuthority(Role.WAREHOUSE.name())
                        .requestMatchers("/api/v1/expired-batches").hasAuthority(Role.WAREHOUSE.name())
                        .anyRequest().permitAll()
                )

                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .sessionManagement( sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
