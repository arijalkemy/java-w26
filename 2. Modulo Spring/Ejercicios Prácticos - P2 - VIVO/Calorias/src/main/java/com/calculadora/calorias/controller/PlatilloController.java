package com.calculadora.calorias.controller;

import com.calculadora.calorias.dto.PlatilloDTO;
import com.calculadora.calorias.service.PlatilloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatilloController {

    @Autowired
    private PlatilloService platilloService;

    @GetMapping("/platillo")
    public ResponseEntity<?> getPlatillo(@RequestBody PlatilloDTO platillo) {
        return new ResponseEntity<>(platilloService.getPlatillo(platillo), HttpStatus.OK);
    }

    @GetMapping("/platillosMultiple")
    public ResponseEntity<?> getPlatillo(@RequestBody List<PlatilloDTO> platillos) {
        return new ResponseEntity<>(platilloService.getPlatillosFilter(platillos), HttpStatus.OK);
    }

    @GetMapping("/platillos")
    public ResponseEntity<?> getPlatillo() {
        return new ResponseEntity<>(platilloService.getPlatillos(), HttpStatus.OK);
    }

    @GetMapping("/ingredientes")
    public ResponseEntity<?> getIngredientes() {
        return new ResponseEntity<>(platilloService.getIngredientes(), HttpStatus.OK);
    }
}
