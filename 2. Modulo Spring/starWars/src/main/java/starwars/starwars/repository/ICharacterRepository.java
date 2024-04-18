package starwars.starwars.repository;

import starwars.starwars.model.Character;

import java.util.List;

public interface ICharacterRepository {
    public void searchAllCharacters();

    public List<Character> searchCharactersByName(String name);
}
