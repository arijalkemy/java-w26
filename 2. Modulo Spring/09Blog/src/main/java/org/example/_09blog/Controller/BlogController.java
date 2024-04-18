package org.example._09blog.Controller;

import org.example._09blog.DTO.GetBlogResponseDTO;
import org.example._09blog.DTO.NewBlogRequestDTO;
import org.example._09blog.DTO.NewBlogResponseDTO;
import org.example._09blog.Service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("/blogs/{id}")
    public ResponseEntity<GetBlogResponseDTO> getBlog(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.retrieveBlog(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<GetBlogResponseDTO>> getBlogs() {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.retrieveAllBlogs());
    }

    @PostMapping("/blogs")
    public ResponseEntity<NewBlogResponseDTO> newBlog(@RequestBody NewBlogRequestDTO newBlogRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.createBlog(newBlogRequestDTO));
    }
}
