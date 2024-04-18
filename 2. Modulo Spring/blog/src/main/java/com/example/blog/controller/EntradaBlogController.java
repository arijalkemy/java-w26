package com.example.blog.controller;

import com.example.blog.model.EntradaBlog;
import com.example.blog.service.EntradaServiceImpl;
import com.example.blog.service.IEntradaBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class EntradaBlogController {

    @Autowired
    IEntradaBlog entradaBlogService;

    @PostMapping("/blog")
    public ResponseEntity<Integer> crearBlog(@RequestBody EntradaBlog entradaBlog){
        System.out.println(entradaBlog.getId());
        return new ResponseEntity(entradaBlogService.crearBlog(entradaBlog), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlog>> obtenerTodos(){
        return new ResponseEntity<>(entradaBlogService.obtenerTodos(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public EntradaBlog obtenerBlog(@PathVariable Integer id){
        return entradaBlogService.obtenerBlog(id);
    }
}
