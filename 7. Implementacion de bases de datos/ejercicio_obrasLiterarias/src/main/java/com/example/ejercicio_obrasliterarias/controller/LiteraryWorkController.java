package com.example.ejercicio_obrasliterarias.controller;

import com.example.ejercicio_obrasliterarias.entities.LiteraryWork;
import com.example.ejercicio_obrasliterarias.service.interfaces.ILiteraryWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/literaryWorks")
public class LiteraryWorkController {
    @Autowired
    private ILiteraryWorkService literaryWorkService;

    @GetMapping
    public ResponseEntity<List<LiteraryWork>> getAll(Pageable pageable) {
        return ResponseEntity.ok(
          literaryWorkService.getAll(pageable)
        );
    }

    @GetMapping("/byAuthorName/{authorName}")
    public ResponseEntity<List<LiteraryWork>> getAllByAuthorName(@PathVariable String authorName, Pageable pageable) {
        return ResponseEntity.ok(
                literaryWorkService.getAllByAuthorName(authorName, pageable)
        );
    }

    @GetMapping("/byTitle/{title}")
    public ResponseEntity<List<LiteraryWork>> getAllByTitle(@PathVariable String title, Pageable pageable) {
        return ResponseEntity.ok(
                literaryWorkService.getAllByTitle(title, pageable)
        );
    }

    @GetMapping("/top5Pages")
    public ResponseEntity<List<LiteraryWork>> getAllByPages(Pageable pageable) {
        return ResponseEntity.ok(
                literaryWorkService.getTop5ByPages(pageable)
        );
    }

    @GetMapping("/beforeYear/{year}")
    public ResponseEntity<List<LiteraryWork>> getAllBeforeYear(@PathVariable int year, Pageable pageable) {
        return ResponseEntity.ok(
                literaryWorkService.getAllBeforeYear(year, pageable)
        );
    }

    @GetMapping("/byEditorial/{name}")
    public ResponseEntity<List<LiteraryWork>> getAllBeforeYear(@PathVariable String name, Pageable pageable) {
        return ResponseEntity.ok(
                literaryWorkService.getAllByEditorial(name, pageable)
        );
    }
}
