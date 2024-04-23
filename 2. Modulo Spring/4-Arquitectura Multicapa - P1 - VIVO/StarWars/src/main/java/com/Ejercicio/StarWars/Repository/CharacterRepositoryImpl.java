package com.Ejercicio.StarWars.Repository;

import com.Ejercicio.StarWars.DTO.CharacterDTO;
import com.Ejercicio.StarWars.Entity.Character;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CharacterCharacterRepositoryImpl implements ICharacterRepository {
    List<Character> characterList;
    public void saveCharacter(List<Character> requestCharacterList) {
        characterList = new ArrayList<>();
        characterList.addAll(requestCharacterList);
    }

    public List<Character> getCharacters() {
        return characterList;
    }
}



