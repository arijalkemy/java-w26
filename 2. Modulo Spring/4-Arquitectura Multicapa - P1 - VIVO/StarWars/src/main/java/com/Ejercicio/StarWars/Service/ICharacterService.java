package com.Ejercicio.StarWars.Service;


import com.Ejercicio.StarWars.DTO.CharacterDTO;
import com.Ejercicio.StarWars.Entity.Character;
import java.util.List;

public interface ICharacter {
    void saveCharacters(List<Character> requestCharacterList);

    List<Character> getCharacters();
}
