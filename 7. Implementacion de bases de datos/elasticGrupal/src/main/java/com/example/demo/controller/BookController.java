package com.example.demo.controller;

import com.example.demo.dto.BookResponse;
import com.example.demo.model.Book;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService bookService;

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @GetMapping("author/{author}")
    public ResponseEntity<List<BookResponse>> getBooksByAuthor(@PathVariable String author ) {
        return new ResponseEntity<>(bookService.getBooksByAuthor(author), HttpStatus.OK);
    }
    @GetMapping("word/{word}")
    public ResponseEntity<List<BookResponse>> getBooksByWordInTitle(@PathVariable String word ) {
        return new ResponseEntity<>(bookService.getBooksByWordInTitle(word), HttpStatus.OK);
    }

    @GetMapping("/pages")
    public ResponseEntity<List<BookResponse>> getBooksByPagesInOrder() {
        return new ResponseEntity<>(bookService.getBooksWithMorePagesInOrder(), HttpStatus.OK);
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<BookResponse>> getBooksYearBefore(@PathVariable String year) {
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy"); // Formato para el año
            Date date = dateFormat.parse(year);
            return new ResponseEntity<>(bookService.getBooksDateBefore(date), HttpStatus.OK);
        }catch (ParseException e) {
            System.out.println("Error al analizar la cadena de año.");
        }
        return null;

    }

    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<List<BookResponse>> getByPublisher(@PathVariable String publisher) {
        return new ResponseEntity<>(bookService.getBooksByPublisher(publisher), HttpStatus.OK);

    }
}
