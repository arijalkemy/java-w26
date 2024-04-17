package bootcamp.bendezujonathan.covid.controller.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.covid.controller.interfaces.IPersonController;
import bootcamp.bendezujonathan.covid.dto.mapping.PersonMapping;
import bootcamp.bendezujonathan.covid.dto.response.PersonResponse;
import bootcamp.bendezujonathan.covid.services.interfaces.IPersonService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PersonController implements IPersonController {

    private final IPersonService service;

    @Override
    public ResponseEntity<List<PersonResponse>> getPersonsByAgeAndRisk(Integer age) {

        List<PersonResponse> result = this.service
                .findByEdadAndRisk(60, 1)
                .stream()
                .map(PersonMapping::modelToResponse)
                .toList();

        return ResponseEntity.ok(result);
    }

}
