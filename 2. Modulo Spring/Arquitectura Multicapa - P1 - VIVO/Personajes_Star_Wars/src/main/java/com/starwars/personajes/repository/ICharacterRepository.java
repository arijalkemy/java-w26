package com.starwars.personajes.repository;

import com.starwars.personajes.entity.Character;

import java.util.List;

public interface ICharacterRepository {
    List<Character> getCharacters();
}
