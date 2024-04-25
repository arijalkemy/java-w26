package org.example._09concesionaria.Controller;

import org.example._09concesionaria.DTO.AddVehicleRequestDTO;
import org.example._09concesionaria.DTO.AddVehicleResponseDTO;
import org.example._09concesionaria.DTO.GetVehicleWithoutServicesDTO;
import org.example._09concesionaria.Service.ICarShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class CarShopController {

    @Autowired
    ICarShopService carShopService;

    @PostMapping
    public ResponseEntity<Integer> addVehicle(@RequestBody AddVehicleRequestDTO vehicle) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carShopService.createVehicle(vehicle));
    }

    @GetMapping("")
    public ResponseEntity<List<GetVehicleWithoutServicesDTO>> getAllVehicles() {
        return ResponseEntity.status(HttpStatus.OK).body(carShopService.retrieveAllVehicles());
    }
}
