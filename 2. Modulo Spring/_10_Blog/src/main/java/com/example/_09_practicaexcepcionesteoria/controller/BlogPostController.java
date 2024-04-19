package com.example._09_practicaexcepcionesteoria.controller;

import com.example._09_practicaexcepcionesteoria.dto.BlogPostDTO;
import com.example._09_practicaexcepcionesteoria.service.IBlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogPostController {
    @Value("${spring.message}")
    String mensaje;
    @Autowired
    IBlogPostService iBlogPostService;

    @GetMapping("/Hello")
    public String sayHello(){
        return mensaje;
    }

    @GetMapping
    public ResponseEntity<List<BlogPostDTO>> getAll(){
        return new ResponseEntity<>(iBlogPostService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPostDTO> getById(@PathVariable int id){

        return new ResponseEntity<>(iBlogPostService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody BlogPostDTO blogPostDTO){

        return new ResponseEntity<>(iBlogPostService.add(blogPostDTO), HttpStatus.CREATED);
    }

}
