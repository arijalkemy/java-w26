package bootcamp.bendezujonathan.covid.dto.mapping;

import org.modelmapper.ModelMapper;

import bootcamp.bendezujonathan.covid.dto.response.SymptomResponse;
import bootcamp.bendezujonathan.covid.model.Symptom;

public class SymptomMapping {

    private static final ModelMapper MAPPER = new ModelMapper();
    
    SymptomMapping(){}

    public static SymptomResponse symptomToDto(Symptom model) {
        return MAPPER.map(model, SymptomResponse.class);
    }
}
