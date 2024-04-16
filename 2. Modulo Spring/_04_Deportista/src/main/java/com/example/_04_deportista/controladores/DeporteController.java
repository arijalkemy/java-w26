package com.example._04_deportista.controladores;

import com.example._04_deportista.model.Deporte;
import com.example._04_deportista.servicios.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    @Autowired
    IDeporteService iDeporte;

    @GetMapping("/findSports")
    @ResponseBody
    public List<Deporte> obtenerDeportes(){
        return iDeporte.obtenerDeportes();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Integer> obtenerUnDeporte(@PathVariable String name){
        int nivel = iDeporte.obtenerNivelDeDeporte(name);

        if(nivel == 0)
            return new ResponseEntity<>(nivel, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(nivel, HttpStatus.OK);
    }
}
