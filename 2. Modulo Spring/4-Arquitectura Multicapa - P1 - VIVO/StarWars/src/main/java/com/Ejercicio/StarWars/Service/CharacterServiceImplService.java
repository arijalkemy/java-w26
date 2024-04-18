package com.Ejercicio.StarWars.Service;


import com.Ejercicio.StarWars.Entity.Character;
import com.Ejercicio.StarWars.Repository.IRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements ICharacter {

    private final IRepository iRepository;

    @Override
    public void saveCharacters(List<Character> requestCharacterList) {
            iRepository.saveCharacter(requestCharacterList);
    }

    @Override
    public List<Character> getCharacters() {
        return iRepository.getCharacters();
    }

}
