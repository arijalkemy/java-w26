package bootcamp.spring.calculadora_calorias.models.dtos;

import java.util.List;

import bootcamp.spring.calculadora_calorias.models.Ingrediente;
import bootcamp.spring.calculadora_calorias.models.Plato;
import lombok.Data;

@Data
public class PlatoDTO {
    Integer cantidadCalorias;
    List<Ingrediente> ingredientes;
    Ingrediente ingredienteMayorCalorias;

    public PlatoDTO(Plato plato){
        this.ingredientes = plato.getIngredientes();
        this.ingredienteMayorCalorias = plato.getIngredienteMasCalorico();
    }
}
