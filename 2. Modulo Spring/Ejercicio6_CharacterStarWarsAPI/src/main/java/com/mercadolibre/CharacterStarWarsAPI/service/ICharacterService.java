package com.mercadolibre.CharacterStarWarsAPI.service;

import com.mercadolibre.CharacterStarWarsAPI.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> findAllByNameContains(String name);
}
