package com.spring.starwars.service;

import com.spring.starwars.dto.StarWarsCharacterDTO;
import com.spring.starwars.repository.StarWarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsService implements IStarWarsService {

    private final StarWarsRepository starWarsRepository;

    public StarWarsService() {
        this.starWarsRepository = new StarWarsRepository();
    }

    @Override
    public List<StarWarsCharacterDTO> searchStarWarsCharacter(String name) {
        return starWarsRepository.getStarWarsCharacters()
                .stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .map(StarWarsCharacterDTO::new)
                .toList();
    }

}
