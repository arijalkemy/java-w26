package org.example.personajesdestarwars.service;


import org.example.personajesdestarwars.dto.CharacterDTO;
import org.example.personajesdestarwars.entity.Character;
import org.example.personajesdestarwars.repository.CharactersRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CharacterServiceImpl implements ICharactersService{
    @Override
    public List<CharacterDTO> getCharactersByPartOfTheirName(String name) throws IOException {
        List<CharacterDTO> foundCharacters = new ArrayList<>();
        for (Character character :CharactersRepository.getAllCharacters()){
            int height;
            if (!Objects.equals(character.getHeight(), "NA")){
                height = Integer.parseInt(character.getHeight());
            }else{
                height = 0;
            }
            int mass;
            if (!Objects.equals(character.getMass(), "NA")){
                mass = Integer.parseInt(character.getMass());
            }else{
                mass = 0;
            }

if (character.getName().contains(name)){

            CharacterDTO characterDTO = new CharacterDTO(
                    character.getName(),
//                    Integer.parseInt(character.getHeight()),
//                    Integer.parseInt(character.getMass()),
                    height,
                    mass,
                    character.getGender(),
                    character.getHomeworld(),
                    character.getSpecies()
            );
            foundCharacters.add(characterDTO);
}
        };
        return foundCharacters;
    }
}
