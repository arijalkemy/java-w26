package com.meli.obras_literarias_VIVO.controller;

import com.meli.obras_literarias_VIVO.dtos.RequestObraDto;
import com.meli.obras_literarias_VIVO.dtos.ResponseObraDto;
import com.meli.obras_literarias_VIVO.entities.Obra;
import com.meli.obras_literarias_VIVO.service.ObraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
@RequiredArgsConstructor
public class ObraController {
    private final ObraService obraService;
    @PostMapping
    ResponseEntity<String> post(@RequestBody List<RequestObraDto> obra) {
        String response = obraService.guardObras(obra);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    ResponseEntity<List<ResponseObraDto>> getAll() {
        return ResponseEntity.ok(obraService.getObras());
    }
    @GetMapping("/autor/{autor}")
    ResponseEntity<List<ResponseObraDto>> getByAutor(@PathVariable String autor) {
        return ResponseEntity.ok(obraService.getByAutor(autor));
    }
    @GetMapping("/titulo/{titulo}")
    ResponseEntity<List<ResponseObraDto>> getByTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(obraService.getObrasByTitulo(titulo));
    }
    @GetMapping("/top")
    ResponseEntity<List<ResponseObraDto>> getByTopFive() {
        return ResponseEntity.ok(obraService.getTopFiveByPages());
    }
    @GetMapping("/afterYear/{year}")
    ResponseEntity<List<ResponseObraDto>> getAfterYear(@PathVariable Integer year) {
        return ResponseEntity.ok(obraService.getAfterAge(year));
    }
}
