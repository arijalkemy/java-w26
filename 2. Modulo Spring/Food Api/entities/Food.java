package org.example.calories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Food {
    private String name;
    private List<String> ingredients;
}
