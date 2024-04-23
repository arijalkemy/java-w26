package org.bootcamp.starwars.service;

import org.bootcamp.starwars.dto.CharacterDTO;
import org.bootcamp.starwars.repository.CharacterRepositoryImpl;
import org.bootcamp.starwars.repository.ICharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCharacterServiceImpl implements IFindCharacterService {
    private static final ICharacterRepository characterRepository = new CharacterRepositoryImpl();

    @Override
    public List<CharacterDTO> findCharactersByContains(String query) {
        return characterRepository.getCharactersByContains(query);
    }
}
