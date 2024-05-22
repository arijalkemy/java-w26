package org.example.obrasliterarias.controller;

import jakarta.validation.Valid;
import org.example.obrasliterarias.dto.ObraLiterariaRequestDto;
import org.example.obrasliterarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra")
public class ObraLiterariaController {
    private final IObraLiterariaService obraLiterariaService;

    public ObraLiterariaController(@Autowired IObraLiterariaService obraLiterariaService) {
        this.obraLiterariaService = obraLiterariaService;
    }

    @PostMapping("/bulk")
    public ResponseEntity<?> saveBulk(@RequestBody @Valid List<ObraLiterariaRequestDto> obrasLiterias) {
        return new ResponseEntity<>(obraLiterariaService.saveBulk(obrasLiterias), HttpStatus.CREATED);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<?> getByAuthor(@PathVariable("author") String author, Pageable pageable) {
        return new ResponseEntity<>(obraLiterariaService.findByAuthor(author, pageable), HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getByTitleWildCard(@PathVariable("title") String title, Pageable pageable) {
        return new ResponseEntity<>(obraLiterariaService.getByTitleWildCard(title, pageable), HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<?> getTopByAmountPages(Pageable pageable) {
        return new ResponseEntity<>(obraLiterariaService.getTopByAmountPages(pageable), HttpStatus.OK);
    }

    @GetMapping("/less-year/{year}")
    public ResponseEntity<?> getByYearLess(@PathVariable Integer year, Pageable pageable) {
        return new ResponseEntity<>(obraLiterariaService.getByYearLess(year, pageable), HttpStatus.OK);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> getByEditorial(@PathVariable("editorial") String editorial, Pageable pageable) {
        return new ResponseEntity<>(obraLiterariaService.findByEditorial(editorial, pageable), HttpStatus.OK);
    }
}
