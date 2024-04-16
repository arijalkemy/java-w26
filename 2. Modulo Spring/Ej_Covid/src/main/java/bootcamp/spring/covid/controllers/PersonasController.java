package bootcamp.spring.covid.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.spring.covid.dtos.PersonaDTO;
import bootcamp.spring.covid.services.PersonasService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonasController {

    private final PersonasService personasService;

    @GetMapping("/mayor-sesenta")
    public ResponseEntity<List<PersonaDTO>> obtenerPersonasMayoresDe60() {
        List<PersonaDTO> personas = personasService
                .buscarPersonasMayores60()
                .stream()
                .map(PersonaDTO::new)
                .toList();

        return ResponseEntity.ok(personas);
    }
}
