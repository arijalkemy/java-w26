package bootcamp.bendezujonathan.starwars.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.starwars.repository.interfaces.ICharacterRepository;
import bootcamp.bendezujonathan.starwars.service.interfaces.ICharacterService;
import lombok.RequiredArgsConstructor;
import bootcamp.bendezujonathan.starwars.model.Character;

@Service
@RequiredArgsConstructor
public class CharacterService implements ICharacterService {

    private final ICharacterRepository repository;

    @Override
    public List<Character> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Character> findContainingName(String name) {
        return repository.findAll()
                .stream()
                .filter(character -> character.nameContains(name))
                .findFirst();
    }

}
