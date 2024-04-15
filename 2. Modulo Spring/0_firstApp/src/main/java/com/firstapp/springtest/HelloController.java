package com.firstapp.springtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludos")
public class HelloController {
    @GetMapping("/primero/{name}")
    public String index(@PathVariable String name){
        return "Salu2 " + name;
    }
}
