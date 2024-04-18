package com.w26.blog.controller;

import com.w26.blog.dto.BlogRequest;
import com.w26.blog.dto.BlogResponse;
import com.w26.blog.entity.Blog;
import com.w26.blog.service.IBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

    final IBlogService serviceBlog;

    @PostMapping
    public ResponseEntity<BlogResponse> postBlog(@RequestBody BlogRequest newBlog)
    {
        BlogResponse response = serviceBlog.createBlog(newBlog);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = {"/{id}", ""})
    public ResponseEntity<?> getBlog(@PathVariable(required = false) Integer id)
    {
        if (id != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(serviceBlog.getBlog(id));
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body(serviceBlog.getAllBlog());
        }
    }
}
