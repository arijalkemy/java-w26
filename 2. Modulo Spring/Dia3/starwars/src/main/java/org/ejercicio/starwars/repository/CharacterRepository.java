package org.ejercicio.starwars.repository;

import org.ejercicio.starwars.entity.Character;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacterRepository implements ICharacterRepository{
    @Override
    public List<Character> getCharacters() {
        return MockDB.simulaBD();
    }
}
