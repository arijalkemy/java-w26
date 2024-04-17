package com.example.edad.controller;


import com.example.edad.service.IEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/")
public class EdadController {

    IEdad iEdad;

    @Autowired
    public EdadController(IEdad iEdad){
        this.iEdad = iEdad;
    }

    @GetMapping("ping")
    public String pingPong(){
        return "Pong!!";
    }

    @GetMapping("calcularEdad/{dia}/{mes}/{año}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int año){
        return iEdad.calcularEdad(dia,mes,año);

    }
}
