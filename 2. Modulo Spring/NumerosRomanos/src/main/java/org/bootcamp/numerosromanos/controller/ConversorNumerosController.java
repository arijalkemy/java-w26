package org.bootcamp.numerosromanos.controller;

import org.bootcamp.numerosromanos.service.ConversorNumerosServiceImpl;
import org.bootcamp.numerosromanos.service.IConversorNumerosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/Conversor")
public class ConversorNumerosController {

    private IConversorNumerosService conversorNumerosService;

    public ConversorNumerosController() {
        conversorNumerosService=new ConversorNumerosServiceImpl();
    }

    @GetMapping("/NumeroRomanoADecimal/{nroRomano}")
    public ResponseEntity<?> conversorNumeroRomanoADecimal(@PathVariable String nroRomano) {
        return ResponseEntity.ok(conversorNumerosService.convertirNroRomanoADecimal(nroRomano.toUpperCase()));
    }

    @GetMapping("/NumeroDecimalARomano/{nroDecimal}")
    public ResponseEntity<?> conversorNumeroDecimalARomano(@PathVariable Integer nroDecimal) {
        return ResponseEntity.ok(conversorNumerosService.convertirNroDecimalARomano(nroDecimal));
    }

}
