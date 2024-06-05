package org.meli.ejercicio_p4_d1_seguros_autos.controlador;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.meli.ejercicio_p4_d1_seguros_autos.dto.*;
import org.meli.ejercicio_p4_d1_seguros_autos.servicio.IService.IServiceVehiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
@AllArgsConstructor
public class ControladorVehiculo {
    private IServiceVehiculo serviceVehiculo;

    @PostMapping("/nuevo")
    public ResponseEntity<MensajeDTO> postVehiculo(@RequestBody VehiculoDtoRequest vehiculoDTO) {
        return new ResponseEntity<>(serviceVehiculo.nuevoVehiculo(vehiculoDTO), HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<VehiculoDTO>> listarTodosVehiculos() {
        return new ResponseEntity<>(serviceVehiculo.listarTodosVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> listarPorIdVehiculos(@PathVariable Long id) {
        return new ResponseEntity<>(serviceVehiculo.listarPorIdVehiculos(id), HttpStatus.OK);
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<VehiculoPatenteDto>> getPatentes() {
        return new ResponseEntity<>(serviceVehiculo.listarPatentesVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/patentes/marcas")
    public ResponseEntity<List<VehiculoPatenteMarcaDto>> getPatentesMarcas() {
        return new ResponseEntity<>(serviceVehiculo.listarPatentesMarcasVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/patentes/filtros")
    public ResponseEntity<List<VehiculoPatenteDto>> getFiltrosRuedasAgno() {
        return new ResponseEntity<>(serviceVehiculo.filtrarVehiculosPorRuedasAgno(), HttpStatus.OK);
    }

    @GetMapping("/siniestro/perdidas")
    public ResponseEntity<List<VehiculoMMMDto>> getListarLosVehicuConPerdida() {
        return new ResponseEntity<>(serviceVehiculo.listarVehiculosMMMsinDetallePerdida(), HttpStatus.OK);
    }

    @GetMapping("/siniestro/detallesdperdidas")
    public ResponseEntity<List<VehiculoDetallePerdida>> getListarLosVehicuConDetallePerdida() {
        return new ResponseEntity<>(serviceVehiculo.listarVehiculosDetallePerdidas(), HttpStatus.OK);
    }
}
