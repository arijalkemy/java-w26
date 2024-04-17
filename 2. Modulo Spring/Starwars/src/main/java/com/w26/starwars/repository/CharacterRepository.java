package com.w26.starwars.repository;

import com.w26.starwars.entity.Character;
import com.w26.starwars.util.StarWarsLoader;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterRepository {
    private static List<Character> repository;

    private @Getter List<Character> characters;

    public CharacterRepository()
    {
        if (CharacterRepository.repository == null)
        {
            repository = StarWarsLoader.loadStarWarsInfo();
        }
        this.characters = CharacterRepository.repository;
    }

}
