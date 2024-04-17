package com.starwars.personajes.service;

import com.starwars.personajes.dto.CharacterDTO;
import com.starwars.personajes.entity.Character;
import com.starwars.personajes.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> getCharactersByName(String name) {
            List<Character> characters = characterRepository.getCharacters();
            List<CharacterDTO> characterDTOs = characters.stream()
                    .filter(character -> character.getName().contains(name))
                    .map(character -> new CharacterDTO(
                            character.getName(),
                            character.getHeight(),
                            character.getMass(),
                            character.getGender(),
                            character.getHomeworld(),
                            character.getSpecies()
                    ))
                    .collect(Collectors.toList());
            return characterDTOs;
    }
}
