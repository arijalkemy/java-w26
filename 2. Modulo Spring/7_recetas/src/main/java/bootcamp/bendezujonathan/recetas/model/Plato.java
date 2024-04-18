package bootcamp.bendezujonathan.recetas.model;

import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {

    private String name;
    private double weight;
    private List<Ingrediente> ingredientes;
    private double totalCalories;

    public Ingrediente getMaxCalories() {
        return this.ingredientes.stream()
                 .max(Comparator.comparing(Ingrediente::getCalories))
                 .get();
    }

}
