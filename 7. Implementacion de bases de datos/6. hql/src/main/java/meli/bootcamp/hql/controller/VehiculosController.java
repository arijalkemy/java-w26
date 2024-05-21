package meli.bootcamp.hql.controller;

import jakarta.validation.Valid;
import java.util.List;
import meli.bootcamp.hql.dto.VehiculoReqDto;
import meli.bootcamp.hql.dto.VehiculoResDto;
import meli.bootcamp.hql.service.IVehiculosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
