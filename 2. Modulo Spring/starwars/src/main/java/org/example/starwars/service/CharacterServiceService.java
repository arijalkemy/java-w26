package org.example.starwars.service;

import org.example.starwars.dto.CharacterDTO;
import org.example.starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CharacterServiceService implements ICharacterService {
    @Autowired
    CharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> getAllCharactersWithName(String name) {
        return characterRepository.getCharactersByName(name);
    }
}
