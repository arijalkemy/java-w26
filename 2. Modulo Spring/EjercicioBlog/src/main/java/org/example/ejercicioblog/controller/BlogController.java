package org.example.ejercicioblog.controller;

import org.example.ejercicioblog.dto.EntradaBlogDTO;
import org.example.ejercicioblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BlogController {
    @Autowired
     IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> addBlog(@RequestBody EntradaBlogDTO entradaBlogDTO){
        return new ResponseEntity<>(blogService.addBlog(entradaBlogDTO), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable int id){
        return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<?> getAllBlogs(){
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

}
