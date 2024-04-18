package com.practicaSpring.blog.controller;

import com.practicaSpring.blog.dto.BlogEntryDTO;
import com.practicaSpring.blog.service.IBlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.util.List;

@RestController
@RequestMapping("/")
public class BlogEntryController {
    @Autowired
    private IBlogEntryService blogEntryService;

    @PostMapping("blog")
    public ResponseEntity<Long> createBlogEntry(@RequestBody BlogEntryDTO blogEntry) {
        return new ResponseEntity<>(blogEntryService.createEntry(blogEntry), HttpStatus.CREATED);
    }

    @GetMapping("blog/{id}")
    public ResponseEntity<BlogEntryDTO> getBlogEntry(@PathVariable Long id){
        return ResponseEntity.ok(blogEntryService.getEntryById(id));
    }

    @GetMapping("blogs")
    public ResponseEntity<List<BlogEntryDTO>> getBlogs(){
        return ResponseEntity.ok(blogEntryService.getAllEntries());
    }
}
