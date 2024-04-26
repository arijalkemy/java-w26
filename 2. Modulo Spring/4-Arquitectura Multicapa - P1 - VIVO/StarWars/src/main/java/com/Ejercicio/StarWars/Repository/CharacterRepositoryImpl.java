package com.Ejercicio.StarWars.Repository;

import com.Ejercicio.StarWars.Entity.Character;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CharacterRepositoryImpl implements ICharacterRepository {
    static List<Character> characterList = new ArrayList<>();
    public void saveCharacter(List<Character> requestCharacterList) {
        characterList.addAll(requestCharacterList);
    }

    public List<Character> findCharacters() {
        return characterList;
    }

    @Override
    public Optional<?> findObjectBy(String name) {
        return Optional.ofNullable(characterList);
    }
}



