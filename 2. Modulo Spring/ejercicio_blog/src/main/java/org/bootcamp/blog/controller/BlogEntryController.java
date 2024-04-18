package org.bootcamp.blog.controller;

import org.bootcamp.blog.dto.BlogEntryDTO;
import org.bootcamp.blog.service.BlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogEntryController {

    @Autowired
    private BlogEntryService blogEntryService;

    @PostMapping("/")
    public ResponseEntity<?> saveBlogEntry(@RequestBody BlogEntryDTO blogEntryDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(blogEntryService.save(blogEntryDTO));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(blogEntryService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return ResponseEntity.ok(blogEntryService.getById(id));
    }
}
