package org.responseentity.starwars.characters.service;

import org.responseentity.starwars.characters.dto.CharacterDTO;
import org.responseentity.starwars.characters.entity.CharacterEntity;
import org.responseentity.starwars.characters.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImp implements CharacterService{

    @Autowired
    CharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> findCharacterByName(String characterName) {
        List<CharacterEntity> characters = this.characterRepository.findCharacterByName(characterName);
        List<CharacterDTO> charactersToReturn = new ArrayList<>();

        for(CharacterEntity cha: characters){
            CharacterDTO characterDTO = new CharacterDTO();
            characterDTO.setName(cha.getName());
            characterDTO.setMass(cha.getMass());
            characterDTO.setSpecies(cha.getSpecies());
            characterDTO.setHeight(cha.getHeight());
            characterDTO.setGender(cha.getGender());
            characterDTO.setHomeworld(cha.getHomeworld());
             charactersToReturn.add(characterDTO);
        }

        return charactersToReturn;
    }
}
