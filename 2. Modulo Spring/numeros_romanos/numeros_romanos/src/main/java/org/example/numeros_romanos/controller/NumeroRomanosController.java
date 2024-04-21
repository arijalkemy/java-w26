package org.example.numeros_romanos.controller;

import org.example.numeros_romanos.services.IRomanoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NumeroRomanosController {

    @Autowired
    IRomanoServices romanoServices;

    @GetMapping("/romano/{numero}")
    public ResponseEntity<String > numeroRomano(@PathVariable("numero") int numero) {
        try {
            return  ResponseEntity.ok(romanoServices.convertirARomano(numero));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }
    @GetMapping("/numero/{romano}")
    public ResponseEntity<Integer> numeroDecimal(@PathVariable("romano") String romano) {
        try {
            return ResponseEntity.ok(romanoServices.convertirAEntero(romano));
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(-1);
        }

    }
}
