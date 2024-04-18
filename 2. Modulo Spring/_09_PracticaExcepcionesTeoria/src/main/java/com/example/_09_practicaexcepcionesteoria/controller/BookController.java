package com.example._09_practicaexcepcionesteoria.controller;

import com.example._09_practicaexcepcionesteoria.entity.Book;
import com.example._09_practicaexcepcionesteoria.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    IBookService iBookService;

    @GetMapping("/books")
    public List<Book> getAll(){
        return iBookService.getAll();
    }

    @GetMapping("/books/{id}")
    public Book findById(@PathVariable Long id){
        return iBookService.findById(id);
    }

}
