package bootcamp.bendezujonathan.covid.dto.mapping;

import org.modelmapper.ModelMapper;

import bootcamp.bendezujonathan.covid.dto.response.PersonResponse;
import bootcamp.bendezujonathan.covid.model.Person;

public class PersonMapping {

    private static final ModelMapper MAPPER = new ModelMapper();
    PersonMapping() {}

    public static final PersonResponse modelToResponse(Person persona) {
        PersonResponse respone = MAPPER.map(persona, PersonResponse.class);
        respone.setSymptoms(persona.getSymptomString());
        return respone;
    }
}
