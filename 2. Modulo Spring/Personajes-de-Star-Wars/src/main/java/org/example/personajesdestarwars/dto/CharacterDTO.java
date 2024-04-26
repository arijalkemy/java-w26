package org.example.personajesdestarwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CharacterDTO {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;
}
