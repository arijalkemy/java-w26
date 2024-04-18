package org.ejercicio.starwars.service.implementation;

import org.ejercicio.starwars.dto.CharacterDTO;
import org.ejercicio.starwars.repository.ICharacterRepository;
import org.ejercicio.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CharacterImpl implements ICharacterService {

    @Autowired
    private ICharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> findAllCharactersByName(String name) {
        return characterRepository.getCharacters().stream().map(
                character -> {
                    return new CharacterDTO(character.getName(),character.getHeight(),character.getMass(),
                            character.getGender(),character.getHomeWorld(),character.getSpecies());
                }
        ).filter(characterDTO -> characterDTO.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }
}
