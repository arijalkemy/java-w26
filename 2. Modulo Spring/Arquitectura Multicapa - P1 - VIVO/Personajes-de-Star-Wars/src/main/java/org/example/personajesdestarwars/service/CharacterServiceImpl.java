package org.example.personajesdestarwars.service;


import org.example.personajesdestarwars.dto.CharacterDTO;
import org.example.personajesdestarwars.entity.Character;
import org.example.personajesdestarwars.repository.CharactersRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CharacterServiceImpl implements ICharactersService {
    @Override
    public List<CharacterDTO> getCharactersByPartOfTheirName(String name) throws IOException {
        //creo una lista vacia de personajes filtrados
        List<CharacterDTO> foundCharacters = new ArrayList<>();

        //recorro la lista completa de personajes
        for (Character character : CharactersRepository.getAllCharacters()) {
            //filtro para buscar en la lista si hay algun personaje con ese nombre
            // en alguna parte de su nombre
            if (character.getName().toLowerCase().contains(name.toLowerCase())) {
                //si algun personaje pasa el filtro creo un nuevo objeto DTO para el
                CharacterDTO characterDTO = new CharacterDTO(
                        character.getName(),
                        //parseo height, pero si es "N/A" devuelvo 0
                        !Objects.equals(character.getHeight(), "NA")
                                ?
                                Integer.parseInt(character.getHeight())
                                : 0,
                        //parseo mass, pero si es "N/A" devuelvo 0
                        !Objects.equals(character.getMass(), "NA")
                                ?
                                Integer.parseInt(character.getMass())
                                : 0,
                        character.getGender(),
                        character.getHomeworld(),
                        character.getSpecies()
                );
                //agrego el dto a la lista de personajes filtrados
                foundCharacters.add(characterDTO);
            }
        }
        ;
        return foundCharacters;
    }
}
