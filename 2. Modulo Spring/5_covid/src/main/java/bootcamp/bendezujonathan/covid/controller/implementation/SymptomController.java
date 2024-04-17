package bootcamp.bendezujonathan.covid.controller.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.covid.controller.interfaces.ISymptomController;
import bootcamp.bendezujonathan.covid.dto.mapping.SymptomMapping;
import bootcamp.bendezujonathan.covid.dto.response.SymptomResponse;
import bootcamp.bendezujonathan.covid.services.interfaces.ISymptomService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SymptomController implements ISymptomController {

    private final ISymptomService service;

    @Override
    public ResponseEntity<List<SymptomResponse>> getAllSymptoms() {

        List<SymptomResponse> dto = this.service
                .findAll()
                .stream()
                .map(SymptomMapping::symptomToDto)
                .toList();

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<SymptomResponse> getSymptomByName(String name) {
        return this.service
                .findByName(name)
                .map(SymptomMapping::symptomToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   

}
