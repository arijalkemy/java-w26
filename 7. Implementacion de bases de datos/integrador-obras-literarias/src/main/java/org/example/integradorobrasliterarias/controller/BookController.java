package org.example.integradorobrasliterarias.controller;


import lombok.RequiredArgsConstructor;
import org.example.integradorobrasliterarias.entity.dto.BookRequestDTO;
import org.example.integradorobrasliterarias.service.IBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final IBookService bookService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/author/{name}")
    @ResponseBody
    public ResponseEntity<?> getAllBooksByAuthorName(@PathVariable String name){
        return ResponseEntity.ok(bookService.findAllByAuthorName(name));
    }

    @GetMapping("/editorial/{editorial}")
    @ResponseBody
    public ResponseEntity<?> getAllBooksByEditorial(@PathVariable String editorial){
        return ResponseEntity.ok(bookService.findAllByEditorial(editorial));
    }

    @GetMapping("/name/{keyword}")
    @ResponseBody
    public ResponseEntity<?> getAllBooksByKeyword(@PathVariable String keyword){
        return ResponseEntity.ok(bookService.findAllByKeyword(keyword));
    }

    @GetMapping("/pages")
    @ResponseBody
    public ResponseEntity<?> getAllByTop5Pages(){
        return ResponseEntity.ok(bookService.findAllTopByPages());
    }

    @GetMapping("/year/{year}")
    @ResponseBody
    public ResponseEntity<?> getAllByPublicationYear(@PathVariable Integer year){
        return ResponseEntity.ok(bookService.findAllByPublicationYearBefore(year));
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> saveBook(@RequestBody BookRequestDTO bookRequestDTO){
        bookService.saveBook(bookRequestDTO);
        return ResponseEntity.ok("Saved");
    }
}
