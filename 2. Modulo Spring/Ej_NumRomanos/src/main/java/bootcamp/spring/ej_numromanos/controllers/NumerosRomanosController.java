package bootcamp.spring.ej_numromanos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.spring.ej_numromanos.services.NumerosRomanosService;

@RestController
@RequestMapping("numeros-romanos")
public class NumerosRomanosController {
    
    public final NumerosRomanosService numerosRomanosService;

    public NumerosRomanosController(NumerosRomanosService numerosRomanosService){
        this.numerosRomanosService = numerosRomanosService;
    }

    @GetMapping("/{numeroDecimal}")
    public ResponseEntity<String> convertirNumeroDecimalARomano(@PathVariable Integer numeroDecimal){
        try{
            String numeroRomano = this.numerosRomanosService.convertirNumero(numeroDecimal);
            return ResponseEntity.ok(numeroRomano);
        }
        catch(IllegalArgumentException e){
            ResponseEntity.badRequest().body(e.getMessage());
        }
        return null;
    }
}
