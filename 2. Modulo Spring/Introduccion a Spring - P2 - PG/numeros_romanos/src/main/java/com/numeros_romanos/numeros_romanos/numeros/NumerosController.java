package com.numeros_romanos.numeros_romanos.numeros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/numeros")
public class NumerosController {

    @Autowired
    INumeroConversion numeroConversion;

    @GetMapping("{decimalNumber}")
    public String nombres(@PathVariable String decimalNumber){
        try{
            return numeroConversion.conversionNumero(decimalNumber);
        }catch (IllegalArgumentException ex){
            return HttpStatus.NOT_ACCEPTABLE + " " + ex.getMessage();
        }catch (Exception ex){
            return HttpStatus.NOT_ACCEPTABLE + " " + ex.getMessage();
        }
    }

}
