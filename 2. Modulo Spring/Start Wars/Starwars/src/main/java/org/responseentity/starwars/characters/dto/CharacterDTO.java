package org.responseentity.starwars.characters.dto;

import lombok.Data;

@Data
public class CharacterDTO {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

}
