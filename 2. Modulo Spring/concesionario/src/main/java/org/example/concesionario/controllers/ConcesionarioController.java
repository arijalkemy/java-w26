package org.example.concesionario.controllers;


import org.example.concesionario.dto.ResponseVehiculeDTO;
import org.example.concesionario.entity.VehicleEntity;
import org.example.concesionario.service.IConcensionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
public class ConcesionarioController {

    @Autowired
    IConcensionarioService concesionarioService;



    @PostMapping("/vehicles")
    ResponseEntity <VehicleEntity> nuevoVehicles(@RequestBody VehicleEntity vehicle){
        return ResponseEntity.ok().body(concesionarioService.nuevoAuto(vehicle));
    }

    //@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "sin lista de vehiculos")
    @GetMapping("/vehicles")
    ResponseEntity< List<ResponseVehiculeDTO>>  listarVehiculos() {
        List<ResponseVehiculeDTO> resp = concesionarioService.todosVehiculos();
        if(resp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
        }
        return ResponseEntity.ok().body(concesionarioService.todosVehiculos());
    }

    @GetMapping("/vehicles/dates")
    public List<ResponseVehiculeDTO> vehiclesPorFecha(@RequestParam LocalDate since, @RequestParam LocalDate to) {
        return concesionarioService.vehiculosPorFecha(since, to);
    }

    @GetMapping("/vehicle/price")
    public List<ResponseVehiculeDTO> price(@RequestParam double since, @RequestParam double to) {
        return concesionarioService.vehiculosPorPrecio(since, to);
    }

    @GetMapping("/vehicle/{id}")
    public List<ResponseVehiculeDTO> priceById(@PathVariable UUID id) {
        return concesionarioService.vehiculoPorId(id);
    }



}
