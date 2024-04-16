package bootcamp.spring.deportistas.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.spring.deportistas.dtos.DeportistaDTO;
import bootcamp.spring.deportistas.services.DeportesService;
import bootcamp.spring.deportistas.services.DeportistasService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/deportistas")
@RequiredArgsConstructor
public class DeportistasController {

    private final DeportistasService deportistasService;
    private final DeportesService deportesService;

    @GetMapping("")
    public ResponseEntity<List<DeportistaDTO>> obtenerDeportistas(){
        
        List<DeportistaDTO> deportistas = deportistasService
            .obtenerDeportistas()
            .stream()
            .map(deportista -> new DeportistaDTO(
                deportista.getNombre() + " " + deportista.getApellido(),
                deportesService.obtenerDeporteAleatoriamente().getNombre()
            ))
            .toList();
        return ResponseEntity.ok(deportistas);
    }
}