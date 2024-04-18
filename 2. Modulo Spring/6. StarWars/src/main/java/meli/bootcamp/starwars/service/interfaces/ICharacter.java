package meli.bootcamp.starwars.service.interfaces;

import meli.bootcamp.starwars.dto.CharacterDto;

import java.util.List;

public interface ICharacter {
    public List<CharacterDto> getByName(String name);
}
