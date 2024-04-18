package com.numerosRomanos.demo.controllers;


import com.numerosRomanos.demo.services.IConvertirRomanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertirRomanoController {

    @Autowired
    IConvertirRomanoService convertirRomanoService;

   @GetMapping("/{numero}")
    public String convertirRomano(@PathVariable Integer numero) {

       return convertirRomanoService.convertirRomano(numero);
   }
}
