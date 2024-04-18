package bootcamp.spring.calculadora_calorias.models;

import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Plato {

    private String nombre;
    private List<Ingrediente> ingredientes;

    public Ingrediente getIngredienteMasCalorico(){
        return ingredientes
            .stream()
            .max(Comparator.comparing(Ingrediente::getCalorias)).get();
    }

    public Integer calcularCantidadCalorias(Integer gramos){
        return ingredientes.stream().mapToInt(Ingrediente::getCalorias).sum() * gramos / 100;
    }
}
