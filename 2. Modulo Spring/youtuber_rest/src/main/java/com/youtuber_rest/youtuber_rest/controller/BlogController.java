package com.youtuber_rest.youtuber_rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youtuber_rest.youtuber_rest.model.BlogModel;
import com.youtuber_rest.youtuber_rest.service.IBlogService;

@RestController
@RequestMapping("/Blog")
public class BlogController {

    @Autowired
    IBlogService blogService;
    
    @GetMapping("/All")
    public List<BlogModel> getAllBlog(){
        return blogService.getAllBlog();
    }

    @GetMapping("/{id}")
    public Optional<BlogModel> getBlogById(@PathVariable Long id){
        return blogService.getBlogById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> addBlog(@RequestBody BlogModel blog){
        return ResponseEntity.ok(blogService.addBLog(blog));
    }
}
