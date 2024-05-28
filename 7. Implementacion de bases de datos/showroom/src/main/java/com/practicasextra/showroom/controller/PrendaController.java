package com.practicasextra.showroom.controller;

import com.practicasextra.showroom.model.Prenda;
import com.practicasextra.showroom.service.PrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {
    @Autowired
    private PrendaService prendaService;

    @PostMapping
    public ResponseEntity<Prenda> createPrenda(@RequestBody Prenda prenda) {
        return ResponseEntity.ok(prendaService.guardar(prenda));
    }

    @GetMapping
    public ResponseEntity<List<Prenda>> getPrendas() {
        return ResponseEntity.ok(prendaService.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Prenda> getPrenda(@PathVariable Long code) {
        return ResponseEntity.ok(prendaService.findByCodigo(code));
    }

    @PutMapping()
    public ResponseEntity<Prenda> updatePrenda(@RequestBody Prenda prenda) {
        return ResponseEntity.ok(prendaService.actualizar(prenda));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deletePrenda(@PathVariable Long code) {
        prendaService.eliminar(code);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/size/{talle}")
    public ResponseEntity<List<Prenda>> getPrendasByTalle(@PathVariable String talle) {
        return ResponseEntity.ok(prendaService.findAllByTalle(talle));
    }

    @GetMapping("params = nombre")
    public ResponseEntity<List<Prenda>> getPrendasByNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(prendaService.findAllByNombreContaining(nombre));
    }
}
