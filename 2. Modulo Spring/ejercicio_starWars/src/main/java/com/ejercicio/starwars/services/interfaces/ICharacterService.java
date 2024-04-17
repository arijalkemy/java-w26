package com.ejercicio.starwars.services.interfaces;

import com.ejercicio.starwars.models.Character;

import java.util.List;

public interface ICharacterService {
    public List<Character> findCharactersByName(String nameSubstring);
}
