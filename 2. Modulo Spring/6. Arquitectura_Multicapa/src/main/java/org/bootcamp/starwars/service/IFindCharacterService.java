package org.bootcamp.starwars.service;

import org.bootcamp.starwars.dto.CharacterDTO;

import java.util.List;

public interface IFindCharacterService {
    List<CharacterDTO> findCharactersByContains(String query);
}
