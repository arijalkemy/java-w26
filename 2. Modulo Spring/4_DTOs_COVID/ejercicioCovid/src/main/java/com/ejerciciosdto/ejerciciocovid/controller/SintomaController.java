package com.ejerciciosdto.ejerciciocovid.controller;


import com.ejerciciosdto.ejerciciocovid.dto.PersonaDTO;
import com.ejerciciosdto.ejerciciocovid.entidades.Persona;
import com.ejerciciosdto.ejerciciocovid.entidades.Sintoma;
import com.ejerciciosdto.ejerciciocovid.servicio.ServicioPersonaImpl;
import com.ejerciciosdto.ejerciciocovid.servicio.ServicioSintomaImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaController {
    ServicioSintomaImpl servicioSintoma = new ServicioSintomaImpl();
    @GetMapping("/buscarSintoma")
    @ResponseBody
    public List<Sintoma> getSintoma(){
        return servicioSintoma.getSintomas();
    }
    @GetMapping("/buscarSintoma/{nombre}")
    @ResponseBody
    public ResponseEntity buscarSintoma(@PathVariable String nombre){
        return servicioSintoma.getSintomas(nombre);
    }
}
