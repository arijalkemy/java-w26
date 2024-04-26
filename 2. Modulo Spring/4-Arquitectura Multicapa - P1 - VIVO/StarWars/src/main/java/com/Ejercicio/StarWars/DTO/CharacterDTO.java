package com.Ejercicio.StarWars.DTO;

import lombok.Data;
import java.io.Serializable;
@Data
public class CharacterDTO implements Serializable {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;
}
