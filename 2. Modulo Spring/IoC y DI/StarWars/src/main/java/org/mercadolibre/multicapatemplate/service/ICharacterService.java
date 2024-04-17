package org.mercadolibre.multicapatemplate.service;

import org.mercadolibre.multicapatemplate.dto.CharacterResponseDTO;
import org.mercadolibre.multicapatemplate.entity.Character;

import java.util.List;

public interface ICharacterService {

    List<CharacterResponseDTO> findAll();
    List<CharacterResponseDTO> findAllWith(String partialName);
}
