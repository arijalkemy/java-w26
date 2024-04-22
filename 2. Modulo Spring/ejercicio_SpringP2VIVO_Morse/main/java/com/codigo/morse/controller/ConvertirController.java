package com.codigo.morse.controller;

import com.codigo.morse.service.IConvertirService;
import com.codigo.morse.service.impl.ConvertirServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("codigo")
public class ConvertirController {

    @Autowired
    private IConvertirService convertirService;

    @GetMapping("/morse/{codigoMorse}")
    public String codigoMorseATexto(@PathVariable String codigoMorse){
        return convertirService.convertirDeMorseANormal(codigoMorse);
    }

    @GetMapping("/normal/{fraseNormal}")
    public String normalAMorse(@PathVariable String fraseNormal){
        return convertirService.convertirDeNormalAMorse(fraseNormal);
    }

}
