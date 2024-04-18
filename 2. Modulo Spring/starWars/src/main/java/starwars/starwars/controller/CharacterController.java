package starwars.starwars.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starwars.starwars.dto.CharacterDto;
import starwars.starwars.model.Character;
import starwars.starwars.repository.ICharacterRepository;
import starwars.starwars.service.ICharacterService;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    ICharacterService characterService;

    /**
     * @GetMapping public ResponseEntity<List<Character>> getAllCharacters() {
     * List<Character> characters = characterRepository.searchAllCharacters();
     * if(characters!=null){
     * return ResponseEntity.ok(characters);
     * }
     * else{
     * return null;
     * }
     * }
     **/

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDto>> getAllCharactersByName(@PathVariable String name) {
        List<CharacterDto> characters = characterService.searchCharactersByName(name);
        if (characters != null) {
            return ResponseEntity.ok(characters);
        } else {
            return null;
        }
    }


}
