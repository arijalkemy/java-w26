package bootcamp.bendezujonathan.starwars.dto.mapping;

import org.modelmapper.ModelMapper;

import bootcamp.bendezujonathan.starwars.model.Character;
import bootcamp.bendezujonathan.starwars.dto.response.CharacterResponse;

public class CharacterMapping {

    CharacterMapping(){}
    
    private static final ModelMapper MAPPER = new ModelMapper();

    public static CharacterResponse characterToResponse(Character character) {
        return MAPPER.map(character, CharacterResponse.class);
    }

}
