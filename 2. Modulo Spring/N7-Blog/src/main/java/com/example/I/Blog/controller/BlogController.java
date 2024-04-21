package com.example.I.Blog.controller;

import com.example.I.Blog.dto.EntradaBlogDto;
import com.example.I.Blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    IBlogService blogService;

    @Autowired
    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    /*


    Devolver el listado de todas las entradas de blogs existentes. (URI: /blogs).
     */

    @PostMapping
    public ResponseEntity<?> agregarEntrada(@RequestBody EntradaBlogDto entradaBlogDto){
        return new ResponseEntity<>(blogService.agregarEntrada(entradaBlogDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEntrada(@PathVariable Long id){
        return new ResponseEntity<>(blogService.obtenerEntrada(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> obtenerBlogs(){
        return new ResponseEntity<>(blogService.obtenerEntradas(), HttpStatus.OK);
    }

}
