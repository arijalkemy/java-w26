package bootcamp.bendezujonathan.starwars.controller.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.starwars.controller.interfaces.ICharacterController;
import bootcamp.bendezujonathan.starwars.dto.mapping.CharacterMapping;
import bootcamp.bendezujonathan.starwars.dto.response.CharacterResponse;
import bootcamp.bendezujonathan.starwars.service.interfaces.ICharacterService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CharacterController implements ICharacterController {

    private final ICharacterService service;

    @Override
    public ResponseEntity<List<CharacterResponse>> getAllCharacters() {
        List<CharacterResponse> response = this.service
                .findAll()
                .stream()
                .map(CharacterMapping::characterToResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CharacterResponse> getCharacterByName(@NotEmpty String name) {
        return this.service
                .findContainingName(name)
                .map(CharacterMapping::characterToResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
