package org.example.starwars.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class CharacterDTO implements Serializable {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;
}
