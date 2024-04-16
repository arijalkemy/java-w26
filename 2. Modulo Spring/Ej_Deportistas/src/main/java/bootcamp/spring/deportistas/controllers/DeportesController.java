package bootcamp.spring.deportistas.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.spring.deportistas.models.Deporte;
import bootcamp.spring.deportistas.services.DeportesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/deportes")
@RequiredArgsConstructor
public class DeportesController {
    private final DeportesService deportesService;

    @GetMapping("")
    public ResponseEntity<List<Deporte>> obtenerDeportes() {
        List<Deporte> deportes = deportesService.obtenerDeportes();
        return ResponseEntity.ok(deportes);
    }

    @GetMapping(value = "",params = "nombreDeporte")
    public ResponseEntity<Deporte> buscarDeporte(@RequestParam String nombreDeporte) {
        return deportesService
                .buscarDeporte(nombreDeporte)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
