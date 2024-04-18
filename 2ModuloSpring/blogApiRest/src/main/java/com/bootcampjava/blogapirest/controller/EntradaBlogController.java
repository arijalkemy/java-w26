package com.bootcampjava.blogapirest.controller;

import com.bootcampjava.blogapirest.model.DTO.EntradBlogDTO;
import com.bootcampjava.blogapirest.model.EntradaBlog;
import com.bootcampjava.blogapirest.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {
    @Autowired
    IEntradaBlogService entradaBlogService;

    @PostMapping("")
    ResponseEntity<EntradBlogDTO> crearEntrada(@RequestBody EntradaBlog nuevaEntrada){
        return ResponseEntity.ofNullable(entradaBlogService.cargarUna(nuevaEntrada));
    }
    @GetMapping("")
    ResponseEntity<List<EntradBlogDTO>> traerTodas(){
        return ResponseEntity.ofNullable(entradaBlogService.traerTodas()) ;
    }
    @GetMapping("/{id}")
    ResponseEntity<EntradBlogDTO> traerUna(@PathVariable Integer id){
        return ResponseEntity.ofNullable(entradaBlogService.traerUnaPorId(id)) ;
    }


}
