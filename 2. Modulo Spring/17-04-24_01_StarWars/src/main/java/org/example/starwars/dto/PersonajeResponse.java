package org.example.starwars.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeResponse {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;
}

