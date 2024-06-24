package org.example.templatemvc.Controller;

import lombok.RequiredArgsConstructor;
import org.example.templatemvc.DTOs.Response.PatenteMarca;
import org.example.templatemvc.Repository.Entity.Vehiculo;
import org.example.templatemvc.Service.in.IVehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {
    private final IVehiculoService service;

    @GetMapping("/list")
    public ResponseEntity<List<Vehiculo>> searchAll() {
        List<Vehiculo> vehiculos = service.searchAll();
        return ResponseEntity.ok(vehiculos);
    }

    @GetMapping("/list/plates")
    public ResponseEntity<List<String>> searchAllPlates() {
        return ResponseEntity.ok(service.listAllPlates());
    }

    @GetMapping("/list/patente-marca")
    public ResponseEntity<List<PatenteMarca>> searchAllPatenteMarca() {
        return ResponseEntity.ok(service.searchAllPatenteMarcaOrderAsc());
    }

    @GetMapping("/list/patente-marca/{anio}")
    public ResponseEntity<List<String>> searchAllPatentesByAnioAndCantRuedas(@PathVariable Integer anio) {
        return ResponseEntity.ok(service.searchAllPatentesByAnioAndCantRuedas(anio));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Vehiculo request) {
        Vehiculo vehiculo = service.create(request);
        return ResponseEntity.ok(vehiculo);
    }


}
