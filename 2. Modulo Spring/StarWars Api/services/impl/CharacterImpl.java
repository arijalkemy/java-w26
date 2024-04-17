package org.example.starwars.services.impl;

import org.example.starwars.dto.CharacterDto;
import org.example.starwars.respositories.CharacterRepository;
import org.example.starwars.respositories.ICharacterRepository;
import org.example.starwars.services.ICharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CharacterImpl implements ICharacter {
    private final ICharacterRepository characterRepository;

    public CharacterImpl(@Autowired ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDto> getCharacters(String search) {
        return this.characterRepository.listCharacters()
                .stream()
                .map(character -> new CharacterDto(
                        character.getName(), character.getHeight(),
                        character.getMass(), character.getGender(),
                        character.getHomeworld(), character.getSpecies()
                ))
                .filter(character -> {
                    if (search.trim().isEmpty()) return true;
                    return (character.getName().contains(search.trim()));
                })
                .toList();
    }
}
