package com.mercadolibre.LinkTracerAPI.controller;

import com.mercadolibre.LinkTracerAPI.dto.LinkDTO;
import com.mercadolibre.LinkTracerAPI.dto.LinkEstadisticaDTO;
import com.mercadolibre.LinkTracerAPI.dto.LinkRedireccionDTO;
import com.mercadolibre.LinkTracerAPI.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class LinkController {
    @Autowired
    ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<Integer> crearLink(@RequestBody LinkDTO link){
        return ResponseEntity.status(HttpStatus.OK).body(linkService.crearLink(link));
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<LinkRedireccionDTO> redireccionar(@PathVariable Integer id, @RequestParam String contraseña){
        return ResponseEntity.status(HttpStatus.OK).body(linkService.redirección(id));
    }

    @GetMapping("/link/search")
    public ResponseEntity<List<LinkDTO>> ObtenerTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(linkService.obtenerTodos());
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkEstadisticaDTO> estadisticaLink(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(linkService.estadisticaLink(id));
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<Boolean> invalidarLink(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(linkService.validarLink(id));
    }
}
