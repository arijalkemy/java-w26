package com.example.multicapatemplate.controller;

import com.example.multicapatemplate.dto.VehiculoDto;
import com.example.multicapatemplate.model.Vehiculo;
import com.example.multicapatemplate.service.IConcesionariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/V1/api/vehicles")
public class ConcesionariaController {

    @Autowired
    IConcesionariaService concesionariaService;

    @PostMapping()
    public ResponseEntity<String> add(@RequestBody Vehiculo vehiculo ){
        concesionariaService.save(vehiculo);
        return new ResponseEntity<>( "Se Agrego un vehiculo", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<VehiculoDto> vehiculos = concesionariaService.getAll();

        if( vehiculos.isEmpty() ){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getByDate(@RequestParam LocalDate fechaDesde, @RequestParam LocalDate fechaHasta ){
        List<VehiculoDto> vehiculos = concesionariaService.getAll(fechaDesde,fechaHasta);

        if( vehiculos.isEmpty() ){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getByPrice(@RequestParam double precioDesde, @RequestParam double precioHasta ){
        List<VehiculoDto> vehiculos = concesionariaService.getAll(precioDesde,precioHasta);

        if( vehiculos.isEmpty() ){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

    @GetMapping("/{placa}")
    public ResponseEntity<?> getByPlaca(@PathVariable String placa){

        VehiculoDto vehiculo = concesionariaService.getVehiculoByPlaca(placa);
        if( vehiculo == null ){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehiculo, HttpStatus.OK);
    }

}
