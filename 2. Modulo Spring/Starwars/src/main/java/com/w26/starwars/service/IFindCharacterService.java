package com.w26.starwars.service;

import com.w26.starwars.dto.CharacterDTO;

import java.util.List;

public interface IFindCharacterService {

    public List<CharacterDTO> findCharacters(String nameCharacter);
}
