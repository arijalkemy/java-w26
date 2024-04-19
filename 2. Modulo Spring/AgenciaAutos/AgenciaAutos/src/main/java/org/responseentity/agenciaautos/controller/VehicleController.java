package org.responseentity.agenciaautos.controller;

import org.responseentity.agenciaautos.dto.VehicleDTOWithServices;
import org.responseentity.agenciaautos.dto.VehicleDTOWithoutServices;
import org.responseentity.agenciaautos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("")
    public List<VehicleDTOWithoutServices> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailsOfVehicle(@PathVariable("id")UUID id){
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertVehicle(@RequestBody VehicleDTOWithServices vehicle){
        vehicleService.addVehicle(vehicle);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> searchVehiclesByDateRange(
            @RequestParam("since") String since,
            @RequestParam("to") String to
    )
    {
        List<VehicleDTOWithoutServices> vehiclesFilteredByDateRange =
                vehicleService.getVehiclesByDateRange(
                        LocalDate.parse(since),
                        LocalDate.parse(to)
                );

        return new ResponseEntity<>(vehiclesFilteredByDateRange, HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> searchVehiclesByPriceRange(
            @RequestParam("since") int since,
            @RequestParam("to") int to
    ){
        List<VehicleDTOWithoutServices> vehiclesFilteredByPriceRange =
                vehicleService.getVehiclesByPriceRange(since, to);

        return new ResponseEntity<>(vehiclesFilteredByPriceRange, HttpStatus.OK);
    }
}
