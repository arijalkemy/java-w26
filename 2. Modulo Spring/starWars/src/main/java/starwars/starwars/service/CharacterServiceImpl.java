package starwars.starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import starwars.starwars.dto.CharacterDto;
import starwars.starwars.model.Character;
import starwars.starwars.repository.ICharacterRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {

    ICharacterRepository characterRepository;

    public CharacterServiceImpl(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<CharacterDto> searchCharactersByName(String name) {
        List<Character> characters= this.characterRepository.searchCharactersByName(name);
        return characters.stream().map(this::generateCharacterDto).toList();
    }

    public CharacterDto generateCharacterDto(Character character) {
        return new CharacterDto(character.getName(), character.getHeight(),
                character.getMass(), character.getGender(), character.getHomeworld(), character.getSpecies());
    }

}
