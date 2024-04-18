package com.meli.bootcamp.blog.controller;

import com.meli.bootcamp.blog.dto.RequestEntradaBlogDto;
import com.meli.bootcamp.blog.dto.ResponseEntradaBlogDto;
import com.meli.bootcamp.blog.service.EntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class EntradaBlogController {

    EntradaBlogService entradaBlogService;

    @Autowired
    public EntradaBlogController(EntradaBlogService entradaBlogService) {
        this.entradaBlogService = entradaBlogService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
    @GetMapping
    public ResponseEntity<List<ResponseEntradaBlogDto>> getAll(){
        List<ResponseEntradaBlogDto> response = entradaBlogService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping
    public ResponseEntity<String> post(@RequestBody RequestEntradaBlogDto dto){
        String response = entradaBlogService.add(dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseEntradaBlogDto> getByid(@PathVariable Integer id){
        ResponseEntradaBlogDto response = entradaBlogService.getById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }
}
