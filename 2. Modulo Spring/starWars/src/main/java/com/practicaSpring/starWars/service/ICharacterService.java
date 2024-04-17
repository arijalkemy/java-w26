package com.practicaSpring.starWars.service;

import com.practicaSpring.starWars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> matchName(String substring);
}
