package org.bootcamp.starwars.service;

import org.bootcamp.starwars.dto.CharacterResponseDTO;

import java.util.List;

public interface CharacterService {

    List<CharacterResponseDTO> getAll();

    List<CharacterResponseDTO> getFindByName(String name);

}
