package com.mercadolibre.project_be_java_hisp_w26_t7.config.variables;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local", "integration_test"})
public class VariablesLocalConfig {
    @Value("${secrets.JWT_SECRET}")
    private String jwtSecretValue;

    @Bean
    public String JwtSecret() {
        return jwtSecretValue;
    }
}
