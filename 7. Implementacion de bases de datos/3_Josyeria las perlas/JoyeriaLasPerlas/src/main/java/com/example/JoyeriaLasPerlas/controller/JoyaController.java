package com.example.JoyeriaLasPerlas.controller;

import com.example.JoyeriaLasPerlas.model.Joya;
import com.example.JoyeriaLasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    @Autowired
    IJoyaService joyaServ;

    @PostMapping("/new")
    public String saveJoya (@RequestBody Joya joya) {
        return joyaServ.saveJoya(joya);
    }

    @GetMapping("/")
    public List<Joya> getJoyas () {
        return joyaServ.getJoyas();
    }

    //como es un borrado lógico, se trata más bien de un update y no de un delete
    //por eso usamos put
    @PutMapping("/delete/{id}")
    public String deleteJoya (@PathVariable Long id) {
        return joyaServ.deleteJoya(id);
    }

    @PutMapping ("/update/{id_modificar}")
    public String editJoya (@PathVariable Long id_modificar,
                            @RequestBody Joya joya) {
        return joyaServ.editJoya(id_modificar, joya);
    }
}
