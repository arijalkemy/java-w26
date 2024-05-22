package org.example.literary_works.controller;

import org.example.literary_works.dtos.LiteraryWorkDto;
import org.example.literary_works.dtos.LiteraryWorkResDto;
import org.example.literary_works.service.interfaces.ILiteraryWorkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LiteraryController {
    private final ILiteraryWorkService service;

    public LiteraryController(ILiteraryWorkService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<LiteraryWorkResDto>> findAll() {
        List<LiteraryWorkResDto> resDtoList = service.findAll();
        return ResponseEntity.ok(resDtoList);
    }

    @GetMapping("/author")
    public ResponseEntity<List<LiteraryWorkResDto>> findByAuthor(
            @RequestParam String author
    ) {
        List<LiteraryWorkResDto> resDtoList = service.findByAuthor(author);
        return ResponseEntity.ok(resDtoList);
    }

    @GetMapping("/title")
    public ResponseEntity<List<LiteraryWorkResDto>> findByTitle(
            @RequestParam String title
    ) {
        List<LiteraryWorkResDto> resDtoList = service.findByTitle(title);
        return ResponseEntity.ok(resDtoList);
    }

    @GetMapping("/top")
    public ResponseEntity<List<LiteraryWorkResDto>> getTopFive() {
        List<LiteraryWorkResDto> resDtoList = service.getTopFive();
        return ResponseEntity.ok(resDtoList);
    }

    @GetMapping("/before-year")
    public ResponseEntity<List<LiteraryWorkResDto>> findBeforeYear(
            @RequestParam Integer year
    ) {
        List<LiteraryWorkResDto> resDtoList = service.findBeforeYear(year);
        return ResponseEntity.ok(resDtoList);
    }

    @GetMapping("/publisher")
    public ResponseEntity<List<LiteraryWorkResDto>> findByPublisher(
            @RequestParam String publisher
    ) {
        List<LiteraryWorkResDto> resDtoList = service.findByPublisher(publisher);
        return ResponseEntity.ok(resDtoList);
    }

    @PostMapping("/new")
    public ResponseEntity<LiteraryWorkResDto> create(
            @RequestBody LiteraryWorkDto literaryWorkDto
    ) {
        LiteraryWorkResDto resDto = service.create(literaryWorkDto);
        return new ResponseEntity<>(resDto, HttpStatus.CREATED);
    }
}
