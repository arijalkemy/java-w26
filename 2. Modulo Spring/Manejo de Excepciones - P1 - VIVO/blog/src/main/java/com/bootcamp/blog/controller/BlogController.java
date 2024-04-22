package com.bootcamp.blog.controller;

import com.bootcamp.blog.entity.EntradaBlog;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<EntradaBlog> crearEntrada(@RequestBody EntradaBlog entradaBlog){
        return ResponseEntity.ok(blogService.crearEntrada(entradaBlog));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlog> obtenerEntrada(@PathVariable Integer id){
        return ResponseEntity.ok(blogService.obtenerEntrada(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<HashMap<Integer,EntradaBlog>> obtenerEntradas(){
        return ResponseEntity.ok(blogService.obtenerEntradas());
    }
}
