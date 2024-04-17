package org.ggomezr.starwars.application.service.interfaces;

import org.ggomezr.starwars.domain.dto.CharacterDTO;
import org.ggomezr.starwars.domain.entity.Character;

import java.io.IOException;
import java.util.List;

public interface ICharacterService {
    List<Character> getAllCharacters() throws IOException;

    List<CharacterDTO> getCharactersByName(String name) throws IOException;
}
