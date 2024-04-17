package com.ejercicio.starwars.repository.interfaces;

import com.ejercicio.starwars.DTO.CharactersResponseDTO;
import com.ejercicio.starwars.entity.Character;

import java.util.List;

public interface ICharacterRepository {
    public List<Character> findByName(String nameSubstring);
}
