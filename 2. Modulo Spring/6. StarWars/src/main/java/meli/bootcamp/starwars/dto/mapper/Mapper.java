package meli.bootcamp.starwars.dto.mapper;

import meli.bootcamp.starwars.dto.CharacterDto;
import meli.bootcamp.starwars.entity.Character;

public class Mapper {
    public static CharacterDto toStarWarsCharDto(Character character) {
        return CharacterDto.builder()
                .name(character.getName())
                .height(character.getHeight())
                .mass(character.getMass())
                .gender(character.getGender())
                .homeworld(character.getHomeworld())
                .species(character.getSpecies())
                .build();
    }
}
