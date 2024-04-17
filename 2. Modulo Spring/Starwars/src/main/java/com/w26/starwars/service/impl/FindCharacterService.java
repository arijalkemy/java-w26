package com.w26.starwars.service.impl;

import com.w26.starwars.dto.CharacterDTO;
import com.w26.starwars.entity.Character;
import com.w26.starwars.repository.CharacterRepository;
import com.w26.starwars.service.IFindCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindCharacterService implements IFindCharacterService {

    private CharacterRepository repository;

    public FindCharacterService()
    {
        this.repository = new CharacterRepository();
    }
    @Override
    public List<CharacterDTO> findCharacters(String nameCharacter) {
        List<CharacterDTO> characterDTOS = new ArrayList<>();
        for (Character c: repository.getCharacters()) {
            if (c.getName().contains(nameCharacter))
                characterDTOS.add(new CharacterDTO(c.getName(), c.getHeight(), c.getMass(), c.getGender(), c.getHomeworld(), c.getSpecies()));
        }
        return  characterDTOS;
    }
}
