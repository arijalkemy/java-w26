package com.practicaSpring.starWars.service;

import com.practicaSpring.starWars.dto.CharacterDTO;
import com.practicaSpring.starWars.repository.ICharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements ICharacterService {
    private ICharacterRepository personajeRepository;

    public CharacterServiceImpl(ICharacterRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<CharacterDTO> matchName(String substring) {
        return personajeRepository.findByString(substring).stream()
                .map(character -> new CharacterDTO(character.getName(), character.getHeight(), character.getMass(),
                        character.getGender(), character.getHomeworld(), character.getSpecies()))
                .collect(Collectors.toList());
    }
}
