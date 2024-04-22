package com.blog.excercise.controller;

import com.blog.excercise.dto.BlogDTO;
import com.blog.excercise.entity.EntradaBlog;
import com.blog.excercise.excpetion.NotFoundException;
import com.blog.excercise.service.BlogService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/youtube")
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> createNewBlog(@RequestBody BlogDTO inputBlogDTO){
        Integer id = blogService.postNewBlog(inputBlogDTO);

        return new ResponseEntity<>("Credao correctamente! ID: " + id, HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getBlogById(@PathVariable Integer id){

         BlogDTO responseBlogDTO = blogService.getBlogById(id);
         if(responseBlogDTO == null){
             throw new NotFoundException("El blog no existe en la base de datos");
         }

         return new ResponseEntity<>(responseBlogDTO, HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getAllBlogs(){

        List<BlogDTO> listaEntradaBlog = blogService.getAllBlogs();
        if(listaEntradaBlog == null){
            throw new NotFoundException("No existen blogs en la base de datos");
        }

        return new ResponseEntity<>(listaEntradaBlog, HttpStatus.OK);

    }


}
