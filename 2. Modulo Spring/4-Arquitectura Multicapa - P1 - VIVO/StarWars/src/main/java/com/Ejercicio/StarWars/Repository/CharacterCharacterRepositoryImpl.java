package com.Ejercicio.StarWars.Repository;

import com.Ejercicio.StarWars.Entity.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepositoryImpl implements IRepository{
    List<Character> characterList;
    public void saveCharacter(List<Character> requestCharacterList) {
        characterList = new ArrayList<>();
        characterList.addAll(requestCharacterList);
    }

    public List<Character> getCharacters() {
        return characterList;
    }
}



