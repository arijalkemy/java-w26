package org.ejercicio.starwars.repository;

import org.ejercicio.starwars.entity.Character;

import java.util.List;

public interface ICharacterRepository {
    List<Character> getCharacters();
}
