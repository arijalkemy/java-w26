package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.StarWarsCharacterDTO;

import java.util.List;

public interface ICharactersService {
    List<StarWarsCharacterDTO> findCharacter(String searchText);
}
