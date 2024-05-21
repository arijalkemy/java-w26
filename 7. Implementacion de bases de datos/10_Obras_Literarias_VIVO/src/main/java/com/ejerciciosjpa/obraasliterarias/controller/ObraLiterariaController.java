package com.ejerciciosjpa.obraasliterarias.controller;

import com.ejerciciosjpa.obraasliterarias.dto.RequestObraLiterariaDto;
import com.ejerciciosjpa.obraasliterarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class ObraLiterariaController {
    @Autowired
    IObraLiterariaService obraLiterariaService;

    @GetMapping("/obras/all")
    public ResponseEntity<?> getAllObras(){
       return ResponseEntity.ok(obraLiterariaService.findAll());
    }

    @PostMapping("/obras/new")
    public ResponseEntity<?> saveObra(@RequestBody RequestObraLiterariaDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(obraLiterariaService.create(request));
    }
    @GetMapping("/obras/autor/{nombre}")
    public ResponseEntity<?> getObrasByAutor(@PathVariable String nombre){
        return ResponseEntity.ok(obraLiterariaService.findObraById(nombre));

    }
    @GetMapping("/obras/titulo/{clave}")
    public ResponseEntity<?> getObrasByKeyword(@PathVariable String clave){
        return ResponseEntity.ok(obraLiterariaService.findObraByClave(clave));
    }
    @GetMapping("/obras/top")
    public ResponseEntity<?> getObrasByLength(){
        return ResponseEntity.ok(obraLiterariaService.findTopObrasByLength());
    }
    @GetMapping("/obras/before/{year}")
    public ResponseEntity<?> getObrasBefore(@PathVariable Integer year){
        return ResponseEntity.ok(obraLiterariaService.findObrasBefore(year));
    }
    @GetMapping("/obras/{editorial}")
    public ResponseEntity<?> getObrasByEditorial(@PathVariable String editorial){
        return ResponseEntity.ok(obraLiterariaService.findObrasByEditorial(editorial));
    }
}
