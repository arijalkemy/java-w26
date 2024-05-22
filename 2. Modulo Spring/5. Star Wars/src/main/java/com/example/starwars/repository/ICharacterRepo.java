package com.example.starwars.repository;

import com.example.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterRepo {
    List<CharacterDTO> findAll();
}
