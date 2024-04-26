package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    /*@GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }*/
    /*EJERCICIO 1*/
    @PostMapping("/vehicles")
    public ResponseEntity<String> saveData(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(this.vehicleService.saveData(vehicleDto), HttpStatus.OK);
    }

    /*@GetMapping("/id/{id}")
    public ResponseEntity<List<VehicleDto>> searchById(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.searchById(id), HttpStatus.OK);
    }*/

    @GetMapping("/range/weight")
    public  ResponseEntity<?> searchByRange(@RequestParam(name = "max") double max, @RequestParam(name = "min") double min){
        return  new ResponseEntity<>(vehicleService.searchByRange(min,max), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public  ResponseEntity<?> searchBrandAvg(@PathVariable String brand){
        return  new ResponseEntity<>(vehicleService.searchByFuel(brand), HttpStatus.OK);
    }

    @GetMapping("vehicles/fuel_type/{type}")
    public  ResponseEntity<?> searchByFuel(@PathVariable String type){
        return  new ResponseEntity<>(vehicleService.searchByFuel(type), HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}/update_fuel")
    public  ResponseEntity<?> changeData(@PathVariable Long id, @RequestParam String fuel_type){
        return  new ResponseEntity<>(vehicleService.changeData(id, fuel_type), HttpStatus.OK);
    }

}
