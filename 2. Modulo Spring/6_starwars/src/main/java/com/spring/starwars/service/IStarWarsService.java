package com.spring.starwars.service;

import com.spring.starwars.dto.StarWarsCharacterDTO;

import java.util.List;

public interface IStarWarsService {

    List<StarWarsCharacterDTO> searchStarWarsCharacter(String name);

}
