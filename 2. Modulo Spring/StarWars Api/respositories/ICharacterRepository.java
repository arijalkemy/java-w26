package org.example.starwars.respositories;

import org.example.starwars.entities.Character;

import java.util.List;

public interface ICharacterRepository {
    List<Character> listCharacters();
}
