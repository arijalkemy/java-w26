package meli.bootcamp.hql.controller;

import jakarta.validation.Valid;
import java.util.List;
import meli.bootcamp.hql.dto.PatenteYMarcaDto;
import meli.bootcamp.hql.dto.VehiculoReqDto;
import meli.bootcamp.hql.dto.VehiculoResDto;
import meli.bootcamp.hql.service.IVehiculosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculos")
public class VehiculosController {
    IVehiculosService vehiculosService;

    public VehiculosController(IVehiculosService vehiculosService) {
        this.vehiculosService = vehiculosService;
    }

    @PostMapping("/all")
    public ResponseEntity<List<VehiculoResDto>> saveAllVehiculos(
        @RequestBody List<@Valid VehiculoReqDto> vehiculoReqDtoList
    ) {
        return ResponseEntity.ok(vehiculosService.saveAll(vehiculoReqDtoList));
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<String>> findAllPatentes() {
        return ResponseEntity.ok(vehiculosService.findAllPatentes());
    }

    @GetMapping("/patentes-marcas-ordenadas-por-anio-fabricacion")
    public ResponseEntity<List<PatenteYMarcaDto>> findAllPatentesYMarcasOrdenadasPorAnioFabricacion(
        @RequestParam(required = false, defaultValue = "desc") String orden
    ) {
        return ResponseEntity.ok(vehiculosService.findAllPatentesYMarcasOrdenadas(orden));
    }

    @GetMapping("patentes-mas-de-cuatro-ruedas-fabricados-este-anio")
    public ResponseEntity<List<String>> findAllPatentesDeMasDeCuatroRuedasFabricadosEsteAnio() {
        return ResponseEntity.ok(
            vehiculosService.findAllPatentesDeMasDeCuatroRuedasFabricadosEsteAnio());
    }
}
