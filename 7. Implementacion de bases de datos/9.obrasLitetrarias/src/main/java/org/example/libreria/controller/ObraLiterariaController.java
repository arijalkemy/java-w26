package org.example.libreria.controller;

import org.example.libreria.dto.ObraLiterariaRequestDTO;
import org.example.libreria.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obrasliterarias")
public class ObraLiterariaController {

    @Autowired
    private IObraLiterariaService obraLiterariaService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ObraLiterariaRequestDTO obraLiteraria) {
        obraLiterariaService.saveObraLiteraria(obraLiteraria);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/createall")
    public ResponseEntity<?> createAll(@RequestBody List<ObraLiterariaRequestDTO> obrasLiterarias) {
        obraLiterariaService.saveObrasLiterarias(obrasLiterarias);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find/autor")
    public ResponseEntity<?> findByAutor(@RequestParam String autor) {
       return new ResponseEntity<>(obraLiterariaService.getObrasLiterariasByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/find/name")
    public ResponseEntity<?> findByName(@RequestParam String name) {
        return new ResponseEntity<>(obraLiterariaService.getObrasLiterariasByNombre(name), HttpStatus.OK);
    }

    /*@GetMapping("/find/top")
    public ResponseEntity<?> findTopPages() {
        return new ResponseEntity<>(obraLiterariaService.getObrasLiterariasTopOrderPages(), HttpStatus.OK);
    }*/


}
