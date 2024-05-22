package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.repository.CharacterRepository;
import com.example.starwars.repository.ICharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CharacterServiceImpl implements ICharacterService{

    @Autowired
    ICharacterRepo characterRepository;

    @Override
    public List<CharacterDTO> getCharacterByName(String substring) {
        return characterRepository.findAll()
                .stream().
                filter(character -> character.getName().toLowerCase().contains(substring.toLowerCase()))
                .toList();
    }
}
