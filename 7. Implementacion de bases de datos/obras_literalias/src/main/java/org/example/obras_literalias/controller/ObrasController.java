package org.example.obras_literalias.controller;

import org.example.obras_literalias.services.IObraService;
import org.example.obras_literalias.services.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/obras")
public class ObrasController {

    @Autowired
    IObraService obraService;

    @GetMapping(params = "author_name")
    ResponseEntity<?>getObraPorAutor(@RequestParam String author_name){
        return new ResponseEntity<>(obraService.findByAuthor(author_name), HttpStatus.OK);
    }
    @GetMapping(params = "keyword")
    ResponseEntity<?>getObraPorTitulo(@RequestParam String keyword){
        return new ResponseEntity<>(obraService.findByTitleKeyword(keyword),HttpStatus.OK);
    }
    @GetMapping("/topPorPagina")
    ResponseEntity<?> getObrasConMasPaginas(){
        return new ResponseEntity<>(obraService.findTopFiveWithMoreAmountPages(),HttpStatus.OK);
    }
    @GetMapping("/publicadasAntes")
    ResponseEntity<?>getObrasPublicadasAntesDe(@RequestParam Integer yearPublished){
        return new ResponseEntity<>(obraService.findAllPublishedBeforeYear(yearPublished),HttpStatus.OK);
    }
    @GetMapping(params = "editorial")
    ResponseEntity<?> getObrasPorEditorial(@RequestParam String editorial){
        return new ResponseEntity<>(obraService.findAllByEditorial(editorial),HttpStatus.OK);
    }

}
