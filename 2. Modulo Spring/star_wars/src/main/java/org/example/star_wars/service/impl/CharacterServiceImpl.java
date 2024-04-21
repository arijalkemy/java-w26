package org.example.star_wars.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.star_wars.dto.CharacterDTO;
import org.example.star_wars.repository.CharacterRepositoryImp;
import org.example.star_wars.service.ICharacterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {

    private CharacterRepositoryImp characterRepository;

    public CharacterServiceImpl() {
        characterRepository = new CharacterRepositoryImp();
    }

    @Override
    public List<CharacterDTO> findByName(String name) {
        ObjectMapper mapper= new ObjectMapper();
        return characterRepository.getAllCharacters().stream().filter(x->x.getName().toUpperCase().toUpperCase().contains(name.toUpperCase())).map(x->
            mapper.convertValue(x,CharacterDTO.class)).toList();
    }

    @Override
    public List<CharacterDTO> findAll() {
        ObjectMapper mapper= new ObjectMapper();
        return characterRepository.getAllCharacters().stream().map(x-> mapper.convertValue(x, CharacterDTO.class) ).toList();
    }
}
