package org.example.ejerciciocalculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor @Getter @Setter
public class DishDTO {
    private String name;
    private Integer weight;
    private List<IngredientsDTO> ingredients;
}
