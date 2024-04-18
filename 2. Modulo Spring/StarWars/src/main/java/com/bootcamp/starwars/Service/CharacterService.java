package com.bootcamp.starwars.Service;

import com.bootcamp.starwars.Service.Interfaces.ICharacterService;
import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.entity.Character;
import com.bootcamp.starwars.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService {

    @Override
    public List<CharacterDTO> getCharacterByName(String name) {
        //List<Character> listita = CharacterRepository.getAllCharacters();

        List<CharacterDTO> lista = CharacterRepository.getAllCharacters().stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .map(c ->  convertToDto(c)).toList();
        System.out.println(lista);
        return lista;
    }

    public CharacterDTO convertToDto(Character c){
        CharacterDTO cDto = new CharacterDTO();

        cDto.setName(c.getName());
        cDto.setHeight(c.getHeight());
        cDto.setMass(c.getMass());
        cDto.setGender(c.getGender());
        cDto.setSpecies(c.getSpecies());
        cDto.setHomeworld(c.getHomeworld());

        return cDto;
    }
}
