package org.example.ejercicios_extra_elasticsearch.controller;

import lombok.RequiredArgsConstructor;
import org.example.ejercicios_extra_elasticsearch.dto.VentaRequestDto;
import org.example.ejercicios_extra_elasticsearch.service.IVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sale")
public class VentaController {

    private final IVentaService ventaService;

    @PostMapping
    public ResponseEntity<?> crearVenta(@RequestBody VentaRequestDto ventaRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ventaService.crearVenta(ventaRequestDto)
        );
    }

    @GetMapping
    public ResponseEntity<?> listarVentas() {
        return ResponseEntity.status(HttpStatus.OK).body(
                ventaService.buscarTodasLasVentas()
        );
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> buscarVentaPorId(@PathVariable("number") String id) {
        return ResponseEntity.ok(ventaService.buscarVentaPorId(id));
    }
}
