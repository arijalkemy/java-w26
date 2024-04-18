package com.spring.blog.controller;

import com.spring.blog.dto.BlogEntryDTO;
import com.spring.blog.dto.BlogEntryResponseDTO;
import com.spring.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogsController {

    @Autowired
    IBlogService blogService;

    @GetMapping("blog/{id}")
    public BlogEntryResponseDTO getBlogById(@PathVariable Integer id) {
        return this.blogService.findBlogById(id);
    }

    @PostMapping("blog")
    ResponseEntity<Integer> postBlogEntry(@RequestBody BlogEntryDTO blogEntry) {
        Integer id = this.blogService.createBlog(blogEntry);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("blogs")
    public List<BlogEntryResponseDTO> getAllBlogs() {
        return this.blogService.findAllBlogs();
    }

}
