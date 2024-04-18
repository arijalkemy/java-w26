package starwars.starwars.service;

import starwars.starwars.dto.CharacterDto;
import starwars.starwars.model.Character;

import java.util.List;

public interface ICharacterService {
    public List<CharacterDto
            > searchCharactersByName(String name);
}
