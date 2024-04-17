package bootcamp.bendezujonathan.starwars.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.bendezujonathan.starwars.dto.response.CharacterResponse;
import jakarta.validation.constraints.NotEmpty;

@RequestMapping("/characters")
public interface ICharacterController {
    
    @GetMapping
    public ResponseEntity<List<CharacterResponse>> getAllCharacters();

    @GetMapping(params = "name")
    public ResponseEntity<CharacterResponse> getCharacterByName(@NotEmpty @RequestParam String name);
}
