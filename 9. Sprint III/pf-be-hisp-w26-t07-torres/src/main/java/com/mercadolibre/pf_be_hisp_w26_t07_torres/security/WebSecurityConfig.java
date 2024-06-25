package com.mercadolibre.pf_be_hisp_w26_t07_torres.security;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.config.handler.JwtAccessDeniedConfig;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.config.handler.JwtEntryPointConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    private final JWTAuthorizationFilter jwtAuthorizationFilter;
    private final JwtEntryPointConfig jwtEntryPointConfig;
    private final JwtAccessDeniedConfig accessDeniedConfig;

    public WebSecurityConfig(@Autowired JWTAuthorizationFilter jwtAuthorizationFilter,
                             @Autowired JwtEntryPointConfig jwtEntryPointConfig,
                             @Autowired JwtAccessDeniedConfig accessDeniedConfig) {
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
        this.jwtEntryPointConfig = jwtEntryPointConfig;
        this.accessDeniedConfig = accessDeniedConfig;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/api/v1/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/v1/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/v1/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/ping").permitAll()
                        .anyRequest().permitAll())
                .exceptionHandling(e ->
                        e.authenticationEntryPoint(jwtEntryPointConfig)
                                .accessDeniedHandler(accessDeniedConfig))
                .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .headers(httpSecurityHeadersConfigurer -> {
                    httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable);
                });
        return http.build();
    }
}
