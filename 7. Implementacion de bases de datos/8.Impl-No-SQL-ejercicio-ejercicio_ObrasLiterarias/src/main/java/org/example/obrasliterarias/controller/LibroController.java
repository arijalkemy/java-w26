package org.example.obrasliterarias.controller;


import org.example.obrasliterarias.dto.ObraDto;
import org.example.obrasliterarias.service.IObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class LibroController {

    @Autowired
    IObraService libroService;

    @PostMapping
    public ResponseEntity<?> createLibro(@RequestBody ObraDto obra) {
        libroService.save(obra);
        return ResponseEntity.status(HttpStatus.OK).body("Creado con exito");
    }

    @GetMapping
    public ResponseEntity<?> getAllLibro() {
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findAll());
    }

    @GetMapping("/{autor}")
    public ResponseEntity<?> getLibroByAutor(@PathVariable String autor) {
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findByAutor(autor));
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<?> getLibroByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findObraByName(name));
    }

    @GetMapping("/TopPages")
    public ResponseEntity<?> getTopPages() {
        return ResponseEntity.status((HttpStatus.OK)).body(libroService.findTopFivePagesObra());
    }

    @GetMapping("/workBeforeYear/{year}")
    public ResponseEntity<?> getWorkBeforeYear(@PathVariable Integer year) {
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findObrasBeforeYear(year));
    }

    @GetMapping("/worksByEditorial/{editorial}")
    public ResponseEntity<?> getWorksByEditorial(@PathVariable String editorial) {
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findObraByEditorial(editorial));
    }
}
