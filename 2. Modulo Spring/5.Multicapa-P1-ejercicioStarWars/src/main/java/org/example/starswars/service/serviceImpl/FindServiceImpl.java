package org.example.starswars.service.serviceImpl;

import org.example.starswars.DTO.CharacterDto;
import org.example.starswars.Model.Character;
import org.example.starswars.repository.repositoriesImpl.CharacterRepositoryImpl;
import org.example.starswars.service.IfindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindServiceImpl implements IfindService {
    @Autowired
    CharacterRepositoryImpl starWarsRepository;

    @Override
    public List<CharacterDto> findCharacters(String name) {
        List<Character> characters = starWarsRepository.allCharacters().stream().filter( character -> character.getName().contains(name)).toList();
        List<CharacterDto> charactersDtoList = new ArrayList<>();
        for (Character character: characters){
            charactersDtoList.add(new CharacterDto(character.getName(),character.getHeight(), character.getMass(), character.getGender(), character.getHomeworld(), character.getSpecies()));
        }
        return charactersDtoList;
    }
}
