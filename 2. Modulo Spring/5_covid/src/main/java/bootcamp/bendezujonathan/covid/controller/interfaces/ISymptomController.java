package bootcamp.bendezujonathan.covid.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bootcamp.bendezujonathan.covid.dto.response.SymptomResponse;

@RequestMapping("/symptom")
public interface ISymptomController {
    
    @GetMapping
    ResponseEntity<List<SymptomResponse>> getAllSymptoms();

    @GetMapping("/{name}")
    ResponseEntity<SymptomResponse> getSymptomByName(@PathVariable String name);
}
