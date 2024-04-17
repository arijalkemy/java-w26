package bootcamp.bendezujonathan.starwars.service.interfaces;

import java.util.List;
import java.util.Optional;

import bootcamp.bendezujonathan.starwars.model.Character;

public interface ICharacterService {

    List<Character> findAll();
    Optional<Character> findContainingName(String name);
}
