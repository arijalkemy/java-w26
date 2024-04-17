package org.mercadolibre.multicapatemplate.service.impl;

import org.mercadolibre.multicapatemplate.dto.CharacterResponseDTO;
import org.mercadolibre.multicapatemplate.entity.Character;
import org.mercadolibre.multicapatemplate.repository.CharacterRepository;
import org.mercadolibre.multicapatemplate.service.ICharacterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {

    CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterResponseDTO> findAll() {
        return characterRepository
                .findAll()
                .stream()
                .map( (character) -> new CharacterResponseDTO(character))
                .toList();
    }

    @Override
    public List<CharacterResponseDTO> findAllWith(String partialName) {
        return characterRepository
                .findAll()
                .stream()
                .filter( x -> x.getName().contains(partialName))
                .map((character) -> new CharacterResponseDTO(character))
                .toList();
    }
}
