package com.ejercicio.starwars.services.implementations;

import com.ejercicio.starwars.models.Character;
import com.ejercicio.starwars.repositories.CharacterRepository;
import com.ejercicio.starwars.services.interfaces.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<Character> findCharactersByName(String nameSubstring) {
        return characterRepository.findByName(nameSubstring);
    }
}
