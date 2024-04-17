package org.ggomezr.starwars.application.service.impl;

import org.ggomezr.starwars.application.service.interfaces.ICharacterService;
import org.ggomezr.starwars.domain.dto.CharacterDTO;
import org.ggomezr.starwars.domain.entity.Character;
import org.ggomezr.starwars.domain.repository.impl.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private CharacterRepository repository;
    @Override
    public List<Character> getAllCharacters() throws IOException {
        return repository.getAllCharacters();
    }

    @Override
    public List<CharacterDTO> getCharactersByName(String name) throws IOException {
        return repository.getAllCharacters().stream().filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .map(character -> new CharacterDTO(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeworld(),
                        character.getSpecies()
                )).collect(Collectors.toList());
    }
}
