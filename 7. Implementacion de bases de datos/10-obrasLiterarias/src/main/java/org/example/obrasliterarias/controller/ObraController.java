package org.example.obrasliterarias.controller;

import org.example.obrasliterarias.model.dto.ObraRequestDTO;
import org.example.obrasliterarias.model.dto.ObraResponseDTO;
import org.example.obrasliterarias.service.IObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras_literarias")
public class ObraController {

    @Autowired
    IObraService service;

    @PostMapping("/new")
    public ResponseEntity<ObraResponseDTO> create(@RequestBody ObraRequestDTO obra) {
        return ResponseEntity.ok(service.create(obra));
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> bulk(@RequestBody List<ObraRequestDTO> obrasDTO) {
        return ResponseEntity.ok(service.bulk(obrasDTO));
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraResponseDTO>> getObraByAutor(@PathVariable String autor) {
        return ResponseEntity.ok(service.findObraByAutor(autor));
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<ObraResponseDTO>> getObraByTitle(@PathVariable String titulo) {
        return ResponseEntity.ok(service.findObraByTitle(titulo));
    }

    @GetMapping("/paginas/mas/top_cinco")
    public ResponseEntity<List<ObraResponseDTO>> getObraByPaginas() {
        return ResponseEntity.ok(service.findObraByPaginas());
    }

    @GetMapping("/anio_publicacion/{anio}")
    public ResponseEntity<List<ObraResponseDTO>> getObraByAnioPublicacion(@PathVariable Integer anio) {
        return ResponseEntity.ok(service.findObraByAnioPublicacion(anio));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraResponseDTO>> getObraByEditorial(@PathVariable String editorial) {
        return ResponseEntity.ok(service.findObraByEditorial(editorial));
    }
}
