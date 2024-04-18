package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.controller;

import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.dto.VehicleDTO;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.dto.VehicleWhitoutServiceDTO;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity.Vehicle;
import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.service.interfaces.IConcesionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehiclesController {

    @Autowired
    IConcesionarioService concesionarioService;

    @PostMapping("/")
    public ResponseEntity<String> addVehicle(@RequestBody VehicleDTO vehicle) {
        concesionarioService.addVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body("Operación Éxitosa");
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleWhitoutServiceDTO>> getVehiclesWithoutServices() {
        List<VehicleWhitoutServiceDTO> vehicles = concesionarioService.getVehicles();
        if (vehicles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehicles);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getVehichlesByDates(
            @RequestParam("since") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate since,
            @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to
    ) {
        List<VehicleDTO> vehicles = concesionarioService.getVehiclesByDate(since, to);
        if (vehicles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehicles);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByPrice(
            @RequestParam("since") double since, @RequestParam("to") double to
    ) {
        List<VehicleDTO> vehicles = concesionarioService.getVehiclesByPrice(since, to);
        if (vehicles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Integer id) {
        VehicleDTO vehicle = concesionarioService.getVehicleById(id);
        if (vehicle == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehicle);
    }


}
