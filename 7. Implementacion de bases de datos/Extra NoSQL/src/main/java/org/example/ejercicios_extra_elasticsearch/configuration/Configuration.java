package org.example.ejercicios_extra_elasticsearch.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
