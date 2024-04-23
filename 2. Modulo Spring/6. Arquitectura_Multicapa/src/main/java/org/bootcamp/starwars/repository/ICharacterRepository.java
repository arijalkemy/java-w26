package org.bootcamp.starwars.repository;

import org.bootcamp.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterRepository {
    List <CharacterDTO> getCharactersByContains(String query);
}
