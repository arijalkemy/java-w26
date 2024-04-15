package com.codigoMorse.codigoMorse.controller;

import com.codigoMorse.codigoMorse.service.ICodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CodigoMorse")
public class CodigoMorseController {
    @Autowired
    ICodigoMorseService codigoMorseService;
    @GetMapping("/{codigo}")
    public String decodeMorse(@PathVariable String codigo)
    {
        return codigoMorseService.decodeCodigoMorse(codigo);
    }


}
