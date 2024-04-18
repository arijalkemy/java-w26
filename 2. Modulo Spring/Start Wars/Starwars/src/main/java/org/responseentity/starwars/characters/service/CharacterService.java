package org.responseentity.starwars.characters.service;

import org.responseentity.starwars.characters.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    List<CharacterDTO> findCharacterByName(String characterName);
}
