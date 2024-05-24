package org.ejercicio.hqlvehiculos.controller;

import org.ejercicio.hqlvehiculos.DTO.VehiculoDTO;
import org.ejercicio.hqlvehiculos.DTO.VehiculosPerdidaTotalDTO;
import org.ejercicio.hqlvehiculos.service.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vehiculos")
public class VehiculoController {

    private IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping()
    public ResponseEntity<List<VehiculoDTO>> listarVehiculosRegistrados() {
        return new ResponseEntity<>(vehiculoService.obtenerTodosVehiculos(),HttpStatus.OK);
    }

    @GetMapping("listar-fecha")
    public ResponseEntity<?> listarVehiculosPorFecha(@RequestParam Integer anio) {
        return new ResponseEntity<>(vehiculoService.obtenerVehiculoOrdenadoPorAnioDeFabricacion()
                ,HttpStatus.OK);
    }

    @GetMapping("listar-mas4-ruedas-y-anio")
    public ResponseEntity<?> listarVehiculosMasCuatroRuedasEnAnioActual() {
        return new ResponseEntity<>(vehiculoService.obtenerVehiculoFabricadosEnElAnioActualConRuedasSuperioresA(),
                HttpStatus.OK);
    }

    @GetMapping("listar-siniestro-mayor-DiezMil")
    public ResponseEntity<VehiculosPerdidaTotalDTO> listarVehiculosSiniestroMayorADiezMil() {
        return new ResponseEntity<>(
                vehiculoService.obtenerVehiculoSiniestroMayorADiezMil(),
                HttpStatus.OK);
    }

    @GetMapping("listar-siniestro-mayor-diezMil-total")
    public ResponseEntity<List<VehiculoDTO>> listarVehiculosSiniestroMayorADiezMilYTotal() {
        return new ResponseEntity<>(
                vehiculoService.obtenerVehiculoSiniestroMayorADiezMilYTotal(),
                HttpStatus.OK);
    }
}
