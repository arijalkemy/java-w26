package org.example.vehiculossiniestros.controller;

import lombok.RequiredArgsConstructor;
import org.example.vehiculossiniestros.service.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehiculos")
public class VehiculosController {

    private final IVehiculoService vehiculoService;

    @GetMapping("/patentes")
    public ResponseEntity<?> getPatentesFromAllVehiculos(){
        return new ResponseEntity<>(
                vehiculoService.getPatentesFromAllVehiculos(),
                HttpStatus.OK
        );
    }

    @GetMapping("/patentes-and-marca")
    public ResponseEntity<?> getPatentesAndMarcaFromAllVehiculosOrdered(){
        return new ResponseEntity<>(
                vehiculoService.getPatenteAndMarcaFromVehiculoOrderByAnio(),
                HttpStatus.OK
        );
    }

    @GetMapping("/more-than-four-wheels-and-this-year")
    public ResponseEntity<?> getPatentesMoreThan4WheelsAndManufacturedThisYear(){
        return new ResponseEntity<>(
                vehiculoService.getPatenteFromVehiculosWithMoreThan4WheelsAndManufacturedThisYear(),
                HttpStatus.OK
        );
    }

    @GetMapping("/big-sinister")
    public ResponseEntity<?> getVehiculosWithBigSinister(){
        return new ResponseEntity<>(
                vehiculoService.getPatenteMarcaModeloWhereSiniestroIsBig(),
                HttpStatus.OK
        );
    }

    @GetMapping("/big-sinister/total")
    public ResponseEntity<?> getVehiculosAndTotalLossWithBigSinister(){
        return new ResponseEntity<>(
                vehiculoService.getPatenteMarcaModeloAndTotalLossWhereSiniestroIsBig(),
                HttpStatus.OK
        );
    }
}
