package com.example.starwars_vivo.service.impl;

import com.example.starwars_vivo.dto.CharacterDTO;
import com.example.starwars_vivo.entity.Character;
import com.example.starwars_vivo.repository.StarWarsRepository;
import com.example.starwars_vivo.service.ICharacter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterImpl implements ICharacter {
    public StarWarsRepository repository = new StarWarsRepository();
    public List<Character> listCharacters = repository.readCharactersFromJson();
    private List<CharacterDTO> listCharactersDTO = null;

    @Override
    public List<CharacterDTO> getAllCharacters() {
        if (listCharactersDTO == null){
            fillListCharacterDTO();
        }
        return listCharactersDTO;
    }

    @Override
    public List<CharacterDTO> getCharacterByName(String name) {
        if (listCharactersDTO == null){
            fillListCharacterDTO();
        }
        return listCharactersDTO.stream().filter(c -> c.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    public void fillListCharacterDTO(){
        listCharactersDTO = new ArrayList<>();
        for(Character c: listCharacters){
            listCharactersDTO.add(new CharacterDTO(c.getName(),c.getHeight(),c.getMass(),c.getGender(),c.getHomeworld(),c.getSpecies()));
        }
    }
}
