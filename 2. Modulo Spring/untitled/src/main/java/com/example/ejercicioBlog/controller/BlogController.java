package com.example.ejercicioBlog.controller;

import com.example.ejercicioBlog.model.EntradaBlog;
import com.example.ejercicioBlog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity publicBlog( @RequestBody EntradaBlog entryBlog ){

        return new ResponseEntity(blogService.save(entryBlog), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity getBlog( @PathVariable int id ){
        return new ResponseEntity(blogService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity getAllBlogs( ){
        return new ResponseEntity(blogService.getAll(), HttpStatus.OK);
    }
}
