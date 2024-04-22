package org.ggomezr.blog.application.controller;

import org.ggomezr.blog.application.service.impl.BlogService;
import org.ggomezr.blog.domain.dto.BlogEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> createBlogEntry(@RequestBody BlogEntryDTO blogEntryDTO){
        return new ResponseEntity<>(blogService.createBlogEntry(blogEntryDTO), HttpStatus.CREATED);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlogEntries(){
        return new ResponseEntity<>(blogService.getAllBlogEntries(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogEntryById(@PathVariable Integer id){
        return new ResponseEntity<>(blogService.getBlogEntryById(id), HttpStatus.OK);
    }
}
