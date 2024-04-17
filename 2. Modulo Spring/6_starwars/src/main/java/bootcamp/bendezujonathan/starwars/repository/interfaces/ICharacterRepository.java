package bootcamp.bendezujonathan.starwars.repository.interfaces;

import java.util.List;
import bootcamp.bendezujonathan.starwars.model.Character;

public interface ICharacterRepository {


    List<Character> findAll();
}
