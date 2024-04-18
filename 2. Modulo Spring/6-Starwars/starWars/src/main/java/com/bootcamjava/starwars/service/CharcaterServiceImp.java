package com.bootcamjava.starwars.service;

import com.bootcamjava.starwars.dto.CharacterDTO;
import com.bootcamjava.starwars.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharcaterServiceImp implements ICharacterService{
    @Autowired
    CharacterRepository characterRepo;
    @Override
    public ArrayList<CharacterDTO> getAll() {
        return null;
    }

    @Override
    public List<CharacterDTO> findCharacterByName(String name) {
        List<CharacterDTO> response = characterRepo.getAllCharacter().stream()
                .filter(c -> c.getName().contains(name))
                .map(c->new CharacterDTO(c.getName(),c.getHeight(),c.getMass(),c.getGender(),c.getHomeworld(),c.getSpecies()))
                .toList();

        return response;
    }
}
