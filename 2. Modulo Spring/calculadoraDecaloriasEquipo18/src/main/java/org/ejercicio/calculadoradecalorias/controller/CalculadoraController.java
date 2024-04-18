package org.ejercicio.calculadoradecalorias.controller;

import org.ejercicio.calculadoradecalorias.dto.PlatoDTO;
import org.ejercicio.calculadoradecalorias.dto.PlatoResponseDTO;
import org.ejercicio.calculadoradecalorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plato")
public class CalculadoraController {


    @Autowired
    IPlatoService platoService;

    @GetMapping()
    public PlatoResponseDTO calculadora(@RequestBody PlatoDTO platoDTO) {
        return platoService.informacionPlato(platoDTO);
    }
}
