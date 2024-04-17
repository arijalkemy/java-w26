package org.example._08calculadoradecalorias.Controller;

import org.example._08calculadoradecalorias.DTO.CaloriasPlatoDTO;
import org.example._08calculadoradecalorias.DTO.IngredienteDTO;
import org.example._08calculadoradecalorias.DTO.PlatoDTO;
import org.example._08calculadoradecalorias.Service.ICalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CalculadoraDeCaloriasController {

    @Autowired
    ICalculadoraService calculadoraService;

    @GetMapping("/calorias")
    public ResponseEntity<CaloriasPlatoDTO> calcularCalorias(@RequestParam String nombre, @RequestParam int peso){
        CaloriasPlatoDTO caloriasPlatoDTO = calculadoraService.calcularCaloriasDe(nombre, peso);
        if (caloriasPlatoDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(caloriasPlatoDTO);
    }

    @GetMapping("/ingredientes")
    public ResponseEntity<List<IngredienteDTO>> obtenerIngredientes(@RequestParam String nombre){
        return ResponseEntity.ok().body(calculadoraService.obtenerIngredientesDe(nombre));
    }

    @GetMapping("/maxCalorias")
    public ResponseEntity<IngredienteDTO> obtenerIngredienteConMasCalorias(@RequestParam String nombre){
        return ResponseEntity.ok().body(calculadoraService.obtenerIngredienteConMasCaloriasDe(nombre));
    }

}
