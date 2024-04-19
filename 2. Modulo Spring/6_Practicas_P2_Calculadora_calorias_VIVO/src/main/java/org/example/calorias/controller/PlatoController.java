package org.example.calorias.controller;

import org.example.calorias.dto.PlatoConPesoRequestDTO;
import org.example.calorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {

    @Autowired
    private IPlatoService platoService;


    @GetMapping
    public ResponseEntity<?> buscar(
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) Integer peso
    ) {
        if (nombre != null && peso != null) {
            return ResponseEntity.ok(platoService.buscarPorNombreConPeso(nombre, peso));
        }
        else {
            return ResponseEntity.ok(platoService.buscarTodos());
        }
    }

    @PostMapping("/buscarEnLote")
    public ResponseEntity<?> buscarEnLote(@RequestBody List<PlatoConPesoRequestDTO> platos) {

        return ResponseEntity.ok(platoService.buscarEnLote(platos));
    }
}
