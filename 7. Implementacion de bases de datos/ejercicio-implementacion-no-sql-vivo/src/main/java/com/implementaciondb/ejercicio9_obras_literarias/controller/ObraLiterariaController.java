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
    public ResponseEntity<ObraLiterariaResponseDto> createObraLiteraria(@RequestBody ObraLiterariaRequestDto obraLiterariaRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(obraLiterariaService.saveObraLiteraria(obraLiterariaRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<ObraLiterariaResponseDto>> getAllObrasLiterarias() {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.searchAllObrasLiterarias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObraLiterariaResponseDto> getObraLiterariaById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.searchObraLiterariaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObraLiterariaResponseDto> updateObraLiteraria(
            @PathVariable String id,
            @RequestBody ObraLiterariaRequestDto obraLiterariaRequestDto
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.updateObraLiteraria(id, obraLiterariaRequestDto));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObrasLiterariasByAuthor(
            @PathVariable String author
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.searchObrasLiterariasByAuthor(author));
    }

    @GetMapping("/title/{keyword}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObrasLiterariasByTitleKeyword(
            @PathVariable(name = "keyword") String keyword
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.searchObrasLiterariasByTitleKeyword(keyword));
    }

    @GetMapping("/pages")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObrasLiterariasByPagesNumber() {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.searchObrasLiterariasByPagesNumber());
    }

    @GetMapping("/year-publication-before/{year}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObrasLiterariasByYearPublicationBefore(
            @PathVariable(name = "year") Integer year
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
                obraLiterariaService.searchObrasLiterariasByYearPublicationBefore(year)
        );
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiterariaResponseDto>> getObrasLiterariasByEditorial(
        @PathVariable(name = "editorial") String editorial
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(obraLiterariaService.searchObrasLiterariasByEditorial(editorial));
    }
}
