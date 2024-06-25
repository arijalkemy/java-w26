package com.mercadolibre.pf_be_hisp_w26_t07_torres.config.variables;

import com.mercadolibre.secretclient.SecretClient;
import com.mercadolibre.secretclient.SecretClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"prod", "test"})
public class VariablesProdConfig {
    private final SecretClient secretClient;

    public VariablesProdConfig() {
        this.secretClient = SecretClientBuilder.builder()
                .client()
                .withRequestTimeout(9000)
                .build();
    }

    @Bean
    public String JwtSecret() {
        return secretClient.getSecret("JWT_SECRET");
    }
}
