package org.example.starwars.repository;

import org.example.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {
    public List<CharacterDTO> getCharactersByName(String name);
}
