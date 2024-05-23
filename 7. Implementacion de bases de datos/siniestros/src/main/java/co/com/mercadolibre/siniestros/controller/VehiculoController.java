package co.com.mercadolibre.siniestros.controller;

import co.com.mercadolibre.siniestros.service.IVehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> listarTodasLasPatentes() {
        return ResponseEntity.ok(vehiculoService.listarTodasLasPatentes());
    }

    @GetMapping("/patenteyMarca")
    public ResponseEntity<?> listarPatentesYMarcaOrdenadoPorAnio() {
        return ResponseEntity.ok(vehiculoService.listarPatentesYMarcaOrdenadoPorAnio());
    }

    @GetMapping("/patentesConMasDeCuatroRuedas")
    public ResponseEntity<?> listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio() {
        return ResponseEntity.ok(vehiculoService.listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio());
    }

    @GetMapping("/matriculaMarcaModelo")
    public ResponseEntity<?> listarMatriculaMarcaYModeloConSiniestroMayor() {
        return ResponseEntity.ok(vehiculoService.listarMatriculaMarcaYModeloConSiniestroMayor());
    }

    @GetMapping("/MatriculaMarcaModeloYPerdidaTotal")
    public ResponseEntity<?> listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor() {
        return ResponseEntity.ok(vehiculoService.listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor());
    }
}
