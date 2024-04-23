package com.mercadolibre.CharacterStarWarsAPI.service.implement;

import com.mercadolibre.CharacterStarWarsAPI.dto.CharacterDTO;
import com.mercadolibre.CharacterStarWarsAPI.repositories.RepoBD;
import com.mercadolibre.CharacterStarWarsAPI.service.ICharacterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements ICharacterService {
    @Override
    public List<CharacterDTO> findAllByNameContains(String name) {
        RepoBD database = new RepoBD();
        return database.getDatabase().stream()
                .filter(characterDTO -> matchWith(name, characterDTO))
                .collect(Collectors.toList());
    }
    private boolean matchWith(String query, CharacterDTO characterDTO) {
        return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
    }
}
