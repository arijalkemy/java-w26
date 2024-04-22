package com.autos.concesionaria.controller;

import com.autos.concesionaria.dto.VehiculoDTO;
import com.autos.concesionaria.entity.Vehiculo;
import com.autos.concesionaria.repository.IRepositorioVehiculos;
import com.autos.concesionaria.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class ConcesionariaRestController {

    @Autowired
    IVehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<String> postAgregarVehiculo(@RequestBody Vehiculo vehiculo){
        vehiculoService.agregarVehiculo(vehiculo);
        return ResponseEntity.ok().body("Creado con exito!");
    }

    @GetMapping()
    public ResponseEntity<List<VehiculoDTO>> getUsados(){
        return ResponseEntity.ok().body(vehiculoService.mostrarVehiculosUsados());
    }

    @GetMapping("/fechas")
    public ResponseEntity<List<Vehiculo>> getVehiculosFecha(@RequestParam LocalDate inicio, @RequestParam LocalDate fin){
        return ResponseEntity.ok().body(vehiculoService.mostrarVehiculoPorFecha(inicio, fin));
    }

    @GetMapping("/precio")
    public ResponseEntity<List<Vehiculo>> getVehiculosPrecio(@RequestParam Integer inicio, @RequestParam Integer fin){
        return ResponseEntity.ok().body(vehiculoService.mostrarVehiculoPorPrecio(inicio, fin));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoId(@PathVariable Integer id){
        return ResponseEntity.ok().body(vehiculoService.mostrarVehiculoPorId(id));
    }

}
