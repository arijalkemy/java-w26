package com.meli.Obras.literarias.controller;

import com.meli.Obras.literarias.dto.ObraDto;
import com.meli.Obras.literarias.model.Obra;
import com.meli.Obras.literarias.service.IObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra")
public class ObraController {

    @Autowired
    private IObraService obraService;

    @PostMapping("/new")
    public ResponseEntity<ObraDto> crearObra(@RequestBody ObraDto obraDto){
        return new ResponseEntity<>(obraService.crearObra(obraDto), HttpStatus.CREATED);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraDto>> getObrasByAutor(@PathVariable String autor){
        return ResponseEntity.ok(obraService.getObrasByAutor(autor));
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<ObraDto>> getObrasByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(obraService.getObrasByTitulo(titulo));
    }

    @GetMapping("/conMasCantidadDePaginas")
    public ResponseEntity<List<ObraDto>> getObrasConMasCantidadDePaginas(){
        return ResponseEntity.ok(obraService.getObrasConMasCantidadDePaginas());
    }

    @GetMapping("/fechaPublicacionMenorA/{anio}")
    public ResponseEntity<List<ObraDto>> getObrasByFechaPublicacion(@PathVariable int anio){
        return ResponseEntity.ok(obraService.getObrasByFechaPublicacion(anio));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraDto>> getObrasByEditorial(@PathVariable String editorial){
        return ResponseEntity.ok(obraService.getObrasByEditorial(editorial));
    }
}
