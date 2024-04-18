package com.bootcamjava.starwars.service;

import com.bootcamjava.starwars.dto.CharacterDTO;

import java.util.ArrayList;
import java.util.List;

public interface ICharacterService {
     ArrayList<CharacterDTO> getAll();
     List<CharacterDTO> findCharacterByName(String name);
}
