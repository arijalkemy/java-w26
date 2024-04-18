package org.example.multi_layer_p1_starwars.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class CharacterDTO implements Serializable {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

}
