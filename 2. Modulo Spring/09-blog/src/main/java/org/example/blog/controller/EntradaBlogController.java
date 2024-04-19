package org.example.blog.controller;

import org.example.blog.dto.BlogDTO;
import org.example.blog.model.EntradaBlog;
import org.example.blog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {
    /*
    Crear una nueva entrada de Blog y devolver un mensaje adecuado diciendo que ha sido creada correctamente mostrando su “Id”. (URI: /blog).
    En el caso de que ya exista una entrada de blog con ese “Id”, capturar la excepción y devolver un mensaje indicando dicha situación.

    Devolver la información de una entrada de Blog específico, recibiendo el “Id” del mismo. (URI: /blog/{id}).
    Si el “Id” ingresado no corresponde a ninguna entrada de Blog, indicarlo con un mensaje adecuado.

    Devolver el listado de todas las entradas de blogs existentes. (URI: /blogs).
     */

    @Autowired
    IEntradaBlogService entradaBlogService;

    @PostMapping("/blog")
    public ResponseEntity<Integer> createNewBlog(@RequestBody BlogDTO blog) {
        return new ResponseEntity<>(entradaBlogService.create(blog), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> findBlogById(@PathVariable Integer id) {
        BlogDTO blogDto = entradaBlogService.findById(id);
        return new ResponseEntity<>(blogDto, HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> findAllBlogs() {
        List<BlogDTO> listBlogs = entradaBlogService.findAll();
        return new ResponseEntity<>(listBlogs, HttpStatus.OK);
    }





}
