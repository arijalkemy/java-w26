package bootcamp.bendezujonathan.recetas.dto.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.bendezujonathan.recetas.dto.response.PlatoResponse;
import bootcamp.bendezujonathan.recetas.model.Plato;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlatoMapping {
    
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static PlatoResponse toResponse(Plato model){
        return MAPPER.convertValue(model, PlatoResponse.class);
    }

}
