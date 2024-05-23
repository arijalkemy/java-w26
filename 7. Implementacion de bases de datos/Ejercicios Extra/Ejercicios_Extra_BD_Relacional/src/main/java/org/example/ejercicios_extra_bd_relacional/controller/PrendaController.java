package org.example.ejercicios_extra_bd_relacional.controller;

import lombok.RequiredArgsConstructor;
import org.example.ejercicios_extra_bd_relacional.dto.PrendaDto;
import org.example.ejercicios_extra_bd_relacional.dto.PrendaRequestDto;
import org.example.ejercicios_extra_bd_relacional.service.IPrendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clothes")
@RequiredArgsConstructor
public class PrendaController {

    private final IPrendaService prendaService;


    @GetMapping
    public ResponseEntity<List<PrendaDto>> buscarTodasLasPrendas() {

        return ResponseEntity.ok(prendaService.buscarTodasLasPrendas());
    }

    @PostMapping
    public ResponseEntity<PrendaDto> crearPrenda(@RequestBody PrendaRequestDto prendaRequestDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(
            prendaService.crearPrenda(prendaRequestDto)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrendaDto> buscarPrendaPorId(@PathVariable("id") Long idPrenda) {

        return ResponseEntity.ok(prendaService.buscarPrendaPorId(idPrenda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrendaDto> actualizarPrendaPorId(
        @PathVariable("id") Long idPrenda,
        @RequestBody PrendaRequestDto prendaRequestDto
    ) {
        return ResponseEntity.ok(
            prendaService.actualizarPrendaPorId(idPrenda, prendaRequestDto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrendaPorId(@PathVariable("id") Long idPrenda) {

        prendaService.eliminarPrendaPorId(idPrenda);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/bySize/{size}")
    public ResponseEntity<List<PrendaDto>> buscarPrendasPorTamaño(@PathVariable("size") String talle) {

        return ResponseEntity.ok(
            prendaService.buscarPrendasPorTamaño(talle)
        );
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<List<PrendaDto>> buscarPrendasPorNombre(@PathVariable("name") String nombre) {

        return ResponseEntity.ok(
            prendaService.buscarPrendasPorNombre(nombre)
        );
    }
}
