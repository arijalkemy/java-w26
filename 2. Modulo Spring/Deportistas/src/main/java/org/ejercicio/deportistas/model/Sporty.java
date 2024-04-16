package org.ejercicio.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sporty {
    private String name;
    private String lastName;
    private int age;
    private Sport sport;
}
