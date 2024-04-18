package bootcamp.bendezujonathan.recetas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteResponse {
    private String name;
    private int calories;
}
