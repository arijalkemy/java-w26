package com.example.blog.controller;

import com.example.blog.dto.BlogDTO;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("/blog/")
    public ResponseEntity<String> createNewBlog(@RequestBody BlogDTO blogDTO){
        String message = blogService.newBlog(blogDTO);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> viewBlog(@PathVariable Integer id){
        String message = blogService.findBlog(id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<Map<Integer,BlogDTO>> viewAllBlogs(){
        Map<Integer,BlogDTO> allBlogs = blogService.getAll();
        return new ResponseEntity<>(allBlogs,HttpStatus.OK);
    }
}
