package com.example.demo.controller;

import com.example.demo.model.dto.BookDTO;
import com.example.demo.model.entity.Book;
import com.example.demo.service.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO book) {
        BookDTO savedBook = bookService.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


    @GetMapping("/books/author/{author}")
    public ResponseEntity<List<BookDTO>> getBooksByAuthor(@PathVariable String author) {
        List<BookDTO> books = bookService.findByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/title/{keyword}")
    public ResponseEntity<List<BookDTO>> getBooksByTitleContaining(@PathVariable String keyword) {
        List<BookDTO> books = bookService.findByTitleContaining(keyword);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/top5")
    public ResponseEntity<List<BookDTO>> getTop5BooksByPageCount() {
        List<BookDTO> books = bookService.findTop5ByOrderByPageCountDesc();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/publishedBefore/{year}")
    public ResponseEntity<List<BookDTO>> getBooksPublishedBeforeYear(@PathVariable Year year) {
        List<BookDTO> books = bookService.findByPublicationYearBefore(year);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/publisher/{publisher}")
    public ResponseEntity<List<BookDTO>> getBooksByPublisher(@PathVariable String publisher) {
        List<BookDTO> books = bookService.findByPublisher(publisher);
        return ResponseEntity.ok(books);
    }

}
