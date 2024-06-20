package org.example.calculadoracalorias.controller;

import org.example.calculadoracalorias.dto.PlatoDTO;
import org.example.calculadoracalorias.dto.PlatoResponseDTO;
import org.example.calculadoracalorias.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @PostMapping("/calcular")
    public PlatoResponseDTO calcularCalorias(@RequestBody PlatoDTO platoDTO) {
        return platoService.calcularCalorias(platoDTO);
    }

    @PostMapping("/calcular/lista")
    public List<PlatoResponseDTO> calcularCaloriasDeLista(@RequestBody List<PlatoDTO> platosDTO) {
        return platoService.calcularCaloriasDeLista(platosDTO);
    }
}
