package com.example._09_practicaexcepcionesteoria.controller;

import com.example._09_practicaexcepcionesteoria.dto.BlogPostDTO;
import com.example._09_practicaexcepcionesteoria.service.IBlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogPostController {
    @Autowired
    IBlogPostService iBlogPostService;

    @GetMapping
    public List<BlogPostDTO> getAll(){
        return iBlogPostService.getAll();
    }

    @GetMapping("/{id}")
    public BlogPostDTO getById(@PathVariable int id){

        return iBlogPostService.findById(id);
    }

    @PostMapping
    public int add(@RequestBody BlogPostDTO blogPostDTO){
        return iBlogPostService.add(blogPostDTO);
    }

}
