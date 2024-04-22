package com.javabootcamp.blog.controller;

import com.javabootcamp.blog.dto.EntradaBlogDto;
import com.javabootcamp.blog.model.EntradaBlog;
import com.javabootcamp.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@ControllerAdvice
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;


    @GetMapping("/get")
    public ResponseEntity<Map<Integer, EntradaBlog>> getEntryBlog(){
        return ResponseEntity.ok(blogService.getAllEntryBlog());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EntradaBlogDto> getEntryBlogById(@PathVariable int id){
        return ResponseEntity.ok(blogService.getEntryBlogById(id));
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> addEntryBlog(@RequestBody EntradaBlog entradaBlog){
        blogService.addEntryBlog(entradaBlog);
        return ResponseEntity.status(HttpStatus.CREATED).body("Entrada creada");
    }

}
