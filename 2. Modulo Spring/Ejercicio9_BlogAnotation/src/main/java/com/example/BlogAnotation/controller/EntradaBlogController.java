package com.example.BlogAnotation.controller;

import com.example.BlogAnotation.dto.EntradaBlogDTO;
import com.example.BlogAnotation.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {

    @Autowired
    IEntradaBlogService entradaBlogService;

    @PostMapping("/blog")
    public ResponseEntity<String> crearEntradaBlog(@RequestBody EntradaBlogDTO entradaBlog){
        return ResponseEntity.status(HttpStatus.OK).body(entradaBlogService.crearEntradaBlog(entradaBlog));
    }

    @GetMapping("/blog/{id}")
    public  ResponseEntity<EntradaBlogDTO> obtenerEntradaBlog(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(entradaBlogService.obtenerBlogPorId(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> obtenerBlogs(){
        return ResponseEntity.status(HttpStatus.OK).body(entradaBlogService.obtenerTodosBlogs());
    }
}
