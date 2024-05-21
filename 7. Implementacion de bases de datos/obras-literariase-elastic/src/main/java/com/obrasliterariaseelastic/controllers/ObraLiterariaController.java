package com.obrasliterariaseelastic.controllers;

import com.obrasliterariaseelastic.DTOs.ObraLiterariaRequestDTO;
import com.obrasliterariaseelastic.services.IObraLiterariaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras-literarias")
public class ObraLiterariaController {

    private final IObraLiterariaService obraLiterariaService;

    public ObraLiterariaController(IObraLiterariaService obraLiterariaService) {
        this.obraLiterariaService = obraLiterariaService;
    }

    @PostMapping
    public ResponseEntity<?> guardarObraLiteraria(
            @RequestBody List<ObraLiterariaRequestDTO> obrasLiterariasRequestDTO
    ) {
        return new ResponseEntity<>(
                this.obraLiterariaService.guardarTodos(obrasLiterariasRequestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<?> getObrasByAutor(@PathVariable String autor) {
        return new ResponseEntity<>(
                this.obraLiterariaService.getObrasByAutor(autor),
                HttpStatus.OK
        );
    }


    @GetMapping("/titulo/palabras-clave/{titulo}")
    public ResponseEntity<?> getObrasConPalabrasClaveEnElTitulo(@PathVariable String titulo) {
        return new ResponseEntity<>(
                this.obraLiterariaService.getObrasConPalabrasClaveEnElTitulo(titulo),
                HttpStatus.OK
        );
    }

    @GetMapping("paginas/top-5")
    public ResponseEntity<?> getTop5ConMasPaginas() {
        return new ResponseEntity<>(
                this.obraLiterariaService.getTop5ConMasPaginas(),
                HttpStatus.OK
        );
    }

    @GetMapping("antes-de")
    public ResponseEntity<?> getObrasAntesDe(@RequestParam Integer anio) {
        return new ResponseEntity<>(
                this.obraLiterariaService.getObrasAntesDe(anio),
                HttpStatus.OK
        );
    }

    @GetMapping("editorial/{editorial}")
    public ResponseEntity<?> getObrasByEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(
                this.obraLiterariaService.getObrasByEditorial(editorial),
                HttpStatus.OK
        );
    }
}
