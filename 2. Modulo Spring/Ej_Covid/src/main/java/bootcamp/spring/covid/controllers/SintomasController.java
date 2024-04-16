package bootcamp.spring.covid.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.spring.covid.models.Sintoma;
import bootcamp.spring.covid.services.SintomasService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sintomas")
public class SintomasController {

    private final SintomasService sintomasService;

    @GetMapping("")
    public ResponseEntity<List<Sintoma>> buscarSintomas() {
        List<Sintoma> sintomas = sintomasService.obtenerSintomas();
        return ResponseEntity.ok(sintomas);
    }

    @GetMapping("/{nombreSintoma}")
    public ResponseEntity<String> buscarSintomaPorNombre(@PathVariable("nombreSintoma")String nombreSintoma) {
        return sintomasService
                .obtenerSintomaPorNombre(nombreSintoma)
                .map(sintoma -> ResponseEntity.ok(sintoma.getNivelDeGravedad()))
                .orElse(ResponseEntity.notFound().build());
    }
    
}
