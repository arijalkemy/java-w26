package org.example.numerosromanos.controllers;

import org.example.numerosromanos.interfaces.IConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class NumerosRomanosController {

    @Autowired
    private IConvert convert;

    @GetMapping("/v1/{num}")
    public String convertir(@PathVariable("num") Integer num) {
        return convert.convert(num);
    }
}
