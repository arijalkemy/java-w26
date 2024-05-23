package com.meli.obras.controlador;

import com.meli.obras.entities.Obras;
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

    @GetMapping("/find/{nombre}")
    public ResponseEntity<?> findByAutor(@PathVariable String nombre){
        return new ResponseEntity<>(obrasService.findByAutor(nombre), HttpStatus.OK);
    }

    @GetMapping("/findTitulo/{titulo}")
    public ResponseEntity<?> findByTitulo(@PathVariable String titulo){
        return new ResponseEntity<>(obrasService.findByTitulo(titulo), HttpStatus.OK);
    }

    @GetMapping("/findtop5")
    public ResponseEntity<?> findTop5ByOrderByPageCountDesc(){
        return new ResponseEntity<>(obrasService.findTop5ByOrderByPageCountDesc(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(obrasService.findAll(), HttpStatus.OK);
    }
}
