package com.ejercicio.starwars.service.interfaces;

import com.ejercicio.starwars.DTO.CharactersResponseDTO;
import com.ejercicio.starwars.entity.Character;

import java.util.List;

public interface ICharacterService {
    public List<CharactersResponseDTO> findCharactersByName(String nameSubstring);
}
