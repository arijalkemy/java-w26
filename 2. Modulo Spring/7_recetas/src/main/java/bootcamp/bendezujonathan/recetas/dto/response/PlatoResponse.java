package bootcamp.bendezujonathan.recetas.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoResponse {
    private String name;
    private double totalCalories;
    private List<IngredienteResponse> ingredientes;
    private IngredienteResponse maxCalories;
}
