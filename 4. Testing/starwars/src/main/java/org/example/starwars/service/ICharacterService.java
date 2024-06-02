package org.example.starwars.service;

import org.example.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> getAllCharactersWithName(String name);
}
