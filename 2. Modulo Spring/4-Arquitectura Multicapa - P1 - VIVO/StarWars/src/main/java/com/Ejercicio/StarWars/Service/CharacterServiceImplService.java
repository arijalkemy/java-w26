package com.Ejercicio.StarWars.Service;

import com.Ejercicio.StarWars.DTO.CharacterDTO;
import com.Ejercicio.StarWars.Entity.Character;
import com.Ejercicio.StarWars.Repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CharacterServiceImplService implements ICharacterService {

    @Autowired
    ICharacterRepository iCharacterRepository;

    @Override
    public void saveCharacters(List<Character> requestCharacterList) {
            iCharacterRepository.saveCharacter(requestCharacterList);
    }

    @Override
    public List<Character> searchCharacters() {
        return iCharacterRepository.findCharacters();
    }

    @Override
    public Character searchCharacterBy(String name) {
        List<Character> characterList = iCharacterRepository.findCharacters();
        return characterList.stream()
                .filter(character -> character.getName().equals(name))
                .findAny()
                .orElse(null);
    }

}
