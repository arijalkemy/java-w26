package com.example.introspringcodigomorse.Controllers;

import com.example.introspringcodigomorse.Interfaces.IConvertidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertidorController {

    @Autowired
    private IConvertidor convertidor;

    @GetMapping("/convertirmorse/{codigoMorse}")
    public String convertirATexto(@PathVariable String codigoMorse){

        return convertidor.convertirATexto(codigoMorse);
    }

    @GetMapping("/convertirtexto/{texto}")
    public String convertirAMorse(@PathVariable String texto){
        return convertidor.convertirAMorse(texto);
    }

}
