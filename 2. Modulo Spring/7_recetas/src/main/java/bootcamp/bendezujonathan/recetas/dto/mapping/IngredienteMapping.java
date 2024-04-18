package bootcamp.bendezujonathan.recetas.dto.mapping;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.bendezujonathan.recetas.dto.response.IngredienteResponse;
import bootcamp.bendezujonathan.recetas.model.Ingrediente;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IngredienteMapping {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    public static IngredienteResponse modelToResponse(Ingrediente model){
        return MAPPER.convertValue(model, IngredienteResponse.class);
    }

    public static  List<IngredienteResponse> modelToResponse(List<Ingrediente> models) {
        return MAPPER.convertValue(models, new TypeReference<List<IngredienteResponse>>() {});
    }

}
