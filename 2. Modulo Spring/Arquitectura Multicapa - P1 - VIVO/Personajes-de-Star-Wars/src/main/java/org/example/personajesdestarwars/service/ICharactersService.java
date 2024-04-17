package org.example.personajesdestarwars.service;

import org.example.personajesdestarwars.dto.CharacterDTO;

import java.io.IOException;
import java.util.List;

public interface ICharactersService {
    List<CharacterDTO> getCharactersByPartOfTheirName(String name) throws IOException;
}
