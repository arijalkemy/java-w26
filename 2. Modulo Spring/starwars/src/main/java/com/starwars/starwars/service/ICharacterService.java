package com.starwars.starwars.service;
import java.util.List;

import com.starwars.starwars.dto.CharacterResponseDto;

public interface ICharacterService {
    public List<CharacterResponseDto> findByName(String name);
}
