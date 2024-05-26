package org.example.siniestrovehicle.controller;

import org.example.siniestrovehicle.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(@Autowired IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(vehicleService.getAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patentes-marcas")
    public ResponseEntity<?> getAllMarcaPatente() {
        return new ResponseEntity<>(vehicleService.getAllPatentesMarcaOrder(), HttpStatus.OK);
    }

    @GetMapping("/patentes-marcas-ruedas")
    public ResponseEntity<?> getAllMarcaPatenteAnioCurrent() {
        return new ResponseEntity<>(vehicleService.getAllPatenteAnioFabricacion(), HttpStatus.OK);
    }
}
