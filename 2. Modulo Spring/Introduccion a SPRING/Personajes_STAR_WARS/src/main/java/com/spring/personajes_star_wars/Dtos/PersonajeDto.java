package com.spring.personajes_star_wars.Dtos;

import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.io.Serializable;



public class PersonajeDto implements Serializable {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

}
