package org.bootcamp.starwars.mapper;

import org.bootcamp.starwars.dto.CharacterResponseDTO;
import org.bootcamp.starwars.entity.Character;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    public CharacterResponseDTO characterToCharacterResponseDTO(Character character);

    public List<CharacterResponseDTO> characterListToCharacterResponseDtoList (List<Character> characterList);

}
