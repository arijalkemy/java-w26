package com.demospring.profilesdemo.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevConfig {

    @PostConstruct
    public void initialize(){
        System.out.println("\n--------------------------------------------------DevConfig initialized--------------------------------------------------\n");
    }
}
