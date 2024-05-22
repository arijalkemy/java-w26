package com.example.elastic.controller;

import com.example.elastic.dto.BookDto;
import com.example.elastic.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    IBookService bookService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.create(bookDto));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/author")
    public ResponseEntity<?> findAllByAuthor(@RequestParam String author) {
        return ResponseEntity.ok(bookService.findAllByAuthor(author));
    }

    @GetMapping("/name")
    public ResponseEntity<?> findAllByNameContains(@RequestParam String name) {
        return ResponseEntity.ok(bookService.findAllByNameContains(name));
    }

    @GetMapping("/top5")
    public ResponseEntity<?> findTopBy5PagesOrderByPagesDesc() {
        return ResponseEntity.ok(bookService.findTopBy5PagesOrderByPagesDesc());
    }

    @GetMapping("/year")
    public ResponseEntity<?> findAllByYearBefore(@RequestParam int year) {
        return ResponseEntity.ok(bookService.findAllByYearBefore(year));
    }
    @GetMapping("/editorial")
    public ResponseEntity<?> findAllByEditorialIs(@RequestParam String editorial) {
        return ResponseEntity.ok(bookService.findAllByEditorialIs(editorial));
    }
}
