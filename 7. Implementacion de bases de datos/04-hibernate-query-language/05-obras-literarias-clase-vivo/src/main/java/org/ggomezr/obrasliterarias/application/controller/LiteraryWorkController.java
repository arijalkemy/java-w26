package org.ggomezr.obrasliterarias.application.controller;

import org.ggomezr.obrasliterarias.application.service.interfaces.ILiteraryWorkService;
import org.ggomezr.obrasliterarias.domain.dto.LiteraryWorkDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/literary-works")
public class LiteraryWorkController {

    private final ILiteraryWorkService literaryWorkService;

    public LiteraryWorkController(ILiteraryWorkService literaryWorkService) {
        this.literaryWorkService = literaryWorkService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody LiteraryWorkDTO literaryWorkDTO) {
        return new ResponseEntity<>(literaryWorkService.create(literaryWorkDTO), HttpStatus.CREATED);
    }

    @PostMapping("/create/bulk")
    public ResponseEntity<?> createAll(@RequestBody List<LiteraryWorkDTO> literaryWorkDTO) {
        return new ResponseEntity<>(literaryWorkService.createAll(literaryWorkDTO), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(literaryWorkService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return new ResponseEntity<>(literaryWorkService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody LiteraryWorkDTO literaryWorkDTO) {
        return new ResponseEntity<>(literaryWorkService.update(id, literaryWorkDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return new ResponseEntity<>(literaryWorkService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/find-by-author/{author}")
    public ResponseEntity<?> findByAuthor(@PathVariable String author) {
        return new ResponseEntity<>(literaryWorkService.findByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/find-by-title-containing/{title}")
    public ResponseEntity<?> findByTitleContaining(@PathVariable String title) {
        return new ResponseEntity<>(literaryWorkService.findByTitleContaining(title), HttpStatus.OK);
    }

    @GetMapping("/find-top-5-by-pages-desc")
    public ResponseEntity<?> findTop5ByPagesDesc() {
        return new ResponseEntity<>(literaryWorkService.findTop5ByPagesDesc(), HttpStatus.OK);
    }

    @GetMapping("/find-by-release-date-year-before/{releaseDateYear}")
    public ResponseEntity<?> findByReleaseDateYearBefore(@PathVariable Integer releaseDateYear) {
        return new ResponseEntity<>(literaryWorkService.findByReleaseDateYearBefore(releaseDateYear), HttpStatus.OK);
    }

    @GetMapping("/find-by-editorial/{editorial}")
    public ResponseEntity<?> findByEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(literaryWorkService.findByEditorial(editorial), HttpStatus.OK);
    }
}
