package com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.controller;

import com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.dto.PlatoDTO;
import com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.service.IContadorCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalculadoraCaloriasController {

    @Autowired
    IContadorCaloriasService contadorCaloriasService;

    @GetMapping("/calorias")
    public ResponseEntity<List<PlatoDTO>> getCalorias(@RequestParam List<String> entrada) {
        List<PlatoDTO> platos = new ArrayList<>();
        if (entrada.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        for (int i = 0; i < entrada.size(); i++) {
            String[] plato = entrada.get(i).split("-");
            platos.add(new PlatoDTO(plato[0], Integer.parseInt(plato[1])));
        }
        return ResponseEntity.status(HttpStatus.OK).body(contadorCaloriasService.getCaloriasPlato(platos));
    }

}
