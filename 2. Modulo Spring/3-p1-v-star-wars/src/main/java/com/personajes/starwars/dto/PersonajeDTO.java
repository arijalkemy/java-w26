package com.personajes.starwars.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PersonajeDTO implements Serializable {

    private String name;

    private Integer height;

    private Integer mass;

    private String gender;

    private String homeWorld;

    private String species;

}
