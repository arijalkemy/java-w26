package com.example.excepciones_blog.controller;

import com.example.excepciones_blog.dto.BlogDto;
import com.example.excepciones_blog.service.BlogService.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> createBlog(@RequestBody BlogDto blogDto){
            blogService.createBlog(blogDto);
            return new ResponseEntity<>("Creado con existo", HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> getBlog(@PathVariable UUID id){
        return new ResponseEntity<>(blogService.getBlog(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> getBlogs(){
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }
}
