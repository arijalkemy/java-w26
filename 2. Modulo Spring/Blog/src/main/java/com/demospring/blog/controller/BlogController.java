package com.demospring.blog.controller;

import com.demospring.blog.model.EntradaBlog;
import com.demospring.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity addBlog(@RequestBody EntradaBlog entrada){
        blogService.addEntrada(entrada);
        return ResponseEntity.status(201).body("Entrada creada con exito!");
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity getEntrada(@PathVariable int id){
        return ResponseEntity.status(200).body(blogService.getEntrada(id));
    }

    @GetMapping("/blog")
    public ResponseEntity getEntradas(){
        return ResponseEntity.status(200).body(blogService.getEntradas());
    }
}
