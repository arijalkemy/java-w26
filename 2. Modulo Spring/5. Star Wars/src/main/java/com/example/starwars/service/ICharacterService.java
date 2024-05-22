package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {

    public List<CharacterDTO> getCharacterByName(String substring);

}
