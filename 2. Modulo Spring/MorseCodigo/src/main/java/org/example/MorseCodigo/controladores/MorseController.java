package org.example.MorseCodigo.controladores;

import org.example.MorseCodigo.service.Morse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/*Definicion de controlador REST*/
@RestController
public class MorseController {
    /* Peticion que indica que un método en un controlador debe ser invocado cuando se realiza una solicitud
    POST a una URL específica.
     */
    @PostMapping("/translateMorse")
    /*Funcion que recibe del body el codigo a traducir*/
    public String translateMorseCode(@RequestBody Morse morseCode) {
        return morseCode.translate();
    }
}

