package org.ejercicio.starwars.service;

import java.util.List;
import org.ejercicio.starwars.dto.CharacterDTO;

public interface ICharacterService {
    public List<CharacterDTO> findAllCharactersByName(String name);
}
