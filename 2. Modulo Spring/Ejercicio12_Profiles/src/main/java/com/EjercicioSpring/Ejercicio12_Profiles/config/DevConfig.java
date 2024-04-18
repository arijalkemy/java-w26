package com.EjercicioSpring.Ejercicio12_Profiles.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevConfig {

    @PostConstruct //Ayuda a que se ejecuta cuando se inicie el programa
    public void initilize() {
        System.out.println("------------Iniciando el ambiente de DEV------------");
    }

}
