package org.example.blog.controllers;

import org.example.blog.dto.BlogDto;
import org.example.blog.services.IBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final IBlog iBlog;

    public BlogController(@Autowired IBlog iBlog) {
        this.iBlog = iBlog;
    }

    @PostMapping
    public ResponseEntity<Integer> saveBlog(@RequestBody BlogDto blog) {
        return ResponseEntity.ok(this.iBlog.saveBlog(blog));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> getBlog(@PathVariable Integer id) {
        return ResponseEntity.ok(this.iBlog.getBlogById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BlogDto>> getAllBlog() {
        return ResponseEntity.ok(this.iBlog.getListBlog());
    }

}
