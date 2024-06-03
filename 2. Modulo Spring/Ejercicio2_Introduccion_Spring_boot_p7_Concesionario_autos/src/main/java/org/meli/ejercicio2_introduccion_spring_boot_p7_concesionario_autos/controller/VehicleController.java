package org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.controller;

import org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.dto.VehicleRequestDTO;
import org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleRequestDTO> addVehicle(@RequestBody VehicleRequestDTO vehicle) {
        return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.CREATED);
    }

    // 2. Retorna un listado de todos los usados seleccionados. No incluye services.
    @GetMapping
    public ResponseEntity<List<VehicleRequestDTO>> getAllUsedVehicles() {
        return new ResponseEntity<>(vehicleService.getAllUsedVehicles(), HttpStatus.OK);
    }

    // 3. Retorna el listado de los vehículos según fecha de fabricación.
    @GetMapping("/dates")
    public ResponseEntity<List<VehicleRequestDTO>> getVehiclesByManufacturingDate(
                @RequestParam("date") String date) {
        return new ResponseEntity<>(vehicleService.getVehiclesByManufacturingDate(date), HttpStatus.OK);
    }

    // 4. Muestra el listado de los vehículos según los precios dados.
    @GetMapping("/prices")
    public ResponseEntity<List<VehicleRequestDTO>> getVehiclesByPrices(
            @RequestParam("price") double price) {
        return new ResponseEntity<>(vehicleService.getVehiclesByPrices(price), HttpStatus.OK);
    }

    // 5. Muestra toda la información relacionada con el vehículo.
    @GetMapping("/{id}")
    public ResponseEntity<VehicleRequestDTO> getVehicleById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }

}
