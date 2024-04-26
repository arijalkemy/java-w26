package com.Ejercicio.StarWars.Repository;
import com.Ejercicio.StarWars.Entity.Character;
import java.util.List;
import java.util.Optional;

public interface ICharacterRepository {
    void saveCharacter(List<Character> requestCharacterList);
    List<Character> findCharacters();

    Optional<?> findObjectBy(String name);
}
