package org.example.ejerciciocalculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Setter @Getter
public class IngredientsDTO {
    private String name;
    private Double calories;
}
