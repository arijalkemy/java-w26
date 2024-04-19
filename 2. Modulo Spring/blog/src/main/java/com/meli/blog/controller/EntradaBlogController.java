package com.meli.blog.controller;

import com.meli.blog.dto.EntradaBlogDTO;
import com.meli.blog.dto.MensajeDTO;
import com.meli.blog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class EntradaBlogController {

    @Autowired
    private IEntradaBlogService service;

    @PostMapping("/")
    public ResponseEntity<MensajeDTO> crearEntrada(@RequestBody EntradaBlogDTO entradaBlog){
        return new ResponseEntity<>(service.crearEntrada(entradaBlog), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogDTO> getEntrada(@PathVariable String id){
        return ResponseEntity.ok(service.getEntrada(id));
    }

    @GetMapping("/")
    public List<EntradaBlogDTO> getListaEntradas(){
        return service.getListaEntradas();
    }
}
