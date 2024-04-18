package meli.bootcamp.calculadora.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private String name;
    private List<Ingredient> ingredients;
}
