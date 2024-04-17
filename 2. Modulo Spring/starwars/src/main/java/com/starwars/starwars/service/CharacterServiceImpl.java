package com.starwars.starwars.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.starwars.starwars.dto.CharacterResponseDto;
import com.starwars.starwars.repository.IRepository;
import com.starwars.starwars.model.CharacterModel;

@Service
public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    IRepository characterRepository;
    
    @Override
    public List<CharacterResponseDto> findByName(String name) {
        List<CharacterModel> characters = this.characterRepository.findByName(name);
        List<CharacterResponseDto> charactersResponse = new ArrayList<>();

        for (CharacterModel cha: characters){
            CharacterResponseDto characterDto = new CharacterResponseDto();
            characterDto.setName(cha.getName());
            characterDto.setMass(cha.getMass());
            characterDto.setSpecies(cha.getSpecies());
            characterDto.setHeight(cha.getHeight());
            characterDto.setGender(cha.getGender());
            characterDto.setHomeworld(cha.getHomeworld());
            charactersResponse.add(characterDto);
        }

        return charactersResponse;
    }
}
