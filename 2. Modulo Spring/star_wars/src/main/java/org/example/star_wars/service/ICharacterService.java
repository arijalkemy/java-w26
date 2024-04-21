package org.example.star_wars.service;

import org.example.star_wars.dto.CharacterDTO;

import java.util.*;

public interface ICharacterService {
    public List<CharacterDTO> findByName(String name);
    public List<CharacterDTO> findAll();
}
