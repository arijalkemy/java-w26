package com.meli.obras.controller;

import com.meli.obras.model.Obras;
import com.meli.obras.service.impl.obrasServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obras")
public class ObrasController {
     private final obrasServiceImpl obrasService;

     public ObrasController(obrasServiceImpl obrasService) {
         this.obrasService = obrasService;
     }

    @PostMapping ("/save")
    public ResponseEntity<?> save(@RequestBody Obras obras){
        return new ResponseEntity<>(obrasService.save(obras), HttpStatus.OK);
    }

    @GetMapping("/find/{autor}")
    public ResponseEntity<?> findByAutor(@PathVariable String autor){
        return new ResponseEntity<>(obrasService.findByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/find/titulo/{titulo}")
    public ResponseEntity<?> findByTitulo(@PathVariable String titulo){
        return new ResponseEntity<>(obrasService.findByTitulo(titulo), HttpStatus.OK);
    }

    @GetMapping("/find/top5")
    public ResponseEntity<?> findTop5ByOrderByPaginasDesc(){
        return new ResponseEntity<>(obrasService.findTop5ByOrderByPageCountDesc(), HttpStatus.OK);
    }

    @GetMapping("/find/publicacion/{year}")
    public ResponseEntity<?> findByPublicacion(@PathVariable Integer year){
        return new ResponseEntity<>(obrasService.findBypublicacionIsLessThan(year), HttpStatus.OK);
    }

    @GetMapping("/find/editorial/{editorial}")
    public ResponseEntity<?> findByEditorial(@PathVariable String editorial){
        return new ResponseEntity<>(obrasService.findByEditorial(editorial), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(obrasService.findAll(), HttpStatus.OK);
    }
}
