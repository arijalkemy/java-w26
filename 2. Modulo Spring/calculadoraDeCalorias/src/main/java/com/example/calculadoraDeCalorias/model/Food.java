package com.example.calculadoraDeCalorias.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    private String name;
    private Integer weight;
    private List<String> ingredients;
}
