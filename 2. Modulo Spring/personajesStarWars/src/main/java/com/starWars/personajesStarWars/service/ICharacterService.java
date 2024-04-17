package com.starWars.personajesStarWars.service;

import com.starWars.personajesStarWars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> findByName(String name);
}
