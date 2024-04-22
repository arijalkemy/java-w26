package com.ej1p1dia4spring.blog.controller;

import com.ej1p1dia4spring.blog.dto.BlogDTO;
import com.ej1p1dia4spring.blog.exceptions.AlreadyExistsException;
import com.ej1p1dia4spring.blog.service.IBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private IBlog blogService;

    @PostMapping("/blog")
    public String agregarEntrada(@RequestBody BlogDTO blogDTO) {
        return blogService.agregarEntradaBlog(blogDTO);
    }

    @GetMapping("/blog/{id}")
    public BlogDTO buscarEntrada(@PathVariable int id) {
        return blogService.buscarEntradaBlog(id);
    }

    @GetMapping("/blogs")
    public List<BlogDTO> buscarTodos() {
        return blogService.listarEntradas();
    }

    @ExceptionHandler
    public String AlreadyExistsException(AlreadyExistsException ex) {
        return ex.getMessage();
    }
}
