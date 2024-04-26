package org.example.calorias.controller;

import org.example.calorias.dto.PlatoDTO;
import org.example.calorias.dto.PlatoIngredienteDTO;
import org.example.calorias.dto.PlatoIngredientesDTO;
import org.example.calorias.service.IPlatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatosController {

    @Autowired
    private IPlatos iPlatos;

    @GetMapping
    public ResponseEntity<List<PlatoDTO>> getPlatos() {
        return new ResponseEntity<>(iPlatos.caloriasPlatos(), HttpStatus.OK);
    }

    @GetMapping("/ingredientes")
    public ResponseEntity<List<PlatoIngredientesDTO>> getIngredientesPlatos() {
        return new ResponseEntity<>(iPlatos.ingredientesPlatos(), HttpStatus.OK);
    }

    @GetMapping("/ingrediente")
    public ResponseEntity<List<PlatoIngredienteDTO>> getIngredienteMayoCaloriasPlatos() {
        return new ResponseEntity<>(iPlatos.ingredienteMayorCaloriasPlatos(), HttpStatus.OK);
    }
}
