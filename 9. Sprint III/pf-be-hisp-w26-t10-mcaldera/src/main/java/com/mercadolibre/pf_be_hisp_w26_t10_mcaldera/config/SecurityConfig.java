package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.config;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Rol;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/ping").permitAll()
                        .requestMatchers("/fake").permitAll()
                       // .requestMatchers("/api/v1/fresh-products/inboundorder").permitAll()
                        .requestMatchers("/v3/api-docs").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/api/v1/fresh-products/*/warehouse/list").hasAnyAuthority(String.valueOf(Rol.SUPERVISOR))
                        .requestMatchers("/api/v1/fresh-products/orders/**").hasAnyAuthority(Rol.BUYER.name(),Rol.SUPERVISOR.name())
                        .requestMatchers("/api/v1/fresh-products/*/batch/**").hasAnyAuthority(String.valueOf(Rol.SUPERVISOR))
                        .requestMatchers("/api/v1/fresh-products/list").permitAll()
                        /* INDIVIDUAL */
                        .requestMatchers("/api/v1/fresh-products/*").hasAnyAuthority(String.valueOf(Rol.SELLER))
                        .requestMatchers("/api/v1/fresh-products/*/*").hasAnyAuthority(String.valueOf(Rol.SELLER))
                        .requestMatchers("/api/v1/fresh-products/*/*").hasAnyAuthority(String.valueOf(Rol.SELLER))
                        .requestMatchers("/api/v1/fresh-products/list-items-seller").hasAnyAuthority(String.valueOf(Rol.SUPERVISOR))
                        .anyRequest().authenticated())
                .sessionManagement( sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
