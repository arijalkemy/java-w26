package com.Ejercicio.StarWars.Service;

import com.Ejercicio.StarWars.Entity.Character;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface ICharacterService {
    void saveCharacters(List<Character> requestCharacterList);

    List<Character> searchCharacters();

    Character searchCharacterBy(String name);

}
