package com.starwars.personajes.service;

import com.starwars.personajes.dto.CharacterDTO;

import java.util.ArrayList;
import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> charactersDTO = new ArrayList<CharacterDTO>();

    List<CharacterDTO> getCharactersByName(String name);

}
