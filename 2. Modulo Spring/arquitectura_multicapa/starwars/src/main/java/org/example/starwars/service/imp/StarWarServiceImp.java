package org.example.starwars.service.imp;

import org.example.starwars.dto.StarWarCharacterDTO;
import org.example.starwars.model.StarWarCharacter;
import org.example.starwars.repository.StarWarsRepository;
import org.example.starwars.service.IStarWarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarServiceImp implements IStarWarService {
    @Override
    public ResponseEntity<List<StarWarCharacterDTO>> getChaptersByName(String name) {
        List<StarWarCharacter> characters = new StarWarsRepository().getStarWarCharacters();
        if(characters.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<StarWarCharacterDTO> characterDTOS = characters.stream()
                .filter(c -> c.getName().contains(name))
                .map(c -> new StarWarCharacterDTO(c)).toList();
        return new ResponseEntity<>(characterDTOS, HttpStatus.OK);
    }
}
