package com.example.blog.controller;

import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.service.EntradaBlogService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {

    @Autowired
    EntradaBlogService entradaService;

    @PostMapping("/blog")
    public ResponseEntity<EntradaBlogDTO> postEntrada(@RequestBody EntradaBlogDTO entrada) {
        return ResponseEntity.ok().body(entradaService.guardarEntrada(entrada));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> getEntrada(@PathVariable int id){
return ResponseEntity.ok().body(entradaService.mostrarEntrada(id));

    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> getEntradas(){
        return ResponseEntity.ok().body(entradaService.mostrarEntradas());
    }


}
