package org.responseentity.elasticspring.controller;

import jakarta.websocket.server.PathParam;
import org.responseentity.elasticspring.service.ObraLiteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/obras")
public class ObraLiterariaController {

    @Autowired
    private ObraLiteriaService obraLiteriaService;

    @GetMapping()
    public ResponseEntity<?> findAllByAuthor(@PathParam("author") String autor){
        return new ResponseEntity<>(obraLiteriaService.findAllByAuthor(autor), HttpStatus.OK);
    }

    @GetMapping("/nombre")
    public ResponseEntity<?> findByTitle(@PathParam("nombre") String nombre){
        return new ResponseEntity<>(obraLiteriaService.findKeywordInTitle(nombre), HttpStatus.OK);
    }

    @GetMapping("/paginas")
    public ResponseEntity<?> findTopFivePages(){
        return new ResponseEntity<>(obraLiteriaService.findTopFivePages(), HttpStatus.OK);
    }

    @GetMapping("/years")
    public ResponseEntity<?> findPreviousYear(@PathParam("year") Integer year){
        return new ResponseEntity<>(obraLiteriaService.findPreviousYear(year), HttpStatus.OK);
    }

    @GetMapping("/editorial")
    public ResponseEntity<?> findAllByEditorial(@PathParam("editorial") String editorial){
        return new ResponseEntity<>(obraLiteriaService.findAllByEditorial(editorial), HttpStatus.OK);
    }
}
