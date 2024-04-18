package meli.bootcamp.starwars.service;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.starwars.dto.CharacterDto;
import meli.bootcamp.starwars.dto.mapper.Mapper;
import meli.bootcamp.starwars.repository.StarWarsRepository;
import meli.bootcamp.starwars.service.interfaces.ICharacter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterImpl implements ICharacter {
    private final StarWarsRepository starWarsRepository;

    @Override
    public List<CharacterDto> getByName(String name) {
        return starWarsRepository.findAll().stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .map(Mapper::toStarWarsCharDto)
                .toList();
    }
}
