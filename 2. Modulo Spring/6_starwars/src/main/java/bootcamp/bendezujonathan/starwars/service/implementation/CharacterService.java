package bootcamp.bendezujonathan.starwars.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.starwars.repository.interfaces.ICharacterRepository;
import bootcamp.bendezujonathan.starwars.service.interfaces.ICharacterService;
import bootcamp.bendezujonathan.starwars.model.Character;

@Service
public class CharacterService implements ICharacterService {

    @Override
    public List<Character> findAll() {
        return ICharacterRepository.findAll();
    }

    @Override
    public Optional<Character> findContainingName(String name) {
        return ICharacterRepository.findAll()
                .stream()
                .filter(character -> character.nameContains(name))
                .findFirst();
    }

}
