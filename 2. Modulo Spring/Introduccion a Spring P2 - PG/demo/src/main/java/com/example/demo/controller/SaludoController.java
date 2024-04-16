package com.example.demo.controller;

import com.example.demo.service.SaludoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/saludos")
public class SaludoController {

    @Autowired
    SaludoService saludoService;

    @GetMapping
    public String saludo(){
       return "Hola mundo";
   }

   @GetMapping("/primero/{name}")
    public String otroSaludo(@PathVariable String name){
        return saludoService.saludar(name);
   }
}
