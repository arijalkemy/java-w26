package co.com.mercadolibre.covid.controller;

import co.com.mercadolibre.covid.service.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sintoma")
public class SintomaController {

    private final ISintomaService sintomaService;

    public SintomaController(ISintomaService sintomaService) {
        this.sintomaService = sintomaService;
    }

    @GetMapping(path = "/buscarSintomas")
    public ResponseEntity<?> buscarSintomas() {
        return ResponseEntity.ok(this.sintomaService.buscarTodos());
    }

    @GetMapping(path = "/buscarSintoma/{nombre}")
    public ResponseEntity<?> buscarSintomasPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(this.sintomaService.buscarPorNombre(nombre));
    }
}
