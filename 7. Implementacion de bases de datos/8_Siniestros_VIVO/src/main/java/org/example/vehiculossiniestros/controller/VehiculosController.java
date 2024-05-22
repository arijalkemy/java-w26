package org.example.vehiculossiniestros.controller;

import lombok.RequiredArgsConstructor;
import org.example.vehiculossiniestros.service.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VehiculosController {

    private final IVehiculoService vehiculoService;

    @GetMapping("/vehiculos/patentes")
    public ResponseEntity<?> getPatentesFromAllVehiculos(){
        return new ResponseEntity<>(
                vehiculoService.getPatentesFromAllVehiculos(),
                HttpStatus.OK
        );
    }

    @GetMapping("/vehiculos/patentes-and-marca")
    public ResponseEntity<?> getPatentesAndMarcaFromAllVehiculosOrdered(){
        return new ResponseEntity<>(
                vehiculoService.getPatenteAndMarcaFromVehiculoOrderByAnio(),
                HttpStatus.OK
        );
    }
}
