package org.example.starwars.service;

import org.example.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacter {
    List<CharacterDTO> getAllCharactersWithName(String name);
}
