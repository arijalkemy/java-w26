package org.example.blog.controller;


import org.example.blog.dto.PostEntryDto;
import org.example.blog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    IPostService postService;

    @PostMapping("/blog")
    public String postBlog(@RequestBody PostEntryDto entry) {
        return postService.addNewPost(entry);
    }

    @GetMapping("blog")
    public ResponseEntity<List<PostEntryDto>> getBlog() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("blog/{id}")
    public ResponseEntity<PostEntryDto> getBlog(@PathVariable int id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

}
