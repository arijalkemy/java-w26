package org.mercadolibre.multicapatemplate.controller;

import org.mercadolibre.multicapatemplate.dto.BlogEntryRequestDTO;
import org.mercadolibre.multicapatemplate.dto.BlogEntryResponseDTO;
import org.mercadolibre.multicapatemplate.service.impl.BlogEntryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    final BlogEntryServiceImpl blogEntryService;

    public BlogController(BlogEntryServiceImpl blogEntryService) {
        this.blogEntryService = blogEntryService;
    }

    @PostMapping("/blog")
    public ResponseEntity<String> saveBlogEntry(@RequestBody BlogEntryRequestDTO blogEntryRequestDTO) {
        return new ResponseEntity<>(
                "Se creo entrada en el blog con id = "+ blogEntryService.saveBlogEntry(blogEntryRequestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogEntryResponseDTO> getBlogEntryById(@PathVariable int id) {
        return new ResponseEntity<>(
                blogEntryService.findById(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogEntryResponseDTO>> findAllBlogs() {
        return new ResponseEntity<>(
                blogEntryService.findAll(), HttpStatus.OK
        );
    }

}
