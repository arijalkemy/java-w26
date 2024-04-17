package co.com.mercadolibre.autos.controller;

import co.com.mercadolibre.autos.entity.Vehicle;
import co.com.mercadolibre.autos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/{version}/vehicles")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Vehicle vehicle) {
        vehicleService.save(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(vehicleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getByManufacturingDate(@RequestParam String from, @RequestParam String to) {
        return new ResponseEntity<>(vehicleService.findByManufacuringDate(from, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getByPrice(@RequestParam Integer from, @RequestParam Integer to) {
        return new ResponseEntity<>(vehicleService.findByPrice(from, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(vehicleService.findById(id), HttpStatus.OK);
    }
}
