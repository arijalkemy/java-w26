package org.bootcamp.starwars.service.impl;

import org.bootcamp.starwars.dto.CharacterResponseDTO;
import org.bootcamp.starwars.mapper.CharacterMapper;
import org.bootcamp.starwars.repository.CharacterRepository;
import org.bootcamp.starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private CharacterMapper characterMapper;


    @Override
    public List<CharacterResponseDTO> getAll() {
        return characterMapper.characterListToCharacterResponseDtoList(characterRepository.getAll());
    }

    @Override
    public List<CharacterResponseDTO> getFindByName(String name) {
        return characterMapper.characterListToCharacterResponseDtoList(characterRepository.getByName(name));
    }
}
