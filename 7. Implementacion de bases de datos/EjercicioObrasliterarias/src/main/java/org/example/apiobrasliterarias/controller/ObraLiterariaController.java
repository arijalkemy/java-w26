package org.example.apiobrasliterarias.controller;

import org.example.apiobrasliterarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObraLiterariaController {
    @Autowired
    IObraLiterariaService obraLiterariaService;

    @GetMapping("/obrasliterarias/{autor}")
    public ResponseEntity<?> getByAutor(@PathVariable String autor) {
        return ResponseEntity.ok(obraLiterariaService.getByAutor(autor));
    }

    @GetMapping("/obrasliterarias/keyword/{keyword}")
    public ResponseEntity<?> getByKeyword(@PathVariable String keyword) {
        return ResponseEntity.ok(obraLiterariaService.getByKeyword(keyword));
    }

    @GetMapping("/obrasliterarias/topfive")
    public ResponseEntity<?> getTopFiveByPages() {
        return ResponseEntity.ok(obraLiterariaService.getTopFiveByPages());
    }

    @GetMapping("/obrasliterarias/beforeyear/{year}")
    public ResponseEntity<?> getByBeforeYear(@PathVariable int year) {
        return ResponseEntity.ok(obraLiterariaService.getByBeforeYear(year));
    }

    @GetMapping("/obrasliterarias/editorial/{editorial}")
    public ResponseEntity<?> getByEditorial(@PathVariable String editorial) {
        return ResponseEntity.ok(obraLiterariaService.getByEditorial(editorial));
    }
}
