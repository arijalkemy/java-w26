package org.example.multi_layer_p1_starwars.service;

import org.example.multi_layer_p1_starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    public List<CharacterDTO> findByName(String name);
}
