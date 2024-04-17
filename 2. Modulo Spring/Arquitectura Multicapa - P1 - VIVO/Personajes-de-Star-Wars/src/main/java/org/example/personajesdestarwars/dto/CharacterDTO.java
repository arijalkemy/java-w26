package org.example.personajesdestarwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO implements Serializable {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;
}
