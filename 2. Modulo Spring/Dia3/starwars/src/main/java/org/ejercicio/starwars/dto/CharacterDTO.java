package org.ejercicio.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CharacterDTO {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;
}
