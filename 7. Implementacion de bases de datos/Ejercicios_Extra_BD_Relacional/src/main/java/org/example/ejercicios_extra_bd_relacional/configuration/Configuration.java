package org.example.ejercicios_extra_bd_relacional.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
