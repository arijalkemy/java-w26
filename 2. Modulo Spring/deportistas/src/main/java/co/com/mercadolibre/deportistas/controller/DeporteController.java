package co.com.mercadolibre.deportistas.controller;

import co.com.mercadolibre.deportistas.entity.Deporte;
import co.com.mercadolibre.deportistas.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/deporte")
public class DeporteController {

    @Autowired
    private IDeporteService deporteService;

    @GetMapping(path = "/buscarDeportes")
    public ResponseEntity<?> buscarDeportes() {
        return ResponseEntity.ok(deporteService.buscarTodos());
    }

    @GetMapping(path = "/buscarDeporte/{nombre}")
    public ResponseEntity<?> buscarDeporte(@PathVariable String nombre) {
        return ResponseEntity.ok(deporteService.existeDeporte(nombre));
    }

    @GetMapping(path = "listarPersonasDeportistas")
    public ResponseEntity<?> listarPersonasDeportistas() {
        return ResponseEntity.ok(deporteService.listarPersonasDeportistas());
    }

}
