package com.ej1p1dia4spring.blog.controller;

import com.ej1p1dia4spring.blog.dto.BlogDTO;
import com.ej1p1dia4spring.blog.exceptions.AlreadyExistsException;
import com.ej1p1dia4spring.blog.exceptions.NotFoundException;
import com.ej1p1dia4spring.blog.service.IBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    private IBlog blogService;

    @PostMapping("/blog")
    public String agregarEntrada(@RequestBody BlogDTO blogDTO) {
        return blogService.agregarEntradaBlog(blogDTO);
    }

    @ExceptionHandler
    public String AlreadyExistsException(AlreadyExistsException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler
    public String notFoundException(NotFoundException ex) {
        return ex.getMessage();
    }
}
