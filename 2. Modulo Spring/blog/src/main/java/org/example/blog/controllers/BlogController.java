package org.example.blog.controllers;

import lombok.Getter;
import org.example.blog.dto.BlogDTO;
import org.example.blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> postBlogEntry (@RequestBody @DateTimeFormat(pattern = "yyyy-MM-dd") BlogDTO blogEntry){
        return ResponseEntity.ok(blogService.addBlogPost(blogEntry));
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogEntry(@PathVariable Integer id){
        return ResponseEntity.ok(blogService.findById(id));
    }
    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlogEnties(){
        return ResponseEntity.ok(blogService.findAllBlogEntries());
    }
}
