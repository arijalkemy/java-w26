package org.ggomezr.empresadeseguros.application.controller;

import org.ggomezr.empresadeseguros.application.service.impl.VehicleService;
import org.ggomezr.empresadeseguros.domain.dto.VehicleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
     return new ResponseEntity<>(vehicleService.createVehicle(vehicleDTO), HttpStatus.CREATED);
    }

    @PostMapping("/new/list")
    public ResponseEntity<?> createVehicles(@RequestBody List<VehicleDTO> vehicleDTOList) {
        return new ResponseEntity<>(vehicleService.createVehicles(vehicleDTOList), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVehicle(@PathVariable Long id, @RequestBody VehicleDTO vehicleDTO) {
        return new ResponseEntity<>(vehicleService.updateVehicle(id, vehicleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.OK);
    }

    @GetMapping("/distinct-plates")
    public ResponseEntity<?> getAllByPatents() {
        return new ResponseEntity<>(vehicleService.getAllByPatents(), HttpStatus.OK);
    }

    @GetMapping("/order/fabrication-year")
    public ResponseEntity<?> getAllByPatentAndBrandOrderByFabricationYear() {
        return new ResponseEntity<>(vehicleService.getAllByPatentAndBrandOrderByFabricationYear(), HttpStatus.OK);
    }

    @GetMapping("/order/wheels/fabrication-year")
    public ResponseEntity<?> getAllByPatentWithMoreThanFourWheelsAndFabricatedThisYear() {
        return new ResponseEntity<>(vehicleService.getAllByPatentWithMoreThanFourWheelsAndFabricatedThisYear(), HttpStatus.OK);
    }

    @GetMapping("/order/sinister/economic-loss")
    public ResponseEntity<?> getAllBySinisterEconomicLossGreaterThan10000() {
        return new ResponseEntity<>(vehicleService.getAllBySinisterEconomicLossGreaterThan10000(), HttpStatus.OK);
    }

    @GetMapping("/order/sinister/economic-loss/details")
    public ResponseEntity<?> getAllVehiclesWithMajorLosses() {
        return new ResponseEntity<>(vehicleService.getAllVehiclesWithMajorLosses(), HttpStatus.OK);
    }
}
