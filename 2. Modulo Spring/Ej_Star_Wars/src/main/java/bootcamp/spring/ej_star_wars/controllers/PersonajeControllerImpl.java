package bootcamp.spring.ej_star_wars.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.spring.ej_star_wars.models.dtos.PersonajeDTO;
import bootcamp.spring.ej_star_wars.services.ExternalPersonajeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personajes")
public class PersonajeControllerImpl implements PersonajeController {

    private final ExternalPersonajeService externalPersonajeService;

    @Override
    public ResponseEntity<PersonajeDTO> getByName(String name) {
        return externalPersonajeService
                .getByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .notFound()
                        .build());
    }

}
