package spring.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class Dish {
    private String name;
    private double weight;
    private List<Ingredient> ingredients;


}
