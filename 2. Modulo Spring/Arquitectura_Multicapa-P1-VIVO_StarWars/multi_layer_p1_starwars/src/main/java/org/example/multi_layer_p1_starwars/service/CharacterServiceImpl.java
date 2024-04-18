package org.example.multi_layer_p1_starwars.service;

import org.example.multi_layer_p1_starwars.dto.CharacterDTO;
import org.example.multi_layer_p1_starwars.entity.Character;
import org.example.multi_layer_p1_starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements ICharacterService{
    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> findByName(String name) {
        List<Character> characterList = characterRepository.getAllCharacters();
        return characterList.stream()
                .filter(ch -> ch.getName().toLowerCase().contains(name.toLowerCase()))
                .map(this::streamToCharDTO)
                .collect(Collectors.toList());
    }

    private CharacterDTO streamToCharDTO(Character character) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setGender(character.getGender());
        characterDTO.setName(character.getName());
        characterDTO.setMass(character.getMass());
        characterDTO.setHeight(character.getHeight());
        characterDTO.setSpecies(character.getSpecies());
        characterDTO.setHomeworld(character.getHomeworld());
        return characterDTO;
    }
}
