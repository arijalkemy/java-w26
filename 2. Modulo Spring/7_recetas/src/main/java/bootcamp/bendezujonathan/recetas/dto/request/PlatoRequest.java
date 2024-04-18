package bootcamp.bendezujonathan.recetas.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoRequest {
    private String name;
    private List<String> ingredientes;
    private double peso;
}
