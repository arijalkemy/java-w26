package com.bootcamp.starwars.Service.Interfaces;

import com.bootcamp.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> getCharacterByName(String name);
}
