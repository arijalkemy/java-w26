package org.example.starwars.services;

import org.example.starwars.dto.CharacterDto;

import java.util.List;

public interface ICharacter {
    List<CharacterDto> getCharacters(String search);
}
