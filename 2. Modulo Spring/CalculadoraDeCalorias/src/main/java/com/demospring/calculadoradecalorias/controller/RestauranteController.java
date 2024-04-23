package com.demospring.calculadoradecalorias.controller;

import com.demospring.calculadoradecalorias.dto.PlatoRequestDTO;
import com.demospring.calculadoradecalorias.dto.PlatoResponseDTO;
import com.demospring.calculadoradecalorias.service.IRestaurante;
import com.demospring.calculadoradecalorias.service.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestauranteController {
    @Autowired
    IRestaurante restaurante;

    @PostMapping(path = "/calcularPlato")
    public PlatoResponseDTO calcularUno(@RequestBody PlatoRequestDTO platoRequestDTO) {
        return restaurante.getCaloriasPlato(platoRequestDTO);
    }

    @PostMapping(path = "/calcularPlatos")
    public List<PlatoResponseDTO> calcularUno(@RequestBody List<PlatoRequestDTO> platosRequestDTO) {
        return restaurante.getCaloriasPlatos(platosRequestDTO);
    }
}
