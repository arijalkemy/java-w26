package org.example.integradorstarwars.service.impl;

import org.example.integradorstarwars.dto.CharacterDTO;
import org.example.integradorstarwars.model.Character;
import org.example.integradorstarwars.repository.CharacterRepository;
import org.example.integradorstarwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CharacterServiceImp implements ICharacterService<CharacterDTO> {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterServiceImp(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> findByName(String name) throws IOException {
        List<CharacterDTO> characterDTOList = new ArrayList<>();

        for (Character ch : characterRepository.loadData()){
            if (ch.getName().contains(name)){
                CharacterDTO characterDTO = new CharacterDTO(
                      ch.getName(),
                      ch.getHeight(),
                      ch.getMass(),
                      ch.getGender(),
                      ch.getHomeWorld(),
                      ch.getSpecies()
                );
                characterDTOList.add(characterDTO);
            }
        };
        return characterDTOList;
    }
}
