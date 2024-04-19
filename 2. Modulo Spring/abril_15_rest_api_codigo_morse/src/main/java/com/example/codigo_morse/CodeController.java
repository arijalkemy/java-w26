package com.example.codigo_morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeController {

    @GetMapping("/")
    public String index(@RequestParam String code){

        Codigo codigo = new Codigo();
        return codigo.deCode(code);

    }

}
