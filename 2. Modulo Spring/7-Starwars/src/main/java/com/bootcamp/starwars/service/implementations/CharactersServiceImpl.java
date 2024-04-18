package com.bootcamp.starwars.service.implementations;

import com.bootcamp.starwars.dto.StarWarsCharacterDTO;
import com.bootcamp.starwars.entity.StarWarsCharacter;
import com.bootcamp.starwars.repository.ICharacterRepository;
import com.bootcamp.starwars.service.ICharactersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharactersServiceImpl implements ICharactersService {
    private final ICharacterRepository characterRepository;
    @Override
    public List<StarWarsCharacterDTO> findCharacter(String searchText) {
        List<StarWarsCharacter> starWarsCharacterList = characterRepository.
                getAllCharacters().
                stream().filter(c -> c.getName().contains(searchText))
                .collect(Collectors.toList());

        List<StarWarsCharacterDTO> result = new ArrayList<>();

        if (starWarsCharacterList.size() > 0) {
            for (StarWarsCharacter character: starWarsCharacterList) {
                StarWarsCharacterDTO characterDTO = new StarWarsCharacterDTO(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeworld(),
                        character.getSpecies());
                result.add(characterDTO);
            }
            return result;
        } else {
            return null;
        }
    }
}
