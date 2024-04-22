package org.example.starwars.service;

import lombok.Data;
import org.example.starwars.dto.CharacterDTO;
import org.example.starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CharacterService implements ICharacter {
    @Autowired
    CharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> getAllCharactersWithName(String name) {
        return characterRepository.getCharactersByName(name);
    }
}
