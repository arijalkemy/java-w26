package org.ggomezr.empresadeseguros.application.controller;

import org.ggomezr.empresadeseguros.application.service.impl.SinisterService;
import org.ggomezr.empresadeseguros.domain.dto.SinisterDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sinisters")
public class SinisterController {

    private final SinisterService sinisterService;

    public SinisterController(SinisterService sinisterService) {
        this.sinisterService = sinisterService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createSinister(@RequestBody SinisterDTO sinisterDTO){
        return new ResponseEntity<>(sinisterService.createSinister(sinisterDTO), HttpStatus.CREATED);
    }

    @PostMapping("/new/list")
    public ResponseEntity<?> createSinisters(@RequestBody List<SinisterDTO> sinisterDTOList){
        return new ResponseEntity<>(sinisterService.createSinisters(sinisterDTOList), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllSinisters(){
        return new ResponseEntity<>(sinisterService.getAllSinisters(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSinisterById(@PathVariable Long id){
        return new ResponseEntity<>(sinisterService.getSinisterById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSinister(@PathVariable Long id, @RequestBody SinisterDTO sinisterDTO){
        return new ResponseEntity<>(sinisterService.updateSinister(id, sinisterDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSinister(@PathVariable Long id){
        return new ResponseEntity<>(sinisterService.deleteSinister(id), HttpStatus.OK);
    }
}
