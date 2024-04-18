package com.bootcamp.starwars.repository;


import com.bootcamp.starwars.entity.StarWarsCharacter;

import java.util.List;

public interface ICharacterRepository {
    List<StarWarsCharacter> getAllCharacters();
}
