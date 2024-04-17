package com.ejercicio.starwars.service.implementations;

import com.ejercicio.starwars.DTO.CharactersResponseDTO;
import com.ejercicio.starwars.entity.Character;
import com.ejercicio.starwars.repository.implementations.CharacterRepository;
import com.ejercicio.starwars.repository.interfaces.ICharacterRepository;
import com.ejercicio.starwars.service.interfaces.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService {
    @Autowired
    private ICharacterRepository characterRepository;

    @Override
    public List<CharactersResponseDTO> findCharactersByName(String nameSubstring) {
        return characterRepository.findByName(nameSubstring)
                .stream()
                .map(character -> new CharactersResponseDTO(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeWorld(),
                        character.getSpecies()
                ))
                .toList();
    }
}
