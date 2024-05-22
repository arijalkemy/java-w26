package org.example.obrasliterarias.controller;


import org.example.obrasliterarias.model.Libro;
import org.example.obrasliterarias.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class LibroController {

    @Autowired
    ILibroService libroService;

    @PostMapping
    public ResponseEntity<?> createLibro(@RequestBody Libro libro) {
        libroService.save(libro);
        return ResponseEntity.status(HttpStatus.OK).body("creado");
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
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findBookByName(name));
    }

    @GetMapping("top5/paginas")
    public ResponseEntity<?> getTop5Paginas() {
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findTop5Paginas());
    }
    
    @GetMapping("before_year/{year}")
    public ResponseEntity<?> getBeforeYear(@PathVariable int year) {
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findBeforeYear(year));
    }


    @GetMapping("editorial/{editorial}")
    public ResponseEntity<?> getByEditorial(@PathVariable String editorial) {
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findByEditorial(editorial));
    }
    
}
