package com.implementaciondb.ejercicio9_obras_literarias.controller;

import com.implementaciondb.ejercicio9_obras_literarias.model.dto.ObraLiterariaRequestDto;
import com.implementaciondb.ejercicio9_obras_literarias.model.dto.ObraLiterariaResponseDto;
import com.implementaciondb.ejercicio9_obras_literarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras-literarias")
public class ObraLiterariaController {

    @Autowired
    private IObraLiterariaService obraLiterariaService;

    @PostMapping
    public ResponseEntity<ObraLiterariaResponseDto> createObraLiteraria(@RequestBody ObraLiterariaRequestDto obraLiteraria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(obraLiterariaService.saveObraLiteraria(obraLiteraria));
    }

    @GetMapping
    public ResponseEntity<List<ObraLiterariaResponseDto>> getAllObraLiterarias() {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.findAllObraLiterarias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObraLiterariaResponseDto> getObraLiterariaById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.findObraLiterariaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObraLiterariaResponseDto> updateObraLiteraria(
            @PathVariable String id,
            @RequestBody ObraLiterariaRequestDto obraLiteraria
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.updateObraLiteraria(id, obraLiteraria));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getBooksByAuthor(
            @PathVariable String author
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.findBooksByAuthor(author));
    }

    @GetMapping("/title/{key_word}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getBooksByKeyWordTitle(
            @PathVariable(name = "key_word") String key_word
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.findBooksByKeyWordTitle(key_word));
    }

    @GetMapping("/pages")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getBooksByNumberPages() {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.findBooksByNumberPages());
    }

    @GetMapping("/year-publication/{year_publicatioin}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getBooksByYearPublication(
            @PathVariable (name = "year_publicatioin") Integer yearPublication
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
                obraLiterariaService.findBooksByYearPublication(yearPublication)
        );
    }

    @GetMapping("/editorial/{key_word}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getBooksByKeyWordEditorial(
            @PathVariable(name = "key_word") String key_word
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.findBooksByKeyWordEditorial(key_word));
    }
}
