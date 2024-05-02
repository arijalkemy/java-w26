package org.bootcamp.blog.controller;

import org.bootcamp.blog.dto.BlogDTO;
import org.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired private IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> createBlog(@RequestBody BlogDTO blogDTO) {
        return ResponseEntity.ok(blogService.createBlog(blogDTO));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable int id) {
        return ResponseEntity.ok(blogService.getBlog(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getBlogs() {
        return ResponseEntity.ok(blogService.getBlogs());
    }
}
