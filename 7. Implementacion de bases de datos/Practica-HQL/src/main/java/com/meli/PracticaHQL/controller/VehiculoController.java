package com.meli.PracticaHQL.controller;

import com.meli.PracticaHQL.dto.PatenteDto;
import com.meli.PracticaHQL.model.Siniestro;
import com.meli.PracticaHQL.model.Vehiculo;
import com.meli.PracticaHQL.repository.VehiculoRepository;
import com.meli.PracticaHQL.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private IVehiculoService iVehiculoService;

    @GetMapping("/patentes")
    public ResponseEntity<List<PatenteDto>> getPatentes(){
        return ResponseEntity.ok(iVehiculoService.getPatentes());
    }

    @GetMapping("/patentesYMarcas")
    public ResponseEntity<List<PatenteDto>> getPatentesYMarcas(){
        return ResponseEntity.ok(iVehiculoService.getPatentesYMarcas());
    }

    @GetMapping("/conCuatroRuedas")
    public ResponseEntity<List<String>> getVehiculosConCuatroRuedas(){
        return ResponseEntity.ok(iVehiculoService.getVehiculosConCuatroRuedas());
    }


    @PostMapping("/new")
    public Vehiculo createVehiculo(@RequestBody Vehiculo vehiculo){
        return iVehiculoService.save(vehiculo);
    }

}
