package com.CalculadoraDeCalorias.CalculadoraDeCalorias.controller;

import com.CalculadoraDeCalorias.CalculadoraDeCalorias.dto.IngredienteDTO;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.dto.PlatoIngredientesDTO;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.services.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {
    @Autowired
    IPlatoService platoService;

    @GetMapping("/{nombrePlato}/calorias")
    public ResponseEntity<?> obtenerCalorias(@PathVariable String nombrePlato)
    {
        int calorias = platoService.obtenerPlato(nombrePlato);
        System.out.println(calorias);
        return new ResponseEntity<>(calorias, HttpStatus.OK);
    }

    @GetMapping("/{nombrePlato}/ingredientes")
    public ResponseEntity<List<PlatoIngredientesDTO>> obtenerListaIngredientes(@PathVariable String nombrePlato)
    {
        List<PlatoIngredientesDTO> ingredientes = platoService.obtenerListaIngredientes(nombrePlato);
        System.out.println(ingredientes);
        if (ingredientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ingredientes, HttpStatus.OK);
    }

    @GetMapping("/{nombrePlato}/ingrediente-mas-calorico")
    public ResponseEntity<IngredienteDTO> obtenerIngredienteMayorCaloria(@PathVariable String nombrePlato){
        IngredienteDTO ingredienteDTO = platoService.obtenerIngredienteMayorCaloria(nombrePlato);
        if(ingredienteDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<IngredienteDTO>(ingredienteDTO, HttpStatus.OK);
    }


}
