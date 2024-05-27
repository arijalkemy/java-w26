package org.example.tiendadeprendas.controller;

import org.example.tiendadeprendas.dto.PrendaDto;
import org.example.tiendadeprendas.service.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/clothes")
@RestController
public class PrendaController {
    @Autowired
    IPrendaService prendaService;

    @PostMapping
    public ResponseEntity<?> postPrenda(@RequestBody PrendaDto prendaDto) {
        prendaService.createPrenda(prendaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Prenda creada");
    }
    @PutMapping("{code}")
    public ResponseEntity<?> putPrenda(@PathVariable String code, @RequestBody PrendaDto prendaDto) {
        prendaService.updatePrenda(code, prendaDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<PrendaDto>> getAllPrendas(){
        List<PrendaDto> prendasDto = prendaService.allPrendas();
        return new ResponseEntity<>(prendasDto, HttpStatus.OK);
    }

    @GetMapping("/getByCode/{code}")
    public ResponseEntity<PrendaDto> getPrendaByCode(@PathVariable String code){
        PrendaDto prendaDto = prendaService.findByCode(code);
        return new ResponseEntity<>(prendaDto, HttpStatus.OK);
    }

    @GetMapping("/getBySize/{size}")
    public ResponseEntity<List<PrendaDto>> getPrendasBySize(@PathVariable String size){
        List<PrendaDto> prendasDto = prendaService.prendasBySize(size);
        return new ResponseEntity<>(prendasDto, HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deletePrendaByCode(@PathVariable String code){
        prendaService.deletePrenda(code);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{name}", params = "name")
    public ResponseEntity<?> getPrendaByName(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(prendaService.findPrendasByName(name));
    }

}
