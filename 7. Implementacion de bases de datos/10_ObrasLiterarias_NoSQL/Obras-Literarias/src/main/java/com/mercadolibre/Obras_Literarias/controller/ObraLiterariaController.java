package com.mercadolibre.Obras_Literarias.controller;

import com.mercadolibre.Obras_Literarias.dto.ObraLiterariaDto;
import com.mercadolibre.Obras_Literarias.dto.ObraLiterariaResponseDto;
import com.mercadolibre.Obras_Literarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra")
public class ObraLiterariaController {

    @Autowired
    IObraLiterariaService service;

    @PostMapping("")
    public ResponseEntity<?> saveObra(@RequestBody ObraLiterariaDto obraLiterariaDto) {
        return new ResponseEntity<>(service.saveObra(obraLiterariaDto), HttpStatus.OK);
    }

    //Retornar todas las obras por autor
    @GetMapping("/buscarporautor/{autor}")
    public  ResponseEntity<List<ObraLiterariaResponseDto>> getObra(@PathVariable String autor){
        return new ResponseEntity<>(service.getObrasByAutor(autor), HttpStatus.OK);
    }

    //Retornar las obras que contengan palabras claves en sus títulos
    @GetMapping("/buscarportitulo/{titulo}")
    public  ResponseEntity<List<ObraLiterariaResponseDto>> getObrasByTitulo(@PathVariable String titulo){
        return new ResponseEntity<>(service.getObrasByTitulo(titulo), HttpStatus.OK);
    }


    //Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    @GetMapping("/top5")
    public  ResponseEntity<List<ObraLiterariaResponseDto>> getObra(){
        return new ResponseEntity<>(service.getObrasTop5QuantityPages(), HttpStatus.OK);
    }

    //Retornar las obras que fueron publicadas antes de un determinado año
    @GetMapping("/buscarporanio/{anio}")
    public  ResponseEntity<List<ObraLiterariaResponseDto>> getObrasByAnio(@PathVariable int anio){
        return new ResponseEntity<>(service.getObrasBefore(anio), HttpStatus.OK);
    }

    //Retornar todas las obras de una determinada editorial
    @GetMapping("/buscarporeditorial/{editorial}")
    public  ResponseEntity<List<ObraLiterariaResponseDto>> getObrasByEditorial(@PathVariable String editorial){
        return new ResponseEntity<>(service.getObrasByEditorial(editorial), HttpStatus.OK);
    }
}
