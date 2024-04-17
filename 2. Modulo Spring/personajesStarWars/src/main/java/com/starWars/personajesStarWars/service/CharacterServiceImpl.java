package com.starWars.personajesStarWars.service;

import com.starWars.personajesStarWars.dto.CharacterDTO;
import com.starWars.personajesStarWars.model.Character;
import com.starWars.personajesStarWars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    private CharacterRepository repository;

    public List<CharacterDTO> findByName(String name){
        List<Character> characters = repository.findByName(name);
        return characters.stream()
                .map(this::buildCharacterDto)
                .toList();
        
    }

    private CharacterDTO buildCharacterDto(Character character){
        return new CharacterDTO(character.getName(), character.getHeight(),
                character.getMass(), character.getGender(),
                character.getHomeworld(), character.getSpecies());
    }

    private void readJson(){

    }
}
