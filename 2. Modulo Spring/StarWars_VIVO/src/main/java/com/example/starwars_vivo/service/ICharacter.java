package com.example.starwars_vivo.service;

import com.example.starwars_vivo.dto.CharacterDTO;

import java.util.List;

public interface ICharacter {
    public List<CharacterDTO> getAllCharacters();
    public List<CharacterDTO> getCharacterByName(String name);
}
