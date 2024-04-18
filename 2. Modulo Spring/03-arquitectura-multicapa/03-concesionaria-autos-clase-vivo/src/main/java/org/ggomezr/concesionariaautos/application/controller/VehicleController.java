package org.ggomezr.concesionariaautos.application.controller;

import org.ggomezr.concesionariaautos.application.service.impl.VehicleService;
import org.ggomezr.concesionariaautos.domain.dto.VehicleDTO;
import org.ggomezr.concesionariaautos.domain.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping()
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
        Vehicle vehicleCreated = vehicleService.createVehicle(vehicle);
        if(vehicleCreated != null) return new ResponseEntity<>(HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping()
    public ResponseEntity<List<VehicleDTO>> getAllVehicles(){
        List<VehicleDTO> vehicles = vehicleService.getAllVehicles();
        if(!vehicles.isEmpty()) return new ResponseEntity<>(vehicles, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByManufacturingDate(@RequestParam LocalDate since, @RequestParam LocalDate to){
        List<VehicleDTO> vehicles = vehicleService.getVehiclesByManufacturingDate(since, to);
        if(!vehicles.isEmpty()) return new ResponseEntity<>(vehicles, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByPriceRange(@RequestParam Integer since, @RequestParam Integer to){
        List<VehicleDTO> vehicles = vehicleService.getVehiclesByPriceRange(since, to);
        if(!vehicles.isEmpty()) return new ResponseEntity<>(vehicles, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Integer id){
        VehicleDTO vehicleDTO = vehicleService.getVehicleById(id);
        if(vehicleDTO != null) return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
