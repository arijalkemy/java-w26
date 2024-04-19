package org.responseentity.manejoexcepciones1.controller;

import org.apache.coyote.Response;
import org.responseentity.manejoexcepciones1.dto.BlogDTO;
import org.responseentity.manejoexcepciones1.entity.BlogEntity;
import org.responseentity.manejoexcepciones1.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping
    public ResponseEntity<?> getAllBlogEntries(){
        List<BlogEntity> blogs = this.blogService.getAllTheBlogEntries();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertBlogEntry(@RequestBody BlogDTO blogDto){
        String msg = this.blogService.createBlogEntry(blogDto);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
