package com.mercadolibre.final_project_java_hisp_w26_t1.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Profile("local")
public class SecurityConfigurationLocalEnviroment {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf
                        .ignoringRequestMatchers(toH2Console())
                        .disable()).authorizeHttpRequests(auth -> auth
                        .requestMatchers(toH2Console()).permitAll())
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers("/ping").permitAll()
                                .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                                .requestMatchers(HttpMethod.GET,"/v3/api-docs/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
                                .anyRequest().authenticated())
                .sessionManagement(
                        session -> session
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);



        return http.build();
    }
}
