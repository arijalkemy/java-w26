package org.example.integradorcodereview.controller;

import org.example.integradorcodereview.dto.VehicleDto;
import org.example.integradorcodereview.entity.Vehicle;
import org.example.integradorcodereview.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicles")
public class VehicleController {

    @Autowired
    IVehicleService vehicleService;


    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<?> getAllVehicles(){
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{vehicle_id}")
    @ResponseBody
    public ResponseEntity<?> getVehicleById(@PathVariable Long vehicle_id){
        return new ResponseEntity<>(vehicleService.getVehicleById(vehicle_id), HttpStatus.OK);
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDto), HttpStatus.CREATED);
    }

    @GetMapping("/color/{color}/year/{year}")
    @ResponseBody
    public ResponseEntity<?> findVehicleColorYear(@PathVariable String color, @PathVariable Integer year){
        return new ResponseEntity<>(vehicleService.findVehiclesColorYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}/between/{startYear}/{endYear}")
    @ResponseBody
    public ResponseEntity<?> findVehicleBrandYearRange(@PathVariable String brand, @PathVariable Integer startYear, @PathVariable Integer endYear){
        return new ResponseEntity<>(vehicleService.findVehiclesBrandYearRange(brand, startYear, endYear), HttpStatus.OK);
    }

    @GetMapping("/average_speed/brand/{brand}")
    @ResponseBody
    public ResponseEntity<?> getVehicleBrandSpeedAverage(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getBrandVehicleAvgSpeed(brand), HttpStatus.OK);
    }

    @PostMapping("/batch")
    @ResponseBody
    public ResponseEntity<?> addMassiveVehicleList(@RequestBody List<VehicleDto> vehicleDtoList){
        return new ResponseEntity<>(vehicleService.addMassiveVehicle(vehicleDtoList), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update_speed")
    @ResponseBody
    public ResponseEntity<?> updateVehicleSpeed(@RequestBody VehicleDto vehicleDto, @PathVariable Long id){
        return new ResponseEntity<>(vehicleService.updateVehicleSpeed(id, vehicleDto), HttpStatus.OK);
    }

    @GetMapping("/fuel_type/{type}")
    @ResponseBody
    public ResponseEntity<?> getVehiclesFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.findVehicleFuelType(type), HttpStatus.OK);
    }

    @GetMapping("/transmission/{type}")
    @ResponseBody
    public ResponseEntity<?> getVehiclesTransmissionType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.findVehicleTransmissionType(type), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.OK);
    }

    @GetMapping("/average_capacity/brand/{brand}")
    @ResponseBody
    public ResponseEntity<?> getVehicleBrandPassengersAverage(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getBrandVehiclePassengersAvg(brand), HttpStatus.OK);
    }

    @GetMapping("/dimensions")
    @ResponseBody
    public ResponseEntity<?> getVehiclesMeasuresRange(
            @RequestParam("length") String heightRange,
            @RequestParam("width") String widthRange
    ){
        String [] strHeight = heightRange.split("-");
        String [] strWidth = widthRange.split("-");

        return new ResponseEntity<>(vehicleService.findVehiclesMeasuresRange(
                Double.parseDouble(strHeight[0]),
                Double.parseDouble(strHeight[1]),
                Double.parseDouble(strWidth[0]),
                Double.parseDouble(strWidth[1])),HttpStatus.OK);
    }

    @GetMapping("/weight")
    @ResponseBody
    public ResponseEntity<?> getVehiclesWeightRange(
            @RequestParam("min") Double min,
            @RequestParam("max") Double max
    ){
        return new ResponseEntity<>(vehicleService.findVehiclesWeightRange(min, max), HttpStatus.OK);
    }













}
