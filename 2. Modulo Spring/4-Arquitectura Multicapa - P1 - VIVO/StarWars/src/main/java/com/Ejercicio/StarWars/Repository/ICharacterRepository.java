package com.Ejercicio.StarWars.Repository;

import com.Ejercicio.StarWars.Entity.Character;


import java.util.List;

public interface IRepository {
    void saveCharacter(List<Character> requestCharacterList);

    List<Character> getCharacters();

}
