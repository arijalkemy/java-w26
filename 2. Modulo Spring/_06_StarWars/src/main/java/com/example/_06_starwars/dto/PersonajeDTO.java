package com.example._06_starwars.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class PersonajeDTO {
    private String nombre;
    private String genero;
    private String mundoNatal;
    private String especie;
    private int peso;
    private int altura;

    public PersonajeDTO(){

    }
}
